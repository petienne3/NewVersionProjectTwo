//package com.revature.repositories;
//
//import java.util.List;
//
//import javax.inject.Inject;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.client.HttpClientErrorException;
//
//import com.revature.entities.Company;
//import com.revature.entities.Credentials;
//
//@Repository
//public class CredentialsRepository {
//	
//	SessionFactory sf;
//	Credentials credentials;
//	Company company;
//	
//	@Inject
//	public CredentialsRepository(SessionFactory sf) {
//		this.sf = sf;
//	}
//	
//	public Credentials CheckCredentials(Credentials credentials)throws HttpClientErrorException(HttpStatus.NOT_FOUND){
//	Session session = sf.getCurrentSession();
//	List<Company> companyList = session.createQuery("Select c from Company c where c.email = :email")
//			.setParameter("email", credentials.getUserEmail()).list();
//	
//	List<Company> company = companyList;
//	
//	return credentials;
//	
//}
//}