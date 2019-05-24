package com.revature.entities;

public class BenefitChoice {
	
	private int choice;
	private int companyid;
	
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + choice;
		result = prime * result + companyid;
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
		BenefitChoice other = (BenefitChoice) obj;
		if (choice != other.choice)
			return false;
		if (companyid != other.companyid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BenefitChoice [choice=" + choice + ", companyid=" + companyid + "]";
	}
	public BenefitChoice(int choice, int companyid) {
		super();
		this.choice = choice;
		this.companyid = companyid;
	}
	public BenefitChoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
