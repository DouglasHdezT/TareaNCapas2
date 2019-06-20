package com.uca.capas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Empleado;
import com.uca.capas.repositories.EmpleadoRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Override
	public Empleado getOneEmployeeById(Integer id) {
		return empleadoRepository.findOneBy_id(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class )
	public void deleteEmpleado(Integer id) {
		empleadoRepository.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class )
	public void insertEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);
		
	}

}
