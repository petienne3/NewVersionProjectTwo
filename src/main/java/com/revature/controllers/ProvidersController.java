package com.revature.controllers;

import java.util.List;
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

import com.revature.entities.Company;
import com.revature.entities.Providers;
import com.revature.services.ProvidersService;

@RestController
@RequestMapping("/Providers")
public class ProvidersController {
	
	private ProvidersService providersService;
	
	@Inject
	public ProvidersController(ProvidersService providersService) {
		this.providersService = providersService;
	}
	@PostMapping("/getall")
	public List<Providers> getAll(@RequestBody Company company) {
		return this.providersService.getAll(company);
	}
	@GetMapping("/{id}")
	public Providers getById(@PathVariable int id) {
		return Optional.ofNullable(this.providersService.getById(id))
			.orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));	
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Providers createdProviders(@RequestBody Providers providers) {
		return this.providersService.create(providers);
	}
	
	@PutMapping("")
	public Providers updateProviders(@RequestBody Providers providers) {
		return this.providersService.update(providers);
	}
	
	@DeleteMapping("/{id}")
	public Providers deleteProviders(@PathVariable int id) {
		return this.providersService.deleteById(id);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleCientError(HttpClientErrorException e){
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}

}
