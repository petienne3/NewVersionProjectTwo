package com.revature.repositories;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Company;

@Repository
public class CompanyRepository {
	
SessionFactory sf;
    
    @Inject
    public CompanyRepository(SessionFactory sf ) {
        
    this.sf = sf;    
        
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
        Session session = sf.getCurrentSession();
        session.merge(company);
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


