package com.sruthi.bookcatalogapp.domain;

import lombok.Data;

@Data
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

	@Override
	public String toString() {
		return "Users [userName=" + userName + ", userMailId=" + userMailId + ", setPassword=" + setPassword
				+ ", confirmPassword=" + confirmPassword + ", phNo=" + phNo + "]";
	}

}
