package com.revature.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.revature.entities.BenefitPlan;
import com.revature.repositories.BenefitPlanRepository;

@Service
public class BenefitPlanService {
	
	BenefitPlanRepository benefitPlanRepository;
	
	@Inject
	public BenefitPlanService 
	(BenefitPlanRepository benefitPlanRepository) {
	super();
	this.benefitPlanRepository = benefitPlanRepository;
}
	public BenefitPlan getById(int id) {
		return this.benefitPlanRepository.getById(id);
	}
	// Branch test
	public BenefitPlan create(BenefitPlan benefitPlan) {
		return this.benefitPlanRepository.create(benefitPlan);
	}
	
	public BenefitPlan update(BenefitPlan benefitPlan) {
		return this.benefitPlanRepository.update(benefitPlan);
	}
	
	public BenefitPlan deleteById(int id) {
		return this.benefitPlanRepository.deleteById(id);
	}

}
