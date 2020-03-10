package com.sruthi.bookcatalogapp.domain;

import java.time.LocalDate;

import lombok.Data;
@Data
public class Title {
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorId;
		result = prime * result + price;
		result = prime * result + ((publishedDate == null) ? 0 : publishedDate.hashCode());
		result = prime * result + publisherId;
		result = prime * result + subjectId;
		result = prime * result + id;
		result = prime * result + ((titleName == null) ? 0 : titleName.hashCode());
		result = prime * result + versionNumber;
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
		Title other = (Title) obj;
		if (authorId != other.authorId)
			return false;
		if (price != other.price)
			return false;
		if (publishedDate == null) {
			if (other.publishedDate != null)
				return false;
		} else if (!publishedDate.equals(other.publishedDate))
			return false;
		if (publisherId != other.publisherId)
			return false;
		if (subjectId != other.subjectId)
			return false;
		if (id != other.id)
			return false;
		if (titleName == null) {
			if (other.titleName != null)
				return false;
		} else if (!titleName.equals(other.titleName))
			return false;
		if (versionNumber != other.versionNumber)
			return false;
		return true;
	}
private int id;
private int publisherId;
private int subjectId;
private int authorId;
private LocalDate publishedDate;
private String titleName;
private int versionNumber;
private int price;

@Override
public String toString() {
	return "Title [id=" + id + ", publisherId=" + publisherId + ", subjectId=" + subjectId + ", authorId=" + authorId
			+ ", publishedDate=" + publishedDate + ", titleName=" + titleName + ", versionNumber=" + versionNumber
			+ ", price=" + price + "]";
}

}