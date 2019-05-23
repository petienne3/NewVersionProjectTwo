package com.revature.entities;

import java.util.List;

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
import javax.persistence.OneToOne;

@Entity
public class BenefitPlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int benefitId;
	
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name = "providerId")
//	public List<Providers>provider;
	
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "Joining_Benefit_n_company"
//	, joinColumns = { @JoinColumn (name = "company_Id")}
//	,inverseJoinColumns = {@JoinColumn(name = "benefitId")})
//	public Company company;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "companyId")
	public Company companies;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "employeeSelectionId")
	public EmployeeSelection employeeSelection;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "providerId")
	public Providers provider;

	public int getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(int benefitId) {
		this.benefitId = benefitId;
	}

	public Company getCompanies() {
		return companies;
	}

	public void setCompanies(Company companies) {
		this.companies = companies;
	}

	public EmployeeSelection getEmployeeSelection() {
		return employeeSelection;
	}

	public void setEmployeeSelection(EmployeeSelection employeeSelection) {
		this.employeeSelection = employeeSelection;
	}

	public Providers getProvider() {
		return provider;
	}

	public void setProvider(Providers provider) {
		this.provider = provider;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + benefitId;
		result = prime * result + ((companies == null) ? 0 : companies.hashCode());
		result = prime * result + ((employeeSelection == null) ? 0 : employeeSelection.hashCode());
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
		BenefitPlan other = (BenefitPlan) obj;
		if (benefitId != other.benefitId)
			return false;
		if (companies == null) {
			if (other.companies != null)
				return false;
		} else if (!companies.equals(other.companies))
			return false;
		if (employeeSelection == null) {
			if (other.employeeSelection != null)
				return false;
		} else if (!employeeSelection.equals(other.employeeSelection))
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
		return "BenefitPlan [benefitId=" + benefitId + ", companies=" + companies + ", employeeSelection="
				+ employeeSelection + ", provider=" + provider + "]";
	}

	public BenefitPlan(int benefitId, Company companies, EmployeeSelection employeeSelection, Providers provider) {
		super();
		this.benefitId = benefitId;
		this.companies = companies;
		this.employeeSelection = employeeSelection;
		this.provider = provider;
	}

	public BenefitPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
