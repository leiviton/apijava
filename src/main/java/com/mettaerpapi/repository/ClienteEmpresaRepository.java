package com.mettaerpapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mettaerpapi.domain.ClienteEmpresa;

@Repository
public interface ClienteEmpresaRepository extends JpaRepository<ClienteEmpresa, Long> {

}
