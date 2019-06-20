package com.uca.capas.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name="empleado")
public class Empleado {

	@Id
	@Column(name = "codigo")
	@GeneratedValue(generator = "empleado_codigo_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "empleado_codigo_seq", schema = "public")
	private Integer _id;
	
	@NotEmpty(message = "Nombre del empleado requerido")
	@Column(name = "nombre")
	private String name;
	
	@Min(value = 18, message = "El empleado no debe ser menor a 18 años")
	@Max(value = 60, message = "El empleado no puede ser mayor a 60 años")
	@NotNull(message = "El campo de edad es requerido")
	@Column(name = "edad")
	private String age;
	
	
	@Column(name = "genero")
	private String gender;
	
	@Column(name = "estado")
	private Boolean status;
	
	@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn(name = "sucursal")
	private Sucursal office;

	public Integer getId() {
		return _id;
	}

	public void setId(Integer _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Sucursal getOffice() {
		return office;
	}

	public void setOffice(Sucursal office) {
		this.office = office;
	}
	
	public String getGenderDelegate() {
		if(this.gender == "M") {
			return "Masculino";
		}else {
			return "Femenino";
		}
	}
	
	public String getStatusDelegate() {
		if(this.status) {
			return "Activo";
		}else {
			return "Inactivo";
		}
	}
	
}
