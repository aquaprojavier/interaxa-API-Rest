package com.interaxa.api.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDto {
	
	private Long id;
	@NotBlank(message="El nombre no debe estar vacio")
	private String nombre;
	@NotBlank(message="El apellido no debe estar vacio")
	private String apellido;
	@Min(10000000)
	@Max(70000000)
	private long dni;
	@NotNull
	private String empleado;
}
