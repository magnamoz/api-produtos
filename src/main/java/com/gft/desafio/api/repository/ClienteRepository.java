package com.gft.desafio.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.desafio.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	public List<Cliente> findByNomeContaining(String nome);
		
	public List<Cliente>  findAllByOrderByNomeAsc();
	
	public List<Cliente> findAllByOrderByNomeDesc();
}