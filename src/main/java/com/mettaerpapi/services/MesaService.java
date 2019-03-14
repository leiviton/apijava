package com.mettaerpapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mettaerpapi.domain.Mesa;
import com.mettaerpapi.repository.MesaRepository;
import com.mettaerpapi.services.exceptions.ObjectNotFoundException;

@Service
public class MesaService {

	@Autowired
	private MesaRepository mesaRepository;
	
	public List<Mesa> listar() {
		return mesaRepository.findAll();
	}
	
	public Mesa findById(Long id) {
		Optional<Mesa> mesa = mesaRepository.findById(id);
		return mesa.orElseThrow(() 
				-> new ObjectNotFoundException("Mesa não encontrada! Codigo:" 
						+ id + ", Tipo: " + Mesa.class.getName()));
	}
	
	public Mesa save(Mesa mesa) {
		return mesaRepository.save(mesa);
	}
}
