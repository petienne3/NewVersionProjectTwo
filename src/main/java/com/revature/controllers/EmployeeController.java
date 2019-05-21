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

import com.revature.entities.Employee;
import com.revature.services.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Inject
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/{id}")
	public Employee getById(@PathVariable int id) {
		return Optional.ofNullable(this.employeeService.getById(id))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee createdemployee(@RequestBody Employee employee) {
		return this.employeeService.create(employee);
	}
	
	@PutMapping("")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return this.employeeService.update(employee);
	}
	
	@DeleteMapping("/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		return this.employeeService.deleteById(id);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e){
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}
}
