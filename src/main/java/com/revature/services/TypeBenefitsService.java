package com.revature.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.revature.entities.TypeBenefits;
import com.revature.repositories.TypeBenefitsRepository;

@Service
public class TypeBenefitsService {
	
	TypeBenefitsRepository typeBenefitsRepository;
	
	@Inject
	public TypeBenefitsService 
	(TypeBenefitsRepository typeBenefitsRepository) {
	super();
	this.typeBenefitsRepository = typeBenefitsRepository;
}
	public TypeBenefits getById(int id) {
		return this.typeBenefitsRepository.getById(id);
	}
	
	public TypeBenefits create(TypeBenefits typeBenefits) {
		return this.typeBenefitsRepository.create(typeBenefits);
	}
	
	public TypeBenefits update(TypeBenefits typeBenefits) {
		return this.typeBenefitsRepository.update(typeBenefits);
	}
	
	public TypeBenefits deleteById(int id) {
		return this.typeBenefitsRepository.deleteById(id);
	}

}
