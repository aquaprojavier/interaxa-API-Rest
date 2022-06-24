package com.interaxa.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql= "UPDATE personas SET deleted = true WHERE persona_id=?")// para aplicar el SoftDelete
@Where(clause = "deleted=false")
@Table(name = "personas")
public class Persona implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "persona_id")	
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private long dni;
	
	private String empleado;
	
	private boolean deleted = Boolean.FALSE;
	
	private static final long serialVersionUID = 1L;

}
