//package com.revature.controllers;
//
//import javax.inject.Inject;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.entities.Company;
//import com.revature.entities.Credentials;
//import com.revature.services.CredentialsService;

//@RestController
//@RequestMapping("/Login")
//public class CredentialsController {
//	
//	private CredentialsService credentialsService;
//	
//	@Inject
//	public CredentialsController(CredentialsService credentialsService) {
//		this.credentialsService = credentialsService;
//	}
//	
//	@PostMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Company createdCredentials(@RequestBody Credentials credentials) {
//		return this.credentialsService.create(credentials);
//	}
//
//}
