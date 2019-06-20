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
import com.uca.capas.services.EmployeeService;
import com.uca.capas.services.SucursalService;

@Controller
public class EmployeeController {

	@Autowired
	SucursalService sucursalService;
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value  = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView insertEmployee(@RequestParam("id_store") int id_store ,@ModelAttribute("employee") @Valid Empleado employee,
			BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("singleStore");
		Sucursal currentStore = sucursalService.getOneById(id_store);
		employee.setOffice(currentStore);
		
		if(result.hasErrors()) {
			mav.addObject("hasErrorsForm", "Yes");
			mav.addObject("hasErrors", "Yes");
			mav.addObject("message", "Error al momento de ingresar empleado");
			mav.addObject("employee", employee);
			
		}else {
			
			try {
				
				employeeService.insertEmpleado(employee);
				
				mav.addObject("hasErrors", "No");
				mav.addObject("message", "Empleado ingresado correctamente");
				mav.addObject("employee", new Empleado());
			}catch (Exception e) {
				e.printStackTrace();
				
				mav.addObject("hasErrors", "Yes");
				mav.addObject("message", "Error al momento de ingresar empleado");
				mav.addObject("employee", employee);
			}
			
			
		}
		
		mav.addObject("store", currentStore);
		mav.addObject("storeForm", currentStore);
		mav.addObject("empleados", currentStore.getEmployeesList());
		
		return mav;
	}
	
}
