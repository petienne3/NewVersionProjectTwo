package com.revature.repositories;

import java.security.Provider;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Company;
import com.revature.entities.Credentials;
import com.revature.entities.Providers;

@Repository
public class ProvidersRepository {
	
	SessionFactory sf;
	
	@Inject
	public ProvidersRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Providers getById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(Providers.class,id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Providers create(Providers providers) {
		Session session = sf.getCurrentSession();
		session.save(providers);
		return providers;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Providers update(Providers providers) {
		Session session = sf.getCurrentSession();
		session.merge(providers);
		return providers;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Providers deleteById(int id) {
		Session session = sf.getCurrentSession();
		Providers providers = session.get(Providers.class, id);
		if(providers == null) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(providers);
		return providers;
	}
	@Transactional(propagation = Propagation.REQUIRED)
    public List<Providers> getAll() {
    	Session session = sf.getCurrentSession();
    	List<Providers> providerList = session.createQuery("from Providers",Providers.class).list();
    	return providerList;
    }
}
