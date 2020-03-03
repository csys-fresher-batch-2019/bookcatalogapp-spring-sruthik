package com.sruthi.bookcatalogapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sruthi.bookcatalogapp.domain.Subject;

public interface SubjectDAO {
	void addSubject(Subject sub) ;
	List<Subject> displaySubjectwiseTitles() ;
	void deleteSubject(int subId) ;
	void updateSubject(Subject sub) ;
	
}
