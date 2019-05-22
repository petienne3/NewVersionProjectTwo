package com.revature.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Providers")
public class Providers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "providerId")
	private int providerId;
	
	@Column(name="description")
	private String description;
	
	@Column(name = "name", nullable = false)
	private String name;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name = "companyId")
//	public List<Company> company;
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = "BenefitId")
	
	
	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.MERGE, CascadeType.DETACH}) // @OneToMany - dictates that this relationship is one-to-many
	@JoinColumn(name = "provider_id")
	public List<BenefitPlan>benefitPlan;
	
	@Column (name="status")
	private int status;

	@Column (name="cost")
	private double cost;

	/**
	 * @return the providerId
	 */
	public int getProviderId() {
		return providerId;
	}

	/**
	 * @param providerId the providerId to set
	 */
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the benefitPlan
	 */
	public List<BenefitPlan> getBenefitPlan() {
		return benefitPlan;
	}

	/**
	 * @param benefitPlan the benefitPlan to set
	 */
	public void setBenefitPlan(List<BenefitPlan> benefitPlan) {
		this.benefitPlan = benefitPlan;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((benefitPlan == null) ? 0 : benefitPlan.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (benefitPlan == null) {
			if (other.benefitPlan != null)
				return false;
		} else if (!benefitPlan.equals(other.benefitPlan))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (providerId != other.providerId)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Providers [providerId=" + providerId + ", description=" + description + ", name=" + name
				+ ", benefitPlan=" + benefitPlan + ", status=" + status + ", cost=" + cost + "]";
	}

	public Providers(int providerId, String description, String name, List<BenefitPlan> benefitPlan, int status,
			double cost) {
		super();
		this.providerId = providerId;
		this.description = description;
		this.name = name;
		this.benefitPlan = benefitPlan;
		this.status = status;
		this.cost = cost;
	}

	public Providers() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}//end class providers

	
	
	
	
	
	

	
	
	
	
	

	
	

