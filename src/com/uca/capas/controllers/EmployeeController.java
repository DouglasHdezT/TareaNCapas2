package com.uca.capas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Empleado;

@Controller
public class EmployeeController {

	
	@RequestMapping(value  = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView insertEmployee(@RequestParam("id") int id_store ,@ModelAttribute("employee") @Valid Empleado employee,
			BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("");
		
		if(result.hasErrors()) {
			
		}else {
			
		}
		
		
		return mav;
	}
	
}
