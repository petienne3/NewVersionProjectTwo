package com.revature.entities;

import javax.persistence.Entity;

@Entity
public class Credentials {
	
	private String userEmail;
	private String password;
	
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
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
		Credentials other = (Credentials) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Credentials [userEmail=" + userEmail + ", password=" + password + "]";
	}
	public Credentials(String userEmail, String password) {
		super();
		this.userEmail = userEmail;
		this.password = password;
	}
	public Credentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
