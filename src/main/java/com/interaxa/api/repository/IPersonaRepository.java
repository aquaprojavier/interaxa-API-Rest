package com.interaxa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interaxa.api.entity.Persona;

public interface IPersonaRepository extends JpaRepository<Persona, Long>{

}
