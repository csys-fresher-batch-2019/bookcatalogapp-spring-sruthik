package com.sruthi.bookcatalogapp.dao;

import java.util.List;


import com.sruthi.bookcatalogapp.domain.Author;
import com.sruthi.bookcatalogapp.exception.DBException;

public interface AuthorDAO {
	void addAuthor( Author author) throws DBException;
	List<Author> displayNumberOfAuthors() throws DBException;
	void updateAuthor(Author author) throws DBException;
	void deleteAuthor(int authorId) throws DBException ;
	
}
