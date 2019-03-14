package com.mettaerpapi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mettaerpapi.domain.Fornecedor;
import com.mettaerpapi.repository.EnderecoFornecedorRepository;
import com.mettaerpapi.repository.FornecedorRepository;
import com.mettaerpapi.services.exceptions.ObjectNotFoundException;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private EnderecoFornecedorRepository enderecoRepesitory;
	
	public Fornecedor findById(Long id) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		return fornecedor.orElseThrow(() 
				-> new ObjectNotFoundException("Fornecedor não encontrado! Codigo:" 
						+ id + ", Tipo: " + Fornecedor.class.getName()));
	}
	
	public List<Fornecedor> listar() {
		return fornecedorRepository.findAll();
	}
	
	@Transactional
	public Fornecedor save(Fornecedor obj) {
		obj = fornecedorRepository.save(obj);
		enderecoRepesitory.saveAll(obj.getEnderecos());
		return obj;
	}
}
