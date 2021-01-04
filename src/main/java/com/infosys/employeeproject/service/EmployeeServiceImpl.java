package com.infosys.employeeproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.employeeproject.dto.EmployeeDTO;
import com.infosys.employeeproject.model.Employee;
import com.infosys.employeeproject.repository.EmployeeRepository;
import java.util.Optional;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public void insertEmployee(EmployeeDTO employee) {
		repository.save(EmployeeDTO.prepareEmployeeEntity(employee));
	}

	@Override
	public EmployeeDTO getEmployee(int EmpId) {
		Optional<Employee> optionalEmployee = repository.findById(EmpId);
		Employee employeeEntity = optionalEmployee.get();
		EmployeeDTO employeeDTO = Employee.prepareEmployeeDTO(employeeEntity);
		return employeeDTO;
		
	}

	@Override
	public void deleteEmployee(int EmpId) {
		repository.deleteById(EmpId);
		
	}

	@Override
	public String updateEmployee(int EmpId, String Name, String ZipCode) {
		Optional<Employee> optionalEmployee = repository.findById(EmpId);
		Employee employeeEntity = optionalEmployee.get();
		employeeEntity.setName(Name);
		employeeEntity.setZipCode(ZipCode);	
		repository.save(employeeEntity);
		return "Employee details Updated Successfully";
	}

}
