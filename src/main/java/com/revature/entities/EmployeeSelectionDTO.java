package com.revature.entities;

public class EmployeeSelectionDTO {
	private int benefitPlanId;
	private int employeeId;
	
	public EmployeeSelectionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeSelectionDTO(int benefitPlanId, int employeeId) {
		super();
		this.benefitPlanId = benefitPlanId;
		this.employeeId = employeeId;
	}

	public int getBenefitPlanId() {
		return benefitPlanId;
	}

	public void setBenefitPlanId(int benefitPlanId) {
		this.benefitPlanId = benefitPlanId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "EmployeeSelectionDTO [benefitPlanId=" + benefitPlanId + ", employeeId=" + employeeId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + benefitPlanId;
		result = prime * result + employeeId;
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
		EmployeeSelectionDTO other = (EmployeeSelectionDTO) obj;
		if (benefitPlanId != other.benefitPlanId)
			return false;
		if (employeeId != other.employeeId)
			return false;
		return true;
	}
	
	
	
	

}
