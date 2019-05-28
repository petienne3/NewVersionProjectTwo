package com.revature.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.revature.entities.EmployeeSelection;
import com.revature.entities.EmployeeSelectionDTO;
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
	
	public List<EmployeeSelection> create(EmployeeSelectionDTO employeeSelectionDTO) {
		return this.employeeSelectionRepository.create(employeeSelectionDTO);
	}
	
	public EmployeeSelection update(EmployeeSelection employeeSelection) {
		return this.employeeSelectionRepository.update(employeeSelection);
	}
	
	public EmployeeSelection deleteById(int id) {
		return this.employeeSelectionRepository.deleteById(id);
	}

//	public EmployeeSelection choose(EmployeeSelection employeeSelection) {
//		return this.employeeSelectionRepository.choose(employeeSelection);
//
//	}

}
