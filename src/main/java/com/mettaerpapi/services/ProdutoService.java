package com.mettaerpapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mettaerpapi.domain.Categoria;
import com.mettaerpapi.domain.Produto;
import com.mettaerpapi.repository.ProdutoRepository;
import com.mettaerpapi.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto findById(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow(() 
				-> new ObjectNotFoundException("Produto não encontrado! Codigo:" 
						+ id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
	
}
