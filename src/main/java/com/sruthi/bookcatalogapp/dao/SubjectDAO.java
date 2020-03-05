package com.sruthi.bookcatalogapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sruthi.bookcatalogapp.domain.Subject;
import com.sruthi.bookcatalogapp.exception.DBException;

public interface SubjectDAO {
	void addSubject(Subject sub) throws DBException ;
	List<Subject> displaySubjectwiseTitles() throws DBException ;
	void deleteSubject(int subId) throws DBException ;
	void updateSubject(Subject sub) throws DBException ;
	
}
