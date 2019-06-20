package com.uca.capas.services;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Empleado;

public interface EmployeeService {
	
	public Empleado getOneEmployeeById(Integer id) throws DataAccessException;
	
	public void deleteEmpleado(Integer id) throws DataAccessException;
	
	public void insertEmpleado(Empleado empleado) throws DataAccessException;

}
