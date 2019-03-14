package com.mettaerpapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mettaerpapi.domain.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long>{

}
