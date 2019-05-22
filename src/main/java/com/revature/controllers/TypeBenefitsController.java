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

import com.revature.entities.TypeBenefits;
import com.revature.services.TypeBenefitsService;


@RestController
@RequestMapping("/TypeBenefits")
public class TypeBenefitsController {
	
private TypeBenefitsService typeBenefitsService;
	
	@Inject
	public TypeBenefitsController(TypeBenefitsService typeBenefitsService) {
		this.typeBenefitsService = typeBenefitsService;
	}
	
	@GetMapping("/{id}")
	public TypeBenefits getById(@PathVariable int id) {
		return Optional.ofNullable(this.typeBenefitsService.getById(id))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public TypeBenefits createdTypeBenefits(@RequestBody TypeBenefits typeBenefits) {
		return this.typeBenefitsService.create(typeBenefits);
	}
	
	@PutMapping("")
	public TypeBenefits updateTypeBenefits(@RequestBody TypeBenefits typeBenefits) {
		return this.typeBenefitsService.update(typeBenefits);
	}
	
	@DeleteMapping("/{id}")
	public TypeBenefits deleteTypeBenefits(@PathVariable int id) {
		return this.typeBenefitsService.deleteById(id);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e){
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}

}
