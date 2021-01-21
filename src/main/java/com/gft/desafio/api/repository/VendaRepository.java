package com.gft.desafio.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.desafio.api.model.Venda;

public interface  VendaRepository extends JpaRepository<Venda, Long>{
	//@Query( "from Venda v where v.cliente.nome = :nome") @Param("nome")
	public List<Venda> findByCliente_NomeContaining(String nome);
}