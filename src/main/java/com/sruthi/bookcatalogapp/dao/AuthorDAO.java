package com.sruthi.bookcatalogapp.dao;

import java.util.List;


import com.sruthi.bookcatalogapp.domain.Author;
import com.sruthi.bookcatalogapp.exception.DBException;

public interface AuthorDAO {
	void save( Author author) throws DBException;
	List<Author> findAll() throws DBException;
	void update(Author author) throws DBException;
	void delete(int authorId) throws DBException ;
	
}
