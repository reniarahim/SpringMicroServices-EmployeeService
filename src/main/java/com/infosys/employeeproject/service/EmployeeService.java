package com.infosys.employeeproject.service;

import com.infosys.employeeproject.dto.EmployeeDTO;

public interface EmployeeService {
	
	public void insertEmployee(EmployeeDTO employee);
	public EmployeeDTO getEmployee(int EmpId);
	public void deleteEmployee(int EmpId);
	public String updateEmployee(int EmpId, String Name, String ZipCode);
}
