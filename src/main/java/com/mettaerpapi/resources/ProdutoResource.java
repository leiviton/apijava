package com.mettaerpapi.resources;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mettaerpapi.domain.Produto;
import com.mettaerpapi.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return !produtoService.listar().isEmpty() ? ResponseEntity.ok().body(produtoService.listar()):ResponseEntity.notFound().build();
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Long id) {
		return produtoService.findById(id) != null ? ResponseEntity.ok().body(produtoService.findById(id)) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@Valid @RequestBody Produto produto, HttpServletResponse response) {
		Produto prod = produtoService.save(produto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(prod.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(prod);
	}

}
