package com.revature.entities;

import javax.persistence.Entity;

@Entity
public class BenefitPlanDTO {
private int providerId;
private int companyId;

public int getProviderId() {
	return providerId;
}
public void setProviderId(int providerId) {
	this.providerId = providerId;
}
public int getCompanyId() {
	return companyId;
}
public void setCompanyId(int companyId) {
	this.companyId = companyId;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + companyId;
	result = prime * result + providerId;
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
	BenefitPlanDTO other = (BenefitPlanDTO) obj;
	if (companyId != other.companyId)
		return false;
	if (providerId != other.providerId)
		return false;
	return true;
}
@Override
public String toString() {
	return "BenefitPlanDTO [providerId=" + providerId + ", companyId=" + companyId + "]";
}
public BenefitPlanDTO(int providerId, int companyId) {
	super();
	this.providerId = providerId;
	this.companyId = companyId;
}
public BenefitPlanDTO() {
	super();
	// TODO Auto-generated constructor stub
}




}
