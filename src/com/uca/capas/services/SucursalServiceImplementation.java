package com.uca.capas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	@Transactional(rollbackFor = Exception.class )
	public Sucursal insertNewStore(Sucursal newStore) {
		return sucursalrepository.save(newStore);
	}

	@Override
	@Transactional(rollbackFor = Exception.class )
	public void deleteStore(int id) {
		sucursalrepository.deleteById(id);
	}
	
	

}
