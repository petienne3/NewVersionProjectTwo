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

import com.revature.entities.BenefitChoice;
import com.revature.entities.BenefitPlan;

@Repository
public class BenefitPlanRepository {

	SessionFactory sf;
	
	@Inject
	public BenefitPlanRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public BenefitPlan getById(int id) {
		Session session = sf.getCurrentSession();
		List<BenefitPlan> benefitList = session.createQuery("Select b from BenefitPlan b where b.companyid = :companyid")
			.setParameter("companyid", id).list();
		BenefitPlan benefitPlan = benefitList.get(0);
		return session.get(BenefitPlan.class, id);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public BenefitPlan create(BenefitPlan benefitPlan) {
		Session session = sf.getCurrentSession();
		session.save(benefitPlan);
		return benefitPlan;
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public BenefitPlan update(BenefitPlan benefitPlan) {
		Session session = sf.getCurrentSession();
		session.merge(benefitPlan);
		return benefitPlan;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public BenefitPlan deleteById(int id) {
		Session session = sf.getCurrentSession();
		BenefitPlan benefitPlan = session.get(BenefitPlan.class,id);
		if (benefitPlan == null) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(benefitPlan);
		return benefitPlan;
	}

//	@Transactional(propagation = Propagation.REQUIRED)
//	public BenefitPlan choice(BenefitChoice benefitChoice) {
//		Session session = sf.getCurrentSession();
//		List<BenefitPlan> benefitList = session.createQuery("Select b from BenefitPlan b where b.companyid = :companyid")
//			.setParameter("companyid", benefitChoice.getCompanyid()).list();
//		BenefitPlan benefitPlan = benefitList.get(0);
//		
//		System.out.println("benefitPlan Availabe:" +benefitPlan);
//		
//		return benefitPlan;
//	}
}
