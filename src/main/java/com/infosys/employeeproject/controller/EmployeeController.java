package com.infosys.employeeproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.employeeproject.dto.EmployeeDTO;
import com.infosys.employeeproject.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employee/{id}")
	//@RequestMapping(method=RequestMethod.GET)
	public EmployeeDTO fetchEmployee(@PathVariable("id") int id) {
		EmployeeDTO employeeDTO = employeeService.getEmployee(id);
        return(employeeDTO);
	}
	
	@PostMapping("/employee/{id}")
	//@RequestMapping(method=RequestMethod.POST)
	public String createEmployee() {
		return("Employee created successfully");
	}
	
	@DeleteMapping("/employee/{id}")
	//@RequestMapping(method=RequestMethod.DELETE)
	public String deleteEmployee() {
		return("Employee deleted successfully");
	}
	
	@PutMapping("/employee/{id}")
	//@RequestMapping(method=RequestMethod.PUT)
	public String updateEmployee() {
		return("Employee updated successfully");
	}

}
