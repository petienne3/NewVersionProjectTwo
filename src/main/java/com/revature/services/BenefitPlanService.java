package com.revature.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.revature.entities.BenefitPlan;
import com.revature.entities.BenefitPlanDTO;
import com.revature.entities.Company;
import com.revature.entities.Providers;
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
	
	public BenefitPlan create(BenefitPlanDTO benefitPlanDTO) {
		BenefitPlan benefitPlan = new BenefitPlan();
		 Company company = new Company();
		 Providers provider = new Providers();   
		company.setCompanyId(benefitPlanDTO.getCompanyId());
		    provider.setProviderId(benefitPlanDTO.getProviderId());
		    benefitPlan.setProvider(provider);
		    benefitPlan.setCompanies(company);
		return this.benefitPlanRepository.create(benefitPlan);
	
		
	}
	public BenefitPlan update(BenefitPlan benefitPlan) {
		return this.benefitPlanRepository.update(benefitPlan);
	}
	
	public BenefitPlan deleteById(int id) {
		return this.benefitPlanRepository.deleteById(id);
	}

}
//// Branch test
