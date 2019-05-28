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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Positive;


@Entity
@Table(name="Providers")
public class Providers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)


	@Column(name = "providerId")

	private int providerId;
	
	private String description;
	
	@Column(name = "name", nullable = false)
	private String name;
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "providers_benefitPlan", joinColumns = { @JoinColumn(name = "provider_id") }, inverseJoinColumns = {
			@JoinColumn(name = "benefit_id") })
	public List<BenefitPlan>benefitPlan;
	
	//private int status;


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

	
}//end class providers

	
	
	
	
	
	

	
	
	
	
	

	

	



