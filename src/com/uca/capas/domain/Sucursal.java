package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema="public",name="sucursal")
public class Sucursal {

	@Id
	@Column(name = "codigo")
	@GeneratedValue(generator = "sucursal_codigo_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sucursal_codigo_seq", sequenceName = "public.sucursal_codigo_seq", allocationSize = 1)
	private Integer _id;
	
	@NotEmpty(message = "Nombre de local requerido")
	@Column(name = "nombre")
	private String name;
	
	@NotEmpty(message = "Dirección de local requerido")
	@Column(name = "ubicacion")
	private String location;
	
	@NotEmpty(message = "Hora de apertura de local requerido")
	@Column(name = "horario_apertura")
	private String openingSchedule;
	
	@NotEmpty(message = "Hora de cierre de local requerido")
	@Column(name = "horario_cierre")
	private String closingSchedule;
	
	@NotNull(message = "Cantidad de mesas requerido")
	@Min(value = 1, message = "La cantidad de mesas no debe ser menor a 1")
	@Column(name = "nmesas")
	private Integer numSpaces;
	
	@NotEmpty(message = "Nombre del gerente requerido")
	@Column(name = "nomgerente")
	private String managerName;
	
	@OneToMany(mappedBy = "office", fetch = FetchType.LAZY)
	private List<Empleado> employeesList;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOpeningSchedule() {
		if(openingSchedule != null) {
			String[] result = openingSchedule.split(":");
			if(result[0].length() == 1) {
				result[0] ="0"+result[0]; 
			}
			
			return result[0]+":"+result[1];
		}else {
			return openingSchedule;
		}
	}

	public void setOpeningSchedule(String openingSchedule) {
		this.openingSchedule = openingSchedule;
	}

	public String getClosingSchedule() {
		if(closingSchedule != null) {

			String[] result = closingSchedule.split(":");
			if(result[0].length() == 1) {
				result[0] ="0"+result[0]; 
			}
			
			return result[0]+":"+result[1];
		}else {
			return closingSchedule;
		}
		
	}

	public void setClosingSchedule(String closingSchedule) {
		this.closingSchedule = closingSchedule;
	}

	public Integer getNumSpaces() {
		return numSpaces;
	}

	public void setNumSpaces(Integer numSpaces) {
		this.numSpaces = numSpaces;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public List<Empleado> getEmployeesList() {
		return employeesList;
	}

	public void setEmployeesList(List<Empleado> employeesList) {
		this.employeesList = employeesList;
	}
	
	
	
}
