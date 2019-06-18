package com.uca.capas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Sucursal;
import com.uca.capas.repositories.SucursalRepository;

@Service
public class SucursalServiceImplementation implements SucursalService {

	@Autowired
	SucursalRepository sucursalrepository;
	
	@Override
	public List<Sucursal> getAllSucursales() {
		return sucursalrepository.findAll();
	}

}
