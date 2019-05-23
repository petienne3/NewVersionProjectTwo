package com.revature.controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import com.revature.entities.Credentials;
import com.revature.services.CompanyService;

@RestController
@RequestMapping("/Company")
public class CompanyController {
	
	  private CompanyService companyService;
	    
	    @Inject
	    public CompanyController(CompanyService companyService) {
	        this.companyService = companyService;
	    }//end class
	    

		@PostMapping("/login")
		@ResponseStatus(HttpStatus.CREATED)
		public Company login(@RequestBody Credentials credentials) {
			return this.companyService.create(credentials);
		}
	    
	@GetMapping("/{id}")
	public Company getById(@PathVariable int id) throws Throwable {
		
	    Company company = Optional.ofNullable(this.companyService.getById(id))
	            .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	    
	    String cache = company.getCompanyId() +" " + company.getCompanyname();
	    FileOutputStream fos = new FileOutputStream (cache);
	    
	    return company;
	}
 
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Company createdCompany(@RequestBody Company company) {
	    return this.companyService.create(company);
	}

	@PutMapping("/update/{id}")
	public Company updateCompany(@RequestBody Company company) {
	    return this.companyService.update(company);
	}

	@DeleteMapping("/{id}")
	public Company deleteCompany(@PathVariable int id) {
	    return this.companyService.deleteById(id);
	}
	    
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e){
	    return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());

	}

	}


