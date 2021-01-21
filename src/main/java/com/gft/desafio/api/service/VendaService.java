package com.gft.desafio.api.service;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gft.desafio.api.model.Produto;
import com.gft.desafio.api.model.Venda;
import com.gft.desafio.api.repository.ProdutoRepository;
import com.gft.desafio.api.repository.VendaRepository;
import com.gft.desafio.api.repository.filtro.Filtro;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public Venda atualizar(Long id, Venda venda) {
		Venda vendaSalva = vendaRepository.findById(id).orElse(null);
		if (vendaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(venda, vendaSalva, "id");
		return vendaRepository.save(vendaSalva);
	}

	public Venda salvar(@Valid Venda venda) {
		somar(venda);
		diminuirQuantidade(venda);
		return vendaRepository.save(venda);
	}
		
	public List<Venda> buscarClientePeloNome(Filtro filtro) {
		String nome = filtro.getNome() == null ? "" : filtro.getNome();
		return vendaRepository.findByCliente_NomeContaining(nome);
	}

	private void diminuirQuantidade(Venda venda) {
		for (Produto produto : venda.getProdutos()) {
			Produto produtoPego = produtoRepository.findById(produto.getId()).orElseThrow();
			produtoPego.getQuantidade();
			int novaQuantidade = produtoPego.getQuantidade() - 1;
			produtoPego.setQuantidade(novaQuantidade);
		}
	}

	private void somar(Venda venda) {
		BigDecimal total = BigDecimal.ZERO;
		for (Produto produto : venda.getProdutos()) {
			Produto produtoPego = produtoRepository.findById(produto.getId()).orElseThrow();

			if (produtoPego.getPromocao() == true) {
				total = total.add(produtoPego.getValorPromo());
			} else {
				total = total.add(produtoPego.getValor());
			}
		}
		 venda.setTotalCompra(total);
	}
}