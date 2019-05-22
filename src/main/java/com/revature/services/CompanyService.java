package com.revature.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.type.StringType;
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
	  Session session = null;
	  List<Company>list = session.createQuery("FROM Company WHERE Company.companyemail= :email", Company.class)
	  .setParameter("email", company.getCompanyemail()).list();
	  for(Company c : list) {
		  if(c.getCompanyemail().equals(company.getCompanyemail())) {
			  return c;
		  }
	  }
	return company;
       
  }// end create

  public Company update(Company company) {
       return this.companyRepository.update(company);
      
  }// end update


 public Company deleteById(int id) {
      
      return this.companyRepository.getById(id);
      
 }//end method deleteBId

    
    
}// end class CompanyService


