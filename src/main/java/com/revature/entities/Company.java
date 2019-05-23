package com.revature.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int companyId;
	
	private String companyemail;
	
	private String companyname;
	
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn (name = "employeeId")
	public List<Employee> employee;
	
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn (name = "benefitId")
	public List<BenefitPlan> benefitPlan;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeSelectionId")
	public List<EmployeeSelection> employeeSelectionId;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyemail() {
		return companyemail;
	}

	public void setCompanyemail(String companyemail) {
		this.companyemail = companyemail;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
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

	public List<BenefitPlan> getBenefitPlan() {
		return benefitPlan;
	}

	public void setBenefitPlan(List<BenefitPlan> benefitPlan) {
		this.benefitPlan = benefitPlan;
	}

	public List<EmployeeSelection> getEmployeeSelectionId() {
		return employeeSelectionId;
	}

	public void setEmployeeSelectionId(List<EmployeeSelection> employeeSelectionId) {
		this.employeeSelectionId = employeeSelectionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((benefitPlan == null) ? 0 : benefitPlan.hashCode());
		result = prime * result + companyId;
		result = prime * result + ((companyemail == null) ? 0 : companyemail.hashCode());
		result = prime * result + ((companyname == null) ? 0 : companyname.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((employeeSelectionId == null) ? 0 : employeeSelectionId.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		if (benefitPlan == null) {
			if (other.benefitPlan != null)
				return false;
		} else if (!benefitPlan.equals(other.benefitPlan))
			return false;
		if (companyId != other.companyId)
			return false;
		if (companyemail == null) {
			if (other.companyemail != null)
				return false;
		} else if (!companyemail.equals(other.companyemail))
			return false;
		if (companyname == null) {
			if (other.companyname != null)
				return false;
		} else if (!companyname.equals(other.companyname))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (employeeSelectionId == null) {
			if (other.employeeSelectionId != null)
				return false;
		} else if (!employeeSelectionId.equals(other.employeeSelectionId))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyemail=" + companyemail + ", companyname=" + companyname
				+ ", password=" + password + ", employee=" + employee + ", benefitPlan=" + benefitPlan
				+ ", employeeSelectionId=" + employeeSelectionId + "]";
	}

	public Company(int companyId, String companyemail, String companyname, String password, List<Employee> employee,
			List<BenefitPlan> benefitPlan, List<EmployeeSelection> employeeSelectionId) {
		super();
		this.companyId = companyId;
		this.companyemail = companyemail;
		this.companyname = companyname;
		this.password = password;
		this.employee = employee;
		this.benefitPlan = benefitPlan;
		this.employeeSelectionId = employeeSelectionId;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
