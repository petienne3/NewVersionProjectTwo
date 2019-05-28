package com.revature.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class BenefitPlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int benefitId;
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "providers_benefitPlan", joinColumns = { @JoinColumn(name = "benefit_id") }, inverseJoinColumns = {
			@JoinColumn(name = "provider_id") })
	public List<Providers>provider;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "company_benefitPlan", joinColumns = { @JoinColumn(name = "benefit_id") }, inverseJoinColumns = {
			@JoinColumn(name = "company_id") })
	public List<Company>company;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employeeSelection_id")
	private EmployeeSelection employeeSelection;

//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name = "providerId")
//	public List<Providers>provider;
	
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "Joining_Benefit_n_company"
//	, joinColumns = { @JoinColumn (name = "company_Id")}
//	,inverseJoinColumns = {@JoinColumn(name = "benefitId")})
//	public Company company;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "companyid")
	public Company companies;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "employeeSelectionId")
	public EmployeeSelection employeeSelection;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "providerId")
	public Providers provider;



	/**
	 * @return the benefitId
	 */
	public int getBenefitId() {
		return benefitId;
	}


	/**
	 * @param benefitId the benefitId to set
	 */



	public void setBenefitId(int benefitId) {
		this.benefitId = benefitId;
	}


	/**
	 * @return the provider
	 */
	public List<Providers> getProvider() {
		return provider;
	}

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(List<Providers> provider) {
		this.provider = provider;
	}

	/**
	 * @return the company
	 */
	public List<Company> getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(List<Company> company) {
		this.company = company;
	}

	/**
	 * @return the employeeSelection
	 */
	public EmployeeSelection getEmployeeSelection() {
		return employeeSelection;
	}

	/**
	 * @param employeeSelection the employeeSelection to set
	 */
	public void setEmployeeSelection(EmployeeSelection employeeSelection) {
		this.employeeSelection = employeeSelection;


	public Company getCompanies() {
		return companies;
	}


	public void setCompanies(Company companies) {
		this.companies = companies;
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

		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((employeeSelection == null) ? 0 : employeeSelection.hashCode());

		result = prime * result + ((companies == null) ? 0 : companies.hashCode());

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

		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (employeeSelection == null) {
			if (other.employeeSelection != null)
				return false;
		} else if (!employeeSelection.equals(other.employeeSelection))

		if (companies == null) {
			if (other.companies != null)
				return false;
		} else if (!companies.equals(other.companies))

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

		return "BenefitPlan [benefitId=" + benefitId + ", provider=" + provider + ", company=" + company
				+ ", employeeSelection=" + employeeSelection + "]";
	}

	public BenefitPlan(int benefitId, List<Providers> provider, List<Company> company,
			EmployeeSelection employeeSelection) {

		return "BenefitPlan [benefitId=" + benefitId + ", companies=" + companies + ", provider=" + provider + "]";
	}


	public BenefitPlan(int benefitId, Company companies, Providers provider) {

		super();
		this.benefitId = benefitId;
		this.companies = companies;
		this.provider = provider;

		this.company = company;
		this.employeeSelection = employeeSelection;

	}


	public BenefitPlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	



}
