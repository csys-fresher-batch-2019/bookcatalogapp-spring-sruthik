package com.sruthi.bookcatalogapp.dao;

import java.util.List;
import com.sruthi.bookcatalogapp.domain.Subject;
import com.sruthi.bookcatalogapp.exception.DBException;

public interface SubjectDAO {
	void save(Subject sub) throws DBException ;
	List<Subject> findAll() throws DBException ;
	void delete(int subId) throws DBException ;
	void update(Subject sub) throws DBException ;
	
}
