package com.revature.repositories;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.EmployeeSelection;
import com.revature.entities.EmployeeSelectionDTO;

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
//		Query query = session.createSQLQuery("Select * FROM employeeselection where benefitid = :benefitid AND employeeid = :employeeid ");
//		query.setParameter("benefitid", employeeSelection.)
		return session.get(EmployeeSelection.class, id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<EmployeeSelection> create(EmployeeSelectionDTO employeeSelectionDTO) {
		Session session = sf.getCurrentSession();
		System.out.println("It reached before the SQL statement");
		Query query = session.createSQLQuery("SELECT * FROM employeeselection WHERE benefitid = :benefitid AND employeeid = :employeeid");
		query.setParameter("benefitid", employeeSelectionDTO.getBenefitPlanId());
		query.setParameter("employeeid", employeeSelectionDTO.getEmployeeId());
		List<EmployeeSelection> selectionList = query.getResultList();
//		EmployeeSelection employeeSelection1 = selectionList.get(0);
//		
		System.out.println("selectionList is this:" +selectionList);
		return selectionList;
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
