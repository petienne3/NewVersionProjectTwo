package com.revature.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TypeBenefits {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int typeId;
	
	@Column
	private String categories;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "EmployeeSelectioId")
	public EmployeeSelection employeeSelection;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public EmployeeSelection getEmployeeSelection() {
		return employeeSelection;
	}

	public void setEmployeeSelection(EmployeeSelection employeeSelection) {
		this.employeeSelection = employeeSelection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((employeeSelection == null) ? 0 : employeeSelection.hashCode());
		result = prime * result + typeId;
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
		TypeBenefits other = (TypeBenefits) obj;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (employeeSelection == null) {
			if (other.employeeSelection != null)
				return false;
		} else if (!employeeSelection.equals(other.employeeSelection))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TypeBenefits [typeId=" + typeId + ", categories=" + categories + ", employeeSelection="
				+ employeeSelection + "]";
	}

	public TypeBenefits(int typeId, String categories, EmployeeSelection employeeSelection) {
		super();
		this.typeId = typeId;
		this.categories = categories;
		this.employeeSelection = employeeSelection;
	}

	public TypeBenefits() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
