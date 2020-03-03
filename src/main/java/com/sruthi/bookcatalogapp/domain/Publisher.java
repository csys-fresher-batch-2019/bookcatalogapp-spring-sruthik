package com.sruthi.bookcatalogapp.domain;

 public class Publisher {
 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pubId;
		result = prime * result + ((pubMailId == null) ? 0 : pubMailId.hashCode());
		result = prime * result + ((pubName == null) ? 0 : pubName.hashCode());
		result = prime * result + (int) (pubPhNo ^ (pubPhNo >>> 32));
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
		if (pubId != other.pubId)
			return false;
		if (pubMailId == null) {
			if (other.pubMailId != null)
				return false;
		} else if (!pubMailId.equals(other.pubMailId))
			return false;
		if (pubName == null) {
			if (other.pubName != null)
				return false;
		} else if (!pubName.equals(other.pubName))
			return false;
		if (pubPhNo != other.pubPhNo)
			return false;
		return true;
	}



private int pubId;
 private String pubName;
 private String pubMailId;
 public int getPubId() {
	return pubId;
}



public void setPubId(int pubId) {
	this.pubId = pubId;
}



public String getPubName() {
	return pubName;
}



public void setPubName(String pubName) {
	this.pubName = pubName;
}



public String getPubMailId() {
	return pubMailId;
}



public void setPubMailId(String pubMailId) {
	this.pubMailId = pubMailId;
}



private long pubPhNo;
 
 

public long getPubPhNo() {
	return pubPhNo;
}



public void setPubPhNo(long pubPhNo) {
	this.pubPhNo = pubPhNo;
}



@Override
public String toString() {
	return "Publishers [pubId=" + pubId + ", pubName=" + pubName + ", pubMailId=" + pubMailId + ", pubPhNo=" + pubPhNo
			+ "]";
}
}
