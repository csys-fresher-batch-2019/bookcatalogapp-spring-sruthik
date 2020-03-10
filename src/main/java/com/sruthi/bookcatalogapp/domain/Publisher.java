package com.sruthi.bookcatalogapp.domain;

import lombok.Data;

@Data
public class Publisher {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((mailId == null) ? 0 : mailId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
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
		Publisher other = (Publisher) obj;
		if (id != other.id)
			return false;
		if (mailId == null) {
			if (other.mailId != null)
				return false;
		} else if (!mailId.equals(other.mailId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		return true;
	}

	private int id;
	private String name;
	private String mailId;
    private long phoneNumber;
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", mailId=" + mailId + ", phoneNumber=" + phoneNumber + "]";
	}
	

	
}
