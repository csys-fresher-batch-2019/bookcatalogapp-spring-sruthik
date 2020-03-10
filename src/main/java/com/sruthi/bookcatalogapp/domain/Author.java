package com.sruthi.bookcatalogapp.domain;

import lombok.Data;

@Data
public class Author {
	private int id;
	private String name;
	private String mailId;
	private long phoneNumber;

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", mailId=" + mailId + ", phoneNumber=" + phoneNumber + "]";
	}

}
