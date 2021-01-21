package com.gft.desafio.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
import com.gft.desafio.api.model.Cliente;
import com.gft.desafio.api.repository.ClienteRepository;
import com.gft.desafio.api.repository.filtro.Filtro;
import com.gft.desafio.api.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Cliente")
@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private ClienteService clienteService;

	@ApiOperation("Listar todos os clientes")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@ApiOperation("Cadastrar cliente")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Cliente> criar(@ApiParam(value = "Representação de um novo cliente")
		@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
		Cliente clienteSalvo = clienteRepository.save(cliente);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, clienteSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
	}
	
	@ApiOperation("Buscar cliente por Id")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPeloId(@ApiParam(value = "Id de um cliente", example = "1")@PathVariable Long id) {
		//Cliente cliente = clienteRepository.findById(id).orElse(null);
		Cliente cliente = clienteService.buscarClientePeloId(id);
		return cliente != null ? ResponseEntity.ok(cliente) :  ResponseEntity.notFound().build();
	}
	
	@ApiOperation("Exclui cliente")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}
	
	@ApiOperation("Atualizar cliente")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		Cliente clienteSalvo = clienteService.atualizar(id, cliente);
		return ResponseEntity.ok(clienteSalvo);
	}
	
	@ApiOperation("Buscar cliente por nome")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping("/nome/{nome}")
	public List<Cliente> buscarPeloNome(Filtro filtro) {
		List<Cliente> clientes = clienteService.filtrar(filtro);
		return clientes;
	}
	
	@ApiOperation("Listar os clientes em ordem crescente")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping("/asc")
	public List<Cliente> ordenacaoAsc() {
		return  clienteRepository. findAllByOrderByNomeAsc();
	}
	
	@ApiOperation("Listar os clientes em ordem decrescente")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping("/desc")
	public List<Cliente> ordenacaoDesc() {
		return  clienteRepository. findAllByOrderByNomeDesc();
	}
}