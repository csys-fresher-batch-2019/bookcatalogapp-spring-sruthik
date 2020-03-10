package com.sruthi.bookcatalogapp.domain;

import lombok.Data;

@Data
public class CourseTitles {
	private int courseId;
	private int titleId;

	@Override
	public String toString() {
		return "CourseTitles [courseId=" + courseId + ", titleId=" + titleId + "]";
	}

}
