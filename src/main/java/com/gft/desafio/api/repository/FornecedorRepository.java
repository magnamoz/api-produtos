package com.gft.desafio.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.desafio.api.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

	public List<Fornecedor> findByNomeContaining(String nome);
	
	public List<Fornecedor> findAllByOrderByNomeAsc();
	
	public List<Fornecedor> findAllByOrderByNomeDesc();
}