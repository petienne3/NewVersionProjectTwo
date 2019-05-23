package com.revature.repositories;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Employee;


@Repository
public class EmployeeRepository {
	


		SessionFactory sf;
		
		@Inject
		public EmployeeRepository(SessionFactory sf) {
			this.sf = sf;
		}
		
		@Transactional(propagation = Propagation.REQUIRED)
		public Employee geyById(int id) {
			Session session = sf.getCurrentSession();
			return session.get(Employee.class, id);
		}
		
		@Transactional(propagation = Propagation.REQUIRED)
		public Employee create(Employee employee) {
			Session session = sf.getCurrentSession();
			session.save(employee);
			return employee;
		}
		
		@Transactional(propagation = Propagation.REQUIRED)
		public Employee update(Employee employee) {
			Session session = sf.getCurrentSession();
			session.merge(employee);
			return employee;
		}
		
		@Transactional(propagation = Propagation.REQUIRED)
		public Employee deleteById(int id) {
			Session session = sf.getCurrentSession();
			Employee employee = session.get(Employee.class,id);
			if(employee==null) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
			session.delete(employee);
			return employee;
			
		}
		
		
		
		}
	

