package com.mettaerpapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mettaerpapi.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
