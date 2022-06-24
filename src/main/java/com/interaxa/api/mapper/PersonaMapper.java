package com.interaxa.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.interaxa.api.dto.PersonaDto;
import com.interaxa.api.entity.Persona;

@Component
public class PersonaMapper {
	
	public Persona dto2Entity (PersonaDto dto) {
		Persona entity = new Persona();
		entity.setNombre(dto.getNombre());
		entity.setApellido(dto.getApellido());
		entity.setDni(dto.getDni());
		entity.setEmpleado(dto.getEmpleado());
		return entity;		
	}
	
	public PersonaDto entity2Dto (Persona entity) {
		PersonaDto dto = new PersonaDto();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setApellido(entity.getApellido());
		dto.setDni(entity.getDni());
		dto.setEmpleado(entity.getEmpleado());
		return dto;
	}
	
	public List<PersonaDto> entityList2Dtos (List<Persona> entities){
		List<PersonaDto> dtos = new ArrayList<>();
		for (Persona entity : entities) {
			dtos.add(entity2Dto(entity));
		}
		return dtos;		
	}
}
