package com.uca.capas.services;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Sucursal;

public interface SucursalService {
	
	public List<Sucursal> getAllSucursales() throws DataAccessException;
	
	public Sucursal insertNewStore(Sucursal newStore) throws DataAccessException;
	
	public void deleteStore(int id) throws DataAccessException;
	
	public Sucursal getOneById(int id) throws DataAccessException;
	
}
