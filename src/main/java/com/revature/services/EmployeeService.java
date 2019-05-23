package com.revature.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.revature.entities.Employee;
import com.revature.entities.EmployeeCredentials;
import com.revature.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	EmployeeRepository employeeRepository;
	
	@Inject
	public EmployeeService
	(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	public Employee getById (int id) {
		return this.employeeRepository.geyById(id);
	}
	
	public Employee create(Employee employee) {
		return this.employeeRepository.create(employee);
	}
	
	public Employee update(Employee employee) {
		return this.employeeRepository.update(employee);
	}
	
	public Employee deleteById(int id) {
		return this.employeeRepository.deleteById(id);
	}
	
	public Employee create(EmployeeCredentials employeeCredentials) {
		return this.employeeRepository.login(employeeCredentials);
	}

}
