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
	
	@Column(nullable=false, length = 30)
	private String companyEmail;
	
	private String companyName;
	
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name= "employeeId")
	public List<Employee> employee;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="providerId")
	public List<Providers> provider;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public List<Providers> getProvider() {
		return provider;
	}

	public void setProvider(List<Providers> provider) {
		this.provider = provider;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyEmail == null) ? 0 : companyEmail.hashCode());
		result = prime * result + companyId;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((provider == null) ? 0 : provider.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (companyEmail == null) {
			if (other.companyEmail != null)
				return false;
		} else if (!companyEmail.equals(other.companyEmail))
			return false;
		if (companyId != other.companyId)
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyEmail=" + companyEmail + ", companyName=" + companyName
				+ ", password=" + password + ", employee=" + employee + ", provider=" + provider + "]";
	}

	public Company(int companyId, String companyEmail, String companyName, String password, List<Employee> employee,
			List<Providers> provider) {
		super();
		this.companyId = companyId;
		this.companyEmail = companyEmail;
		this.companyName = companyName;
		this.password = password;
		this.employee = employee;
		this.provider = provider;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
