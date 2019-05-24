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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeId;
	
	
	private String employeeEmail;
	
	private String employeePassword;
	
	
	private String employeeFirstName;
	
	
	private String employeeLastName;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "employeeSelectionId")
//	public EmployeeSelection employeeSelection;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeSelectionId")
	public List<EmployeeSelection> employeeSelection;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "companyId")
	public Company company;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public List<EmployeeSelection> getEmployeeSelection() {
		return employeeSelection;
	}

	public void setEmployeeSelection(List<EmployeeSelection> employeeSelection) {
		this.employeeSelection = employeeSelection;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((employeeEmail == null) ? 0 : employeeEmail.hashCode());
		result = prime * result + ((employeeFirstName == null) ? 0 : employeeFirstName.hashCode());
		result = prime * result + employeeId;
		result = prime * result + ((employeeLastName == null) ? 0 : employeeLastName.hashCode());
		result = prime * result + ((employeePassword == null) ? 0 : employeePassword.hashCode());
		result = prime * result + ((employeeSelection == null) ? 0 : employeeSelection.hashCode());
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
		Employee other = (Employee) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (employeeEmail == null) {
			if (other.employeeEmail != null)
				return false;
		} else if (!employeeEmail.equals(other.employeeEmail))
			return false;
		if (employeeFirstName == null) {
			if (other.employeeFirstName != null)
				return false;
		} else if (!employeeFirstName.equals(other.employeeFirstName))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (employeeLastName == null) {
			if (other.employeeLastName != null)
				return false;
		} else if (!employeeLastName.equals(other.employeeLastName))
			return false;
		if (employeePassword == null) {
			if (other.employeePassword != null)
				return false;
		} else if (!employeePassword.equals(other.employeePassword))
			return false;
		if (employeeSelection == null) {
			if (other.employeeSelection != null)
				return false;
		} else if (!employeeSelection.equals(other.employeeSelection))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeEmail=" + employeeEmail + ", employeePassword="
				+ employeePassword + ", employeeFirstName=" + employeeFirstName + ", employeeLastName="
				+ employeeLastName + ", employeeSelection=" + employeeSelection + ", company=" + company + "]";
	}

	public Employee(int employeeId, String employeeEmail, String employeePassword, String employeeFirstName,
			String employeeLastName, List<EmployeeSelection> employeeSelection, Company company) {
		super();
		this.employeeId = employeeId;
		this.employeeEmail = employeeEmail;
		this.employeePassword = employeePassword;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeSelection = employeeSelection;
		this.company = company;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
