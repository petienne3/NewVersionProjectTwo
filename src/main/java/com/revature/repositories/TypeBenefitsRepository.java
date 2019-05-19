package com.revature.repositories;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.TypeBenefits;

@Repository
public class TypeBenefitsRepository {
	
SessionFactory sf;
	
	@Inject
	public TypeBenefitsRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TypeBenefits getById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(TypeBenefits.class, id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TypeBenefits create(TypeBenefits typeBenefits) {
		Session session = sf.getCurrentSession();
		session.save(typeBenefits);
		return typeBenefits;
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TypeBenefits update(TypeBenefits typeBenefits) {
		Session session = sf.getCurrentSession();
		session.merge(typeBenefits);
		return typeBenefits;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TypeBenefits deleteById(int id) {
		Session session = sf.getCurrentSession();
		TypeBenefits typeBenefits = session.get(TypeBenefits.class,id);
		if (typeBenefits == null) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(typeBenefits);
		return typeBenefits;
	}

}
