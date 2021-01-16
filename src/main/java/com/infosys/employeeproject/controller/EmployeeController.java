package com.infosys.employeeproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.employeeproject.dto.EmployeeDTO;
import com.infosys.employeeproject.service.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.infosys.employeeproject.dto.TrainingDTO;
import com.infosys.employeeproject.model.EmployeeDetails;

@Controller
@RestController
@EnableCircuitBreaker
//@RibbonClient(name="empribbon")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeDetails employeeDetails;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	//Disabling Ribbon for Consul
	//@Autowired
//	RestTemplate template;
	
	@GetMapping("/employee/{id}")
	//@RequestMapping(method=RequestMethod.GET)
	public EmployeeDTO fetchEmployee(@PathVariable("id") int id) {
		EmployeeDTO employeeDTO = employeeService.getEmployee(id);
        return(employeeDTO);
	}
	
	@GetMapping("/employeeinfo/{id}")
	@HystrixCommand(fallbackMethod="fetchEmployeeDetailsFallBack")
	//@RequestMapping(method=RequestMethod.GET)
	public EmployeeDetails fetchEmployeeDetails(@PathVariable("id") int id) {
		EmployeeDTO employeeDTO = employeeService.getEmployee(id);
		employeeDetails.setId(employeeDTO.getId());
		employeeDetails.setName(employeeDTO.getName());
		employeeDetails.setCity(employeeDTO.getCity());
		employeeDetails.setZipCode(employeeDTO.getZipCode());
		
		//Calling Employee Training Service to Get the Training Details
		RestTemplate restTemplate = new RestTemplate();
		//String url = "http://empribbon/training/" + id;
		
		List<ServiceInstance> list = discoveryClient.getInstances("TrainingMS");
		String uri = null;
		
		if(list!=null && list.size()>0) {
			uri = list.get(0).getUri().toString();
		}
		
		
		
		TrainingDTO trainingDTOReceived = restTemplate.getForObject(uri+"training/"+id,TrainingDTO.class);
		
		employeeDetails.setCourseId(trainingDTOReceived.getCourseId());
		employeeDetails.setCourseName(trainingDTOReceived.getCourseName());
		employeeDetails.setMarks(trainingDTOReceived.getMarks());
		
        return(employeeDetails);
	}
	
	public EmployeeDetails fetchEmployeeDetailsFallBack(int id) {
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
