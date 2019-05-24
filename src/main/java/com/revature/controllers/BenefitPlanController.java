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

import com.revature.entities.BenefitChoice;
import com.revature.entities.BenefitPlan;
import com.revature.services.BenefitPlanService;


@RestController
@RequestMapping("/BenefitPlan")
public class BenefitPlanController {
	
	private BenefitPlanService benefitPlanService;
	
	@Inject
	public BenefitPlanController(BenefitPlanService benefitPlanService) {
		super();
		this.benefitPlanService = benefitPlanService;
	}
	
//	@PostMapping("/choice")
//	@ResponseStatus(HttpStatus.CREATED)
//	public BenefitPlan chooseBenefitPlan(@RequestBody BenefitChoice benefitChoice) {
//		return this.benefitPlanService.choice(benefitChoice);
//	}
	
	@GetMapping("/{id}")
	public BenefitPlan getById(@PathVariable int id) {
		return Optional.ofNullable(this.benefitPlanService.getById(id))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public BenefitPlan createdBenefitPlan(@RequestBody BenefitPlan benefitPlan) {
		return this.benefitPlanService.create(benefitPlan);
	}
	
	@PutMapping("")
	public BenefitPlan updateBenefitPlan(@RequestBody BenefitPlan benefitPlan) {
		return this.benefitPlanService.update(benefitPlan);
	}
	
	@DeleteMapping("/{id}")
	public BenefitPlan deleteBenefitPlan(@PathVariable int id) {
		return this.benefitPlanService.deleteById(id);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e){
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}

}
