package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="empleado")
public class Empleado {

	@Id
	@Column(name = "codigo")
	@GeneratedValue(generator = "empleado_codigo_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "empleado_codigo_seq", schema = "public")
	private Integer _id;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "edad")
	private String age;
	
	@Column(name = "genero")
	private String gender;
	
	@Column(name = "estado")
	private Boolean status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sucursal")
	private Sucursal office;
	
}
