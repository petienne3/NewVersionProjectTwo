package com.revature.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.revature.entities.Company;
import com.revature.repositories.CompanyRepository;

@Service
public class CompanyService {
	
CompanyRepository companyRepository;
    
    
    @Inject
    public CompanyService(CompanyRepository companyRepository) {
    
        super();
        this.companyRepository = companyRepository;    
        
    }// end of costructor CompanyService
    
 public Company getById(int id) {
      return this.companyRepository.getById(id);
 }// end getById

  public Company create(Company company) {
       return this.companyRepository.create(company);
      
  }// end create

  public Company update(Company company) {
       return this.companyRepository.update(company);
      
  }// end update


 public Company deleteById(int id) {
      
      return this.companyRepository.getById(id);
      
 }//end method deleteBId

    
    
}// end class CompanyService


