package com.mettaerpapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mettaerpapi.domain.Cliente;
import com.mettaerpapi.domain.Endereco;
import com.mettaerpapi.repository.ClienteRepository;
import com.mettaerpapi.repository.EnderecoRepository;
import com.mettaerpapi.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Cliente findById(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() 
				-> new ObjectNotFoundException("Categoria não encontrada! Codigo:" 
						+ id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public Cliente save(Cliente cliente) {
		Endereco endereco = saveEndereco(cliente.getEndereco());
		cliente.setEndereco(endereco);
		return clienteRepository.save(cliente); 
	}
	
	public Endereco saveEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
}
