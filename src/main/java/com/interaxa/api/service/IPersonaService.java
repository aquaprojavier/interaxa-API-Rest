package com.interaxa.api.service;

import java.util.List;

import com.interaxa.api.dto.PersonaDto;
import com.interaxa.api.exception.UserNotFoundException;

public interface IPersonaService {
	
	List <PersonaDto> findAll();
		
	PersonaDto findById(Long id) throws UserNotFoundException;
	
	PersonaDto save(PersonaDto dto);
	
	PersonaDto update (Long id, PersonaDto dto) throws UserNotFoundException;
	
	void delete (Long id);
}
