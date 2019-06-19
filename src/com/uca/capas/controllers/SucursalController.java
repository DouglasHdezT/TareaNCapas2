package com.uca.capas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Sucursal;
import com.uca.capas.services.SucursalService;

@Controller
public class SucursalController {
	
	@Autowired
	SucursalService sucursalService;
	
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
	
}
