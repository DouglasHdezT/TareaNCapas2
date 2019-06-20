package com.uca.capas.services;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Sucursal;

public interface SucursalService {
	
	public List<Sucursal> getAllSucursales();
	
	public Sucursal insertNewStore(Sucursal newStore);
	
	public void deleteStore(int id) throws DataAccessException;
	
	public Sucursal getOneById(int id) throws DataAccessException;
	
}
