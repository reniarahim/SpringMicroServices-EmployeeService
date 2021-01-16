package com.infosys.employeeproject.dto;

import org.springframework.stereotype.Service;

import com.infosys.employeeproject.model.Employee;

@Service
public class EmployeeDTO {

	private int Id;
	private String Name;
	private String City;
	private String ZipCode;
	
	public EmployeeDTO() {
		
	}
	
	public EmployeeDTO(Integer Id, String Name, String City, String ZipCode ) {
		super();
		this.Id = Id;
		this.Name = Name;
		this.City = City;
		this.ZipCode = ZipCode;
	}
	
	public Integer getId() {
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

	public static Employee prepareEmployeeEntity(EmployeeDTO employeeDTO) {
		Employee employeeEntity = new Employee();
		employeeEntity.setId(employeeDTO.getId());
		employeeEntity.setCity(employeeDTO.getCity());
		employeeEntity.setName(employeeDTO.getName());
		employeeEntity.setZipCode(employeeDTO.getZipCode());
		return employeeEntity;
		
	}

}

