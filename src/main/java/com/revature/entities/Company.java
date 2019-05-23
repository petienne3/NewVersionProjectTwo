package com.revature.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int companyId;
	
	private String companyemail;
	
	private String companyname;
	
	private String password;
	
	@ManyToMany
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name= "employeeId")
	public List<Employee> employee;

	
	
	

	

	
}
