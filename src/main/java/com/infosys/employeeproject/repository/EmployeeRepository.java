package com.infosys.employeeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.employeeproject.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
