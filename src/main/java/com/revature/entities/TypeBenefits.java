package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeBenefits {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int typeId;
	
	@Column
	private String categories;
	
//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn (name = "employeeSelectionId")
//	public List<EmployeeSelection> employeeSelection;


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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
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
		if (typeId != other.typeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TypeBenefits [typeId=" + typeId + ", categories=" + categories + "]";
	}

	public TypeBenefits(int typeId, String categories) {
		super();
		this.typeId = typeId;
		this.categories = categories;
	}

	public TypeBenefits() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
}
