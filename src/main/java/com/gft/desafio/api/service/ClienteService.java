package com.gft.desafio.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gft.desafio.api.model.Cliente;
import com.gft.desafio.api.repository.ClienteRepository;
import com.gft.desafio.api.repository.filtro.Filtro;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente atualizar (Long id, Cliente cliente) {
		Cliente clienteSalvo = buscarClientePeloId(id);
		BeanUtils.copyProperties(cliente, clienteSalvo, "id");
		return clienteRepository.save(clienteSalvo);
	}

	public Cliente buscarClientePeloId(Long id) {
		Cliente clienteSalvo =  clienteRepository.findById(id).orElse(null);
		if (clienteSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return clienteSalvo;
	}

	public List<Cliente> filtrar(Filtro filtro) {
		String nome = filtro.getNome() == null ? "" : filtro.getNome();
		return clienteRepository.findByNomeContaining(nome);
	}
}