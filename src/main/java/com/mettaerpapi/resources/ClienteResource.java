package com.mettaerpapi.resources;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mettaerpapi.domain.Cliente;
import com.mettaerpapi.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CLIENTE') and #oauth2.hasScope('read')")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(clienteService.listar());
	}
	
	@GetMapping(value = "/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CLIENTE') and #oauth2.hasScope('read')")
	public ResponseEntity<?> find(@PathVariable Long id) {
		return clienteService.findById(id) != null ? 
				ResponseEntity.ok().body(clienteService.findById(id)) :
					ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CLIENTE') and #oauth2.hasScope('read')")
	public ResponseEntity<?> save(@Valid @RequestBody Cliente cliente, 
			HttpServletResponse response) {
		
		Cliente cli = clienteService.save(cliente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(cli.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(cli);
	}
}
