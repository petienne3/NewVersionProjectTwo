package com.revature.controllers;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.EmployeeSelection;
import com.revature.services.EmployeeSelectionService;


@RestController
@RequestMapping("/EmployeeSelection")
public class EmployeeSelectionController {

	private EmployeeSelectionService employeeSelectionService;
	
	@Inject
	public EmployeeSelectionController(EmployeeSelectionService employeeSelectionService) {
		this.employeeSelectionService = employeeSelectionService;
	}
	
	@GetMapping("/{id}")
	public EmployeeSelection getById(@PathVariable int id) {
		return Optional.ofNullable(this.employeeSelectionService.getById(id))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public EmployeeSelection createdEmployeeSelection(@RequestBody EmployeeSelection employeeSelection) {
		return this.employeeSelectionService.create(employeeSelection);
	}
	
	@PutMapping("")
	public EmployeeSelection updateEmployeeSelection(@RequestBody EmployeeSelection employeeSelection) {
		return this.employeeSelectionService.update(employeeSelection);
	}
	
	@DeleteMapping("/{id}")
	public EmployeeSelection deleteEmployeeSelection(@PathVariable int id) {
		return this.employeeSelectionService.deleteById(id);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e){
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}
}
