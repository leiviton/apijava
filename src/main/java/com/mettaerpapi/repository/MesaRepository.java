package com.mettaerpapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mettaerpapi.domain.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long>{

}
