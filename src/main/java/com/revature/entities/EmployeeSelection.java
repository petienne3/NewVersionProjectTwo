package com.revature.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class EmployeeSelection {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int employeeSelectionId;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinTable(name = "benefitId")
//	public BenefitPlan benefit;
//	
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinTable(name = "employeeId")
//	public Employee employee;
	
	public int Choice;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name= "typeId")
	public List<TypeBenefits> typeBenefits;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn (name = "benefitPlanId")
	public List<BenefitPlan> benefitPlan;

	public int getEmployeeSelectionId() {
		return employeeSelectionId;
	}

	public void setEmployeeSelectionId(int employeeSelectionId) {
		this.employeeSelectionId = employeeSelectionId;
	}

	public int getChoice() {
		return Choice;
	}

	public void setChoice(int choice) {
		Choice = choice;
	}

	public List<TypeBenefits> getTypeBenefits() {
		return typeBenefits;
	}

	public void setTypeBenefits(List<TypeBenefits> typeBenefits) {
		this.typeBenefits = typeBenefits;
	}

	public List<BenefitPlan> getBenefitPlan() {
		return benefitPlan;
	}

	public void setBenefitPlan(List<BenefitPlan> benefitPlan) {
		this.benefitPlan = benefitPlan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Choice;
		result = prime * result + ((benefitPlan == null) ? 0 : benefitPlan.hashCode());
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
		if (Choice != other.Choice)
			return false;
		if (benefitPlan == null) {
			if (other.benefitPlan != null)
				return false;
		} else if (!benefitPlan.equals(other.benefitPlan))
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
		return "EmployeeSelection [employeeSelectionId=" + employeeSelectionId + ", Choice=" + Choice
				+ ", typeBenefits=" + typeBenefits + ", benefitPlan=" + benefitPlan + "]";
	}

	public EmployeeSelection(int employeeSelectionId, int choice, List<TypeBenefits> typeBenefits,
			List<BenefitPlan> benefitPlan) {
		super();
		this.employeeSelectionId = employeeSelectionId;
		Choice = choice;
		this.typeBenefits = typeBenefits;
		this.benefitPlan = benefitPlan;
	}

	public EmployeeSelection() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
