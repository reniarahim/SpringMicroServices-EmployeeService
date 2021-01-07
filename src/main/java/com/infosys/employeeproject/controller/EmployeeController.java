package com.infosys.employeeproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.employeeproject.dto.EmployeeDTO;
import com.infosys.employeeproject.service.EmployeeService;
import com.infosys.employeeproject.dto.TrainingDTO;
import com.infosys.employeeproject.model.EmployeeDetails;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeDetails employeeDetails;
	
	@GetMapping("/employee/{id}")
	//@RequestMapping(method=RequestMethod.GET)
	public EmployeeDTO fetchEmployee(@PathVariable("id") int id) {
		EmployeeDTO employeeDTO = employeeService.getEmployee(id);
        return(employeeDTO);
	}
	
	@GetMapping("/employeeinfo/{id}")
	//@RequestMapping(method=RequestMethod.GET)
	public EmployeeDetails fetchEmployeeDetails(@PathVariable("id") int id) {
		EmployeeDTO employeeDTO = employeeService.getEmployee(id);
		employeeDetails.setId(employeeDTO.getId());
		employeeDetails.setName(employeeDTO.getName());
		employeeDetails.setCity(employeeDTO.getCity());
		employeeDetails.setZipCode(employeeDTO.getZipCode());
		
		//Calling Employee Training Service to Get the Training Details
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8084/training/" + id;
		
		TrainingDTO trainingDTOReceived = restTemplate.getForObject(url,TrainingDTO.class);
		
		employeeDetails.setCourseId(trainingDTOReceived.getCourseId());
		employeeDetails.setCourseName(trainingDTOReceived.getCourseName());
		employeeDetails.setMarks(trainingDTOReceived.getMarks());
		
        return(employeeDetails);
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
