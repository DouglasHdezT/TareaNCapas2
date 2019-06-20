package com.uca.capas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Sucursal;
import com.uca.capas.services.SucursalService;
import com.uca.capas.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SucursalService sucursalService;
	
	@RequestMapping(value = "/")
	public ModelAndView main() {
		ModelAndView mav= new ModelAndView();
		
		mav.setViewName("main");
		
		return mav;
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
		ModelAndView mav = new ModelAndView();
		
		
		if(userService.login(username, password)) {
			mav.setViewName("dashboard");
			mav.addObject("sucursales", sucursalService.getAllSucursales());
			mav.addObject("sucursal", new Sucursal());
		}else {
			mav.setViewName("main");
			mav.addObject("hasError", "yes");
			mav.addObject("response", "Credenciales invalidas");
		}
		
		return mav;
	}
	
}
