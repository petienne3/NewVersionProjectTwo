package com.revature.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Providers {
	
	private int providerId;
	
	private String providerName;
	
	private String description;
	
	private int status;
	
	private int cost;
	
	private int benefitId;

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
	 * @return the providerName
	 */
	public String getProviderName() {
		return providerName;
	}

	/**
	 * @param providerName the providerName to set
	 */
	public void setProviderName(String providerName) {
		this.providerName = providerName;
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
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + benefitId;
		result = prime * result + cost;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + providerId;
		result = prime * result + ((providerName == null) ? 0 : providerName.hashCode());
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
		if (benefitId != other.benefitId)
			return false;
		if (cost != other.cost)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (providerId != other.providerId)
			return false;
		if (providerName == null) {
			if (other.providerName != null)
				return false;
		} else if (!providerName.equals(other.providerName))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Providers [providerId=" + providerId + ", providerName=" + providerName + ", description=" + description
				+ ", status=" + status + ", cost=" + cost + ", benefitId=" + benefitId + "]";
	}
	
	
	
	
	
	

	
	
}
