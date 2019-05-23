package com.revature.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeCredentials {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int loginId;
	
	private String loginEmail;
	
	private String loginPassword;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginEmail == null) ? 0 : loginEmail.hashCode());
		result = prime * result + loginId;
		result = prime * result + ((loginPassword == null) ? 0 : loginPassword.hashCode());
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
		EmployeeCredentials other = (EmployeeCredentials) obj;
		if (loginEmail == null) {
			if (other.loginEmail != null)
				return false;
		} else if (!loginEmail.equals(other.loginEmail))
			return false;
		if (loginId != other.loginId)
			return false;
		if (loginPassword == null) {
			if (other.loginPassword != null)
				return false;
		} else if (!loginPassword.equals(other.loginPassword))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeCredentials [loginId=" + loginId + ", loginEmail=" + loginEmail + ", loginPassword="
				+ loginPassword + "]";
	}

	public EmployeeCredentials(int loginId, String loginEmail, String loginPassword) {
		super();
		this.loginId = loginId;
		this.loginEmail = loginEmail;
		this.loginPassword = loginPassword;
	}

	public EmployeeCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
