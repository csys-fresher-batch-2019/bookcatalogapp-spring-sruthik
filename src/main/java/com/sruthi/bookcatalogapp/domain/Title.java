package com.sruthi.bookcatalogapp.domain;

import java.time.LocalDate;

public class Title {
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorId;
		result = prime * result + price;
		result = prime * result + ((pubDate == null) ? 0 : pubDate.hashCode());
		result = prime * result + pubId;
		result = prime * result + subId;
		result = prime * result + titleId;
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
		if (pubDate == null) {
			if (other.pubDate != null)
				return false;
		} else if (!pubDate.equals(other.pubDate))
			return false;
		if (pubId != other.pubId)
			return false;
		if (subId != other.subId)
			return false;
		if (titleId != other.titleId)
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
private int titleId;
private int pubId;
private int subId;
private int authorId;
private LocalDate pubDate;
private String titleName;
private int versionNumber;
private int price;
public int getTitleId() {
	return titleId;
}
public void setTitleId(int titleId) {
	this.titleId = titleId;
}
public int getPubId() {
	return pubId;
}
public void setPubId(int pubId) {
	this.pubId = pubId;
}
public int getSubId() {
	return subId;
}
public void setSubId(int subId) {
	this.subId = subId;
}
public int getAuthorId() {
	return authorId;
}
public void setAuthorId(int authorId) {
	this.authorId = authorId;
}
public LocalDate getPubDate() {
	return pubDate;
}
public void setPubDate(LocalDate pubDate) {
	this.pubDate = pubDate;
}
public String getTitle() {
	return titleName;
}
public void setTitle(String title) {
	this.titleName = title;
}
public int getVersionNumber() {
	return versionNumber;
}
public void setVersionNumber(int versionNumber) {
	this.versionNumber = versionNumber;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
@Override
public String toString() {
	return "Title [titleId=" + titleId + ", pubId=" + pubId + ", subId=" + subId + ", authorId=" + authorId
			+ ", pubDate=" + pubDate + ", titleName=" + titleName + ", versionNumber=" + versionNumber + ", price="
			+ price + "]";
}



}
