package com.gft.desafio.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gft.desafio.api.event.RecursoCriadoEvent;
import com.gft.desafio.api.model.Venda;
import com.gft.desafio.api.repository.VendaRepository;
import com.gft.desafio.api.repository.filtro.Filtro;
import com.gft.desafio.api.service.VendaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Venda")
@RestController
@RequestMapping("/vendas")
public class VendaResource {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@ApiOperation("Listar todas as vendas")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping
	public List<Venda> listar() {
		return vendaRepository.findAll();
	}
	
	@ApiOperation("Paginação vendas")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping("/page")
	public Page<Venda> listar( @PageableDefault(page = 0, size = 5) Pageable pageable) {
		return vendaRepository.findAll(pageable);
	}
	
	@ApiOperation("Cadastrar vendas")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Venda> criar (@ApiParam(value = "Representação de uma nova venda")
		@Valid @RequestBody Venda venda,  HttpServletResponse response) {
		Venda vendaSalva = vendaService.salvar(venda);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, vendaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaSalva);
	}
	
	@ApiOperation("Atualizar venda")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@PutMapping("{id}")
	public ResponseEntity<Venda> atualizar(@PathVariable Long id, @Valid @RequestBody Venda venda) {
		Venda vendaSalva = vendaService.atualizar(id, venda);
		return ResponseEntity.ok(vendaSalva);
	}
	
	@ApiOperation("Exclui venda")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id)  {
		vendaRepository.deleteById(id);
	}
	
	@ApiOperation("Buscar venda por Id")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping("/{id}")
	public ResponseEntity<Venda> buscarPeloId(@ApiParam(value = "Id de uma venda", example = "1")@PathVariable Long id) {
		Venda venda = vendaRepository.findById(id).orElse(null);
		return venda != null ? ResponseEntity.ok(venda) : ResponseEntity.notFound().build();
	}
	
	@ApiOperation("Buscar venda de um cliente por nome")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping("/nome/{nome}")
	public List<Venda> buscarPeloNome(Filtro filtro) {
		List<Venda> vendas = vendaService.buscarClientePeloNome(filtro);
		return vendas;
	}
}