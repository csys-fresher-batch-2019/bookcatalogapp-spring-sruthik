package com.sruthi.bookcatalogapp.domain;

public class Users {
     @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		result = prime * result + (int) (phNo ^ (phNo >>> 32));
		result = prime * result + ((setPassword == null) ? 0 : setPassword.hashCode());
		result = prime * result + ((userMailId == null) ? 0 : userMailId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Users other = (Users) obj;
		if (confirmPassword == null) {
			if (other.confirmPassword != null)
				return false;
		} else if (!confirmPassword.equals(other.confirmPassword))
			return false;
		if (phNo != other.phNo)
			return false;
		if (setPassword == null) {
			if (other.setPassword != null)
				return false;
		} else if (!setPassword.equals(other.setPassword))
			return false;
		if (userMailId == null) {
			if (other.userMailId != null)
				return false;
		} else if (!userMailId.equals(other.userMailId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	private String userName;
     private String userMailId;
     private String setPassword;
     private String confirmPassword;
     private long phNo;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMailId() {
		return userMailId;
	}
	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}
	public String getSetPassword() {
		return setPassword;
	}
	public void setSetPassword(String setPassword) {
		this.setPassword = setPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	@Override
	public String toString() {
		return "Users [userName=" + userName + ", userMailId=" + userMailId + ", setPassword=" + setPassword
				+ ", confirmPassword=" + confirmPassword + ", phNo=" + phNo + "]";
	}
     
	
	
}
