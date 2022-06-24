package com.interaxa.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interaxa.api.dto.PersonaDto;
import com.interaxa.api.exception.UserNotFoundException;
import com.interaxa.api.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService personaService;

	@GetMapping
	public ResponseEntity<List<PersonaDto>> getAllPersonas() {
		List<PersonaDto> response = personaService.findAll();
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersonaDto> showPersona(@PathVariable Long id) throws UserNotFoundException {
		PersonaDto response = personaService.findById(id);
		return ResponseEntity.ok().body(response);
	}

	@PostMapping
	public ResponseEntity<PersonaDto> savePersona(@RequestBody @Valid PersonaDto dto) {
		PersonaDto response = personaService.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PersonaDto> updatePersona(@PathVariable Long id, @RequestBody PersonaDto dto) throws UserNotFoundException {
		PersonaDto response = personaService.update(id, dto);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
		personaService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
