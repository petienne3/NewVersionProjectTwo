package com.revature.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.revature.entities.Providers;
import com.revature.repositories.ProvidersRepository;

@Service
public class ProvidersService {
	
	ProvidersRepository providersRepository;
	
	@Inject
	public ProvidersService
	(ProvidersRepository providerRepository) {
		super();
		this.providersRepository = providerRepository;
	}
	
	public Providers getById(int id) {
		return this.providersRepository.getById(id);
	}
	
	public Providers create (Providers providers) {
		return this.providersRepository.create(providers);
	}
	
	public Providers update(Providers providers) {
		return this.providersRepository.update(providers);
	}
	
	public Providers deleteById(int id) {
		return this.providersRepository.deleteById(id);
	}

}
