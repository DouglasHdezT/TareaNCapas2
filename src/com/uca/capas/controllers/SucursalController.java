package com.uca.capas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Empleado;
import com.uca.capas.domain.Sucursal;
import com.uca.capas.services.SucursalService;

@Controller
public class SucursalController {
	
	@Autowired
	SucursalService sucursalService;
	
	
	@RequestMapping("/dashboard")
	public ModelAndView dashboard() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("dashboard");
		
		mav.addObject("sucursal", new Sucursal());
		mav.addObject("sucursales", sucursalService.getAllSucursales());
		
		return mav;
	}
	
	@RequestMapping(value =  "/addStore", method = RequestMethod.POST)
	public ModelAndView addStore(@Valid @ModelAttribute Sucursal newSucursal, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("dashboard");
		
		if(!result.hasErrors()) {
			sucursalService.insertNewStore(newSucursal);
			mav.addObject("hasErrors", "No");
			mav.addObject("message", "Sucursal añadida correctamente");
			mav.addObject("sucursal", new Sucursal());
		}else {
			mav.addObject("hasErrors", "Yes");
			mav.addObject("hasErrorsForm", "Yes");
			mav.addObject("message", "Hubo un error al tratar de ingresar la sucursal");
			mav.addObject("sucursal", newSucursal);
		}
		
		mav.addObject("sucursales", sucursalService.getAllSucursales());
		
		
		return mav;
	}
	
	@RequestMapping("/deleteStore")
	public ModelAndView deleteStore(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView();
				
		mav.setViewName("dashboard");
		mav.addObject("sucursal", new Sucursal());
		
		try {
			sucursalService.deleteStore(id);
			mav.addObject("hasErrors", "No");
			mav.addObject("message", "Sucursal eliminada correctamente");
			
		}catch(Exception e) {
			e.printStackTrace();
			mav.addObject("hasErrors", "Yes");
			mav.addObject("message", "Hubo un error al tratar de eliminar la sucursal");
		}
		
		mav.addObject("sucursales", sucursalService.getAllSucursales());
		return mav;
	}
	
	@RequestMapping("/Store")
	public ModelAndView viewStoreData(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("singleStore");
		mav.addObject("employee", new Empleado());
		
		try {
			
			Sucursal store = sucursalService.getOneById(id);
			
			mav.addObject("store", store);
			mav.addObject("storeForm", store);
			mav.addObject("empleados", store.getEmployeesList());
			
		}catch (Exception e) {
			e.printStackTrace();
			mav.addObject("hasErrors", "Yes");
			mav.addObject("message", "Sucursal no encontrada.");
			mav.addObject("storeForm", new Sucursal());
		}
		
		return mav;
	}
	
	
	@RequestMapping("/editStore")
	public ModelAndView editStore(@ModelAttribute("storeForm") @Valid Sucursal storeForm, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("singleStore");
		
		mav.addObject("storeForm", storeForm);
		mav.addObject("employee", new Empleado());
		
		if(result.hasErrors()) {
			mav.addObject("hasErrorsForm", "Yes");
			mav.addObject("hasErrors", "Yes");
			mav.addObject("message", "Hubo un error al tratar de editar la sucursal");
			
		}else {
			try {
				sucursalService.insertNewStore(storeForm);
				
				mav.addObject("hasErrors", "No");
				mav.addObject("message", "Sucursal editada con éxito");
			}catch (Exception e) {
				e.printStackTrace();
				mav.addObject("hasErrors", "Yes");
				mav.addObject("message", "Hubo un error al tratar de editar la sucursal");
			}
		}
		
		try {
			
			Sucursal realStore = sucursalService.getOneById(storeForm.getId());
			mav.addObject("store", realStore);
			mav.addObject("empleados", realStore.getEmployeesList());
			
		}catch (Exception e) {
			e.printStackTrace();
			mav.addObject("hasErrors", "Yes");
			mav.addObject("message", "Sucursal no encontrada.");
			mav.addObject("store", new Sucursal());
		}
		
		return mav;
	}
	
	
}
