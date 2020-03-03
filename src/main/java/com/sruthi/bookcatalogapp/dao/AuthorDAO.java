package com.sruthi.bookcatalogapp.dao;

import java.util.List;


import com.sruthi.bookcatalogapp.domain.Author;

public interface AuthorDAO {
	void addAuthor( Author author);
	List<Author> displayNumberOfAuthors();
	void updateAuthor(Author author);
	void deleteAuthor(int authorId) ;
	
}
