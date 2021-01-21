package com.gft.desafio.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gft.desafio.api.model.Fornecedor;
import com.gft.desafio.api.repository.FornecedorRepository;
import com.gft.desafio.api.repository.filtro.Filtro;

@Service
public class FornecedorService {
	@Autowired
	FornecedorRepository fornecedorRepository;

	public Fornecedor atualizar (Long id, Fornecedor fornecedor) {
		Fornecedor fornecedorSalvo = fornecedorRepository.findById(id).orElse(null);
		if (fornecedorSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(fornecedor, fornecedorSalvo, "id");
		return fornecedorRepository.save(fornecedorSalvo);
	}
	
	public List<Fornecedor> filtrar (Filtro filtro) {
		String nome = filtro.getNome() == null ? "" : filtro.getNome();
		return  fornecedorRepository.findByNomeContaining(nome);
	}
}