package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;

@Entity
public class Providers {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "providerId")
	private int providerId;
	
	private String description;
	
	@Column(nullable = false)
	private String Name;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "companyId")
//	public Company company;
//	

	
//	@OneToMany(fetch = FetchType.EAGER)
//	public List<BenefitPlan> benefitPlan;
//	
	//	@JoinTable(name = "Joining_Providers_n_BenefitPlan"
//	, joinColumns = { 
//			,inverseJoinColumns = {@JoinColumn(name = "providerId")})	
	

	
	private int status;
	
	@Positive
	private double cost;

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + providerId;
		result = prime * result + status;
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
		Providers other = (Providers) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (providerId != other.providerId)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Providers [providerId=" + providerId + ", description=" + description + ", Name=" + Name + ", status="
				+ status + ", cost=" + cost + "]";
	}

	public Providers(int providerId, String description, String name, int status, @Positive double cost) {
		super();
		this.providerId = providerId;
		this.description = description;
		Name = name;
		this.status = status;
		this.cost = cost;
	}

	public Providers() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
