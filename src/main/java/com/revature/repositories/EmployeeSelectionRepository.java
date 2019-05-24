package com.revature.repositories;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.EmployeeSelection;

@Repository
public class EmployeeSelectionRepository {
	
	SessionFactory sf;
	
	@Inject
	public EmployeeSelectionRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public EmployeeSelection getById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(EmployeeSelection.class, id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public EmployeeSelection create(EmployeeSelection employeeSelection) {
		Session session = sf.getCurrentSession();
		session.save(employeeSelection);
		return employeeSelection;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public EmployeeSelection update(EmployeeSelection employeeSelection) {
		Session session = sf.getCurrentSession();
		session.merge(employeeSelection);
		return employeeSelection;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public EmployeeSelection deleteById(int id) {
		Session session = sf.getCurrentSession();
		EmployeeSelection employeeSelection = session.get(EmployeeSelection.class, id);
		if(employeeSelection == null) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(employeeSelection);
		return employeeSelection;
	}

//	@Transactional(propagation = Propagation.REQUIRED)
//	public EmployeeSelection choose(EmployeeSelection employeeSelection) {
//		Session session = sf.getCurrentSession();
//		Query queury = 
//	}

}
