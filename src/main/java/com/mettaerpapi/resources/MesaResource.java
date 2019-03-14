package com.mettaerpapi.resources;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mettaerpapi.domain.Mesa;
import com.mettaerpapi.services.MesaService;

@RestController
@RequestMapping(value="/mesas")
public class MesaResource {
	
	@Autowired
	private MesaService mesaService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Long id) {
		return mesaService.findById(id) != null ? ResponseEntity.ok().body(mesaService.findById(id)) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(mesaService.listar());
	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Mesa mesa, HttpServletResponse response) {
		Mesa obj = mesaService.save(mesa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(obj.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
}
