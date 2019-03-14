package com.mettaerpapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mettaerpapi.domain.Usuario;
import com.mettaerpapi.repository.UsuarioRepository;
import com.mettaerpapi.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return usuario.orElseThrow(() 
				-> new ObjectNotFoundException("Usuário não encontrada! Codigo:" 
						+ id ));
	}
}
