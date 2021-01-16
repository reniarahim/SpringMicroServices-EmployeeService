package com.infosys.employeeproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

import com.infosys.employeeproject.dto.EmployeeDTO;

@Service
@Entity
public class Employee {
	
	@Id
	private int Id;
	private String Name;
	private String City;
	@Column(name = "Zip_Code")
	private String ZipCode;
	
	public Employee(){
	}
	
	public Employee(int Id, String Name, String City, String ZipCode) {
		super();
		this.Id = Id;
		this.Name = Name;
		this.City = City;
		this.ZipCode = ZipCode;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getZipCode() {
		return ZipCode;
	}
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
	
	public static EmployeeDTO prepareEmployeeDTO(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(employee.getId());
		employeeDTO.setName(employee.getName());
		employeeDTO.setCity(employee.getCity());
		employeeDTO.setZipCode(employee.getZipCode());	
		return employeeDTO;
		
	}
	
	
}

