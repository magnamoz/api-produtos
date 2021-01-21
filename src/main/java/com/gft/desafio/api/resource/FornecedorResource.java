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
import com.gft.desafio.api.model.Fornecedor;
import com.gft.desafio.api.repository.FornecedorRepository;
import com.gft.desafio.api.repository.filtro.Filtro;
import com.gft.desafio.api.service.FornecedorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Fornecedor")
@RestController
@RequestMapping("/fornecedores")
public class FornecedorResource {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@ApiOperation("Listar todos os fornecedores")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping
	public List<Fornecedor> listar() {
		return fornecedorRepository.findAll();
	}
	
	@ApiOperation("Cadastrar fornecedores")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
 	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Fornecedor> criar (@ApiParam(value = "Representação de um novo fornecedor")
		@Valid @RequestBody Fornecedor fornecedor, HttpServletResponse response) {
		Fornecedor fornecedorSalvo = fornecedorRepository.save(fornecedor);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, fornecedorSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorSalvo);
	}
 	
	@ApiOperation("Buscar fornecedor por Id")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
 	@GetMapping("/{id}")
 	public ResponseEntity<Fornecedor> buscarPeloId(@ApiParam(value = "Id de um fornecedor", example = "1")@PathVariable Long id) {
 		Fornecedor fornecedor = fornecedorRepository.findById(id).orElse(null);
 		return fornecedor != null ? ResponseEntity.ok(fornecedor) :  ResponseEntity.notFound().build();
 	}
 	
	@ApiOperation("Atualizar fornecedor")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
 	@PutMapping("/{id}")
 	public ResponseEntity<Fornecedor> atualizar (@PathVariable Long id, @Valid @RequestBody Fornecedor fornecedor) {
 		Fornecedor fornecedorSalvo = fornecedorService.atualizar(id, fornecedor);
 		return ResponseEntity.ok(fornecedorSalvo);
 	}

	@ApiOperation("Exclui fornecedor")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
 	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@ApiParam(value = "Id de um fornecedor", example = "1")@PathVariable Long id) { 
 		fornecedorRepository.deleteById(id);
 	}
 	
	@ApiOperation("Buscar fornecedor por nome")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping("/nome/{nome}")
	public List<Fornecedor> buscarPeloNome(Filtro filtro) {
		List<Fornecedor> fornecedores = fornecedorService.filtrar(filtro);
		return fornecedores;
	}
	
	@ApiOperation("Listar os fornecedores em ordem crescente")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping("/asc")
	public List<Fornecedor> ordenacaoAsc() {
		return  fornecedorRepository. findAllByOrderByNomeAsc();
	}
	
	@ApiOperation("Listar os fornecedores em ordem decrescente")
	@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
	@GetMapping("/desc")
	public List<Fornecedor> ordenacaoDesc() {
		return  fornecedorRepository. findAllByOrderByNomeDesc();
	}
}