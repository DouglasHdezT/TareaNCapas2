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

@Entity(name="sucursal")
public class Sucursal {

	@Id
	@Column(name = "codigo")
	@GeneratedValue(generator = "sucursal_codigo_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sucursal_codigo_seq", schema = "public")
	private Integer _id;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "ubicacion")
	private String location;
	
	@Column(name = "horario_apertura")
	private String openingSchedule;
	
	@Column(name = "horario_cierre")
	private String closingSchedule;
	
	@Column(name = "nmesas")
	private Integer numChairs;
	
	@Column(name = "nomgerente")
	private String managerName;
	
	@OneToMany(mappedBy = "office", fetch = FetchType.LAZY)
	private List<Empleado> employeesList;

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
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
		return openingSchedule;
	}

	public void setOpeningSchedule(String openingSchedule) {
		this.openingSchedule = openingSchedule;
	}

	public String getClosingSchedule() {
		return closingSchedule;
	}

	public void setClosingSchedule(String closingSchedule) {
		this.closingSchedule = closingSchedule;
	}

	public Integer getNumChairs() {
		return numChairs;
	}

	public void setNumChairs(Integer numChairs) {
		this.numChairs = numChairs;
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
