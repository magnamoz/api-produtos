package com.gft.desafio.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.desafio.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findByNomeContaining(String nome);
	
	public List<Produto>  findAllByOrderByNomeAsc();
	
	public List<Produto> findAllByOrderByNomeDesc();
}