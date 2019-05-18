package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Providers {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int providerId;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String Name;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "companyId")
	public Company company;
	
	private int status;

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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
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
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
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
		return "Providers [providerId=" + providerId + ", description=" + description + ", Name=" + Name + ", company="
				+ company + ", status=" + status + "]";
	}

	public Providers(int providerId, String description, String name, Company company, int status) {
		super();
		this.providerId = providerId;
		this.description = description;
		Name = name;
		this.company = company;
		this.status = status;
	}

	public Providers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
