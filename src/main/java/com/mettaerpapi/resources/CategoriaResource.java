package com.mettaerpapi.resources;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mettaerpapi.domain.Categoria;
import com.mettaerpapi.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value="/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	public ResponseEntity<?> find(@PathVariable Long id) {
		Categoria categoria = categoriaService.findById(id);
		return categoria != null ? ResponseEntity.ok().body(categoria): ResponseEntity.notFound().build();
	}
	
	@GetMapping(value="/listar/{id}")
	public ResponseEntity<?> findByEmpresa(@PathVariable Long id) {
		return !categoriaService.listarCat(id).isEmpty() ? ResponseEntity.ok().body(categoriaService.listarCat(id)):ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return !categoriaService.listar().isEmpty() ? ResponseEntity.ok().body(categoriaService.listar()):ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria cat = categoriaService.save(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(cat.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(cat);
	}
	
}
