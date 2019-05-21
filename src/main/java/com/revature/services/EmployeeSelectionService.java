package com.revature.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.revature.entities.EmployeeSelection;
import com.revature.repositories.EmployeeSelectionRepository;


@Service
public class EmployeeSelectionService {
	
	EmployeeSelectionRepository employeeSelectionRepository;
	
	@Inject
	public EmployeeSelectionService
	(EmployeeSelectionRepository employeeSelectionRepository) {
		super();
		this.employeeSelectionRepository = employeeSelectionRepository;
	}
	
	public EmployeeSelection getById (int id) {
		return this.employeeSelectionRepository.getById(id);
	}
	
	public EmployeeSelection create(EmployeeSelection employeeSelection) {
		return this.employeeSelectionRepository.create(employeeSelection);
	}
	
	public EmployeeSelection update(EmployeeSelection employeeSelection) {
		return this.employeeSelectionRepository.update(employeeSelection);
	}
	
	public EmployeeSelection deleteById(int id) {
		return this.employeeSelectionRepository.deleteById(id);
	}

}
