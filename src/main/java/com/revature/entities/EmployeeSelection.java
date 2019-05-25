package com.revature.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EmployeeSelection {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int employeeSelectionId;
	
	private boolean choose;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinTable(name = "benefitId")
//	public BenefitPlan benefit;
//	
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinTable(name = "employeeId")
//	public Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "benefitid")
	public BenefitPlan benefitPlan;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId")
	public Employee employee;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "typeId")
	public TypeBenefits typeBenefits;
	
	
//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn (name = "benefitId")
//	public List<BenefitPlan> benefitPlan;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyId")
	public Company company;


	public int getEmployeeSelectionId() {
		return employeeSelectionId;
	}


	public void setEmployeeSelectionId(int employeeSelectionId) {
		this.employeeSelectionId = employeeSelectionId;
	}


	public boolean isChoose() {
		return choose;
	}


	public void setChoose(boolean choose) {
		this.choose = choose;
	}


	public BenefitPlan getBenefitPlan() {
		return benefitPlan;
	}


	public void setBenefitPlan(BenefitPlan benefitPlan) {
		this.benefitPlan = benefitPlan;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public TypeBenefits getTypeBenefits() {
		return typeBenefits;
	}


	public void setTypeBenefits(TypeBenefits typeBenefits) {
		this.typeBenefits = typeBenefits;
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
		result = prime * result + ((benefitPlan == null) ? 0 : benefitPlan.hashCode());
		result = prime * result + (choose ? 1231 : 1237);
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + employeeSelectionId;
		result = prime * result + ((typeBenefits == null) ? 0 : typeBenefits.hashCode());
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
		EmployeeSelection other = (EmployeeSelection) obj;
		if (benefitPlan == null) {
			if (other.benefitPlan != null)
				return false;
		} else if (!benefitPlan.equals(other.benefitPlan))
			return false;
		if (choose != other.choose)
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (employeeSelectionId != other.employeeSelectionId)
			return false;
		if (typeBenefits == null) {
			if (other.typeBenefits != null)
				return false;
		} else if (!typeBenefits.equals(other.typeBenefits))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "EmployeeSelection [employeeSelectionId=" + employeeSelectionId + ", choose=" + choose + ", benefitPlan="
				+ benefitPlan + ", employee=" + employee + ", typeBenefits=" + typeBenefits + ", company=" + company
				+ "]";
	}


	public EmployeeSelection(int employeeSelectionId, boolean choose, BenefitPlan benefitPlan, Employee employee,
			TypeBenefits typeBenefits, Company company) {
		super();
		this.employeeSelectionId = employeeSelectionId;
		this.choose = choose;
		this.benefitPlan = benefitPlan;
		this.employee = employee;
		this.typeBenefits = typeBenefits;
		this.company = company;
	}


	public EmployeeSelection() {
		super();
		// TODO Auto-generated constructor stub
	}


}
