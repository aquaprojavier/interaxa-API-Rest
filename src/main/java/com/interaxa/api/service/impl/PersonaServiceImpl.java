package com.interaxa.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interaxa.api.dto.PersonaDto;
import com.interaxa.api.entity.Persona;
import com.interaxa.api.exception.UserNotFoundException;
import com.interaxa.api.mapper.PersonaMapper;
import com.interaxa.api.repository.IPersonaRepository;
import com.interaxa.api.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepository personaRepository;

	@Autowired
	private PersonaMapper mapper;

	@Override
	public List<PersonaDto> findAll() {
		List<Persona> personas = personaRepository.findAll();
		return mapper.entityList2Dtos(personas);
	}

	@Override
	public PersonaDto findById(Long id) throws UserNotFoundException {
		Persona persona = personaRepository.findById(id).orElse(null);
		if (persona!=null) {
			return mapper.entity2Dto(persona);
		}else {
			throw new UserNotFoundException("No se encontro el usuario con el id: "+id);
		}
		
	}

	@Override
	public PersonaDto save(PersonaDto dto) {
		Persona persona = mapper.dto2Entity(dto);
		Persona personaSaved = personaRepository.save(persona);
		return mapper.entity2Dto(personaSaved);
	}

	@Override
	public PersonaDto update(Long id, PersonaDto dto) throws UserNotFoundException {
		Persona persona = personaRepository.findById(id).orElse(null);
		if (persona!=null) {
		persona.setNombre(dto.getNombre());
		persona.setApellido(dto.getApellido());
		persona.setDni(dto.getDni());
		persona.setEmpleado(dto.getEmpleado());
		personaRepository.save(persona);
		return mapper.entity2Dto(persona);
		}else {
			throw new UserNotFoundException("No se encontro el usuario con el id: "+id);
		}
	}

	@Override
	public void delete(Long id) {
		personaRepository.deleteById(id);
	}

}
