package com.revature.repositories;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Company;
import com.revature.entities.Credentials;
import com.revature.entities.Providers;

@Repository
public class CompanyRepository {
	
	Providers provider;
	
SessionFactory sf;
    
    @Inject
    public CompanyRepository(SessionFactory sf ) {
        
    this.sf = sf;    
        
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public Company login(Credentials credentials) {
    	Session session = sf.getCurrentSession();
    	List<Company> companyList = session.createQuery("Select c from Company c where c.companyemail = :companyemail")
    		.setParameter("companyemail", credentials.getUserEmail()).list();
    	Company company = companyList.get(0);
    	System.out.println("company:" +company);
    	if(company.getPassword().equals(credentials.getPassword())) {
    		return company;
    	}else {
    		throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    		}
    	}
    
    
    
    @Transactional(propagation = Propagation.REQUIRED)
    public Company getById(int id) {
        Session session = sf.getCurrentSession();
        return session.get(Company.class,id);
        
    }// end method getById
    
    @Transactional(propagation = Propagation.REQUIRED)
    public Company create(Company company) {
        Session session = sf.getCurrentSession();
        session.save(company);
        return company;
    }// end method create    
    
    @Transactional (propagation = Propagation.REQUIRED)
    public Company update(Company company ) {
//        Session session = sf.getCurrentSession();
//        Query update = session.createQuery("update Company set provider_id = :provider_id" + "where company_id = :company_id")
//        		.setParameter("provider_id", company.provider.getProviderId().list());
//        session.merge(company);
        return company;
        
    }//end method update
    
    
    @Transactional (propagation = Propagation.REQUIRED)
    public Company deleteById(int id) {
        Session session = sf.getCurrentSession();
        Company company = session.get(Company.class,id);
        if (company == null)throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        session.delete(company);
        return company;
    }// end method deleteById
    

    
}//end class CompanyRepostory


