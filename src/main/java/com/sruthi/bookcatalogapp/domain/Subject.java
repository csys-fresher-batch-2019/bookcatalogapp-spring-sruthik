package com.sruthi.bookcatalogapp.domain;

import lombok.Data;

@Data
public class Subject {
	private int id;
	private String name;

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + "]";
	}

}
