package com.revature.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class EmployeeSelection {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int employeeSelectionId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "benefitId")
	public BenefitPlan benefit;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "employeeId")
	public Employee employee;
	
	public int Choice;

	public int getEmployeeSelectionId() {
		return employeeSelectionId;
	}

	public void setEmployeeSelectionId(int employeeSelectionId) {
		this.employeeSelectionId = employeeSelectionId;
	}

	public BenefitPlan getBenefit() {
		return benefit;
	}

	public void setBenefit(BenefitPlan benefit) {
		this.benefit = benefit;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getChoice() {
		return Choice;
	}

	public void setChoice(int choice) {
		Choice = choice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Choice;
		result = prime * result + ((benefit == null) ? 0 : benefit.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + employeeSelectionId;
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
		if (benefit == null) {
			if (other.benefit != null)
				return false;
		} else if (!benefit.equals(other.benefit))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (employeeSelectionId != other.employeeSelectionId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeSelection [employeeSelectionId=" + employeeSelectionId + ", benefit=" + benefit + ", employee="
				+ employee + ", Choice=" + Choice + "]";
	}

	public EmployeeSelection(int employeeSelectionId, BenefitPlan benefit, Employee employee, int choice) {
		super();
		this.employeeSelectionId = employeeSelectionId;
		this.benefit = benefit;
		this.employee = employee;
		Choice = choice;
	}

	public EmployeeSelection() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
