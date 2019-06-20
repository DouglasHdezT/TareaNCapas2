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
	
	@RequestMapping(value  = "/deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam("id_store") int id_store ,@RequestParam("id_employee") int id_employee) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("singleStore");
		Sucursal currentStore = sucursalService.getOneById(id_store);
		
		try {
			
			employeeService.deleteEmpleado(id_employee);;
			
			mav.addObject("hasErrors", "No");
			mav.addObject("message", "Empleado eliminado correctamente");
			
		}catch (Exception e) {
			e.printStackTrace();
			
			mav.addObject("hasErrors", "Yes");
			mav.addObject("message", "Error al momento de eliminar empleado");
		}
		
		mav.addObject("employee", new Empleado());
		mav.addObject("store", currentStore);
		mav.addObject("storeForm", currentStore);
		mav.addObject("empleados", currentStore.getEmployeesList());
		
		return mav;
	}
	
	
	@RequestMapping("/Employee")
	public ModelAndView showSingleEmploye(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("singleEmployee");
		
		try {
			
			Empleado employee = employeeService.getOneEmployeeById(id);
			
			mav.addObject("employee", employee);
			mav.addObject("employeeForm", employee);
			
		}catch (Exception e) {
			e.printStackTrace();
			mav.addObject("hasErrors", "Yes");
			mav.addObject("message", "Empleado no encontrado.");
			mav.addObject("employeeForm", new Empleado());
		}
		
		
		return mav;
	}
	
	
	@RequestMapping(value  ="/editEmployee")
	public ModelAndView editEmployee(@ModelAttribute("employeeForm") @Valid Empleado employeeForm, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("singleEmployee");
		
		if(result.hasErrors()) {
			mav.addObject("hasErrorsForm", "Yes");
			mav.addObject("hasErrors", "Yes");
			mav.addObject("message", "Error al modificar empleado.");
		}else {
			try {
				employeeService.insertEmpleado(employeeForm);
				mav.addObject("hasErrors", "No");
				mav.addObject("message", "Empleado Modificado con éxito.");
			}catch (Exception e) {
				e.printStackTrace();
				mav.addObject("hasErrors", "Yes");
				mav.addObject("message", "Error al modificar empleado.");
			}
		}
		
		Empleado empleadoReal = employeeService.getOneEmployeeById(employeeForm.getId());
		mav.addObject("employee", empleadoReal);
		mav.addObject("employeeForm", employeeForm);
		
		return mav;
	}
}
