package com.revature.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class BenefitPlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int benefitId;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "providerid")
	public List<Providers>provider;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyId")
	public Company company;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeId")
	public TypeBenefits typId;

	public int getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(int benefitId) {
		this.benefitId = benefitId;
	}

	public List<Providers> getProvider() {
		return provider;
	}

	public void setProvider(List<Providers> provider) {
		this.provider = provider;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public TypeBenefits getTypId() {
		return typId;
	}

	public void setTypId(TypeBenefits typId) {
		this.typId = typId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + benefitId;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((provider == null) ? 0 : provider.hashCode());
		result = prime * result + ((typId == null) ? 0 : typId.hashCode());
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
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		if (typId == null) {
			if (other.typId != null)
				return false;
		} else if (!typId.equals(other.typId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BenefitPlan [benefitId=" + benefitId + ", provider=" + provider + ", company=" + company + ", typId="
				+ typId + "]";
	}

	public BenefitPlan(int benefitId, List<Providers> provider, Company company, TypeBenefits typId) {
		super();
		this.benefitId = benefitId;
		this.provider = provider;
		this.company = company;
		this.typId = typId;
	}

	public BenefitPlan() {
		super();
		// TODO Auto-generated constructor stub
	}


	

}
