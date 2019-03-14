package com.mettaerpapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mettaerpapi.domain.Categoria;
import com.mettaerpapi.domain.ClienteEmpresa;
import com.mettaerpapi.repository.CategoriaReporitory;
import com.mettaerpapi.repository.ClienteEmpresaRepository;
import com.mettaerpapi.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaReporitory categoriaRepository;
	
	@Autowired
	private ClienteEmpresaRepository clienteEmpresaRepository;
	
	public Categoria findById(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() 
				-> new ObjectNotFoundException("Categoria não encontrada! Codigo:" 
						+ id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
	
	public List<Categoria> listarCat(Long id) {
		Optional<ClienteEmpresa> empresa = clienteEmpresaRepository.findById(id);
		return categoriaRepository.findByEmpresa(empresa);
	}
	
	public Categoria save(Categoria categoria) {
		Categoria cat = categoriaRepository.save(categoria);
		
		return cat;
	}
}
