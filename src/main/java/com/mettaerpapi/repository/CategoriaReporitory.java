package com.mettaerpapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mettaerpapi.domain.Categoria;
import com.mettaerpapi.domain.ClienteEmpresa;

@Repository
public interface CategoriaReporitory extends JpaRepository<Categoria, Long>{

	public List<Categoria> findByEmpresa(Optional<ClienteEmpresa> empresa);
}
