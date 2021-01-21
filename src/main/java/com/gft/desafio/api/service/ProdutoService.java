package com.gft.desafio.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gft.desafio.api.model.Produto;
import com.gft.desafio.api.repository.ProdutoRepository;
import com.gft.desafio.api.repository.filtro.Filtro;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto atualizar(Long id, Produto produto) {
		Produto produtoSalvo = produtoRepository.findById(id).orElse(null);
		if (produtoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(produto, produtoSalvo,"id");
		return produtoRepository.save(produtoSalvo);
	}
	
	public List<Produto> filtrar(Filtro filtro) {
		String nome = filtro.getNome() == null ? "" : filtro.getNome();
		return produtoRepository.findByNomeContaining(nome);
	}
}