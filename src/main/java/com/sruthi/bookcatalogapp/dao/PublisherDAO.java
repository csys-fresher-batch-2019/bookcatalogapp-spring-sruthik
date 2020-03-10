package com.sruthi.bookcatalogapp.dao;

import java.util.List;
import com.sruthi.bookcatalogapp.domain.Publisher;
import com.sruthi.bookcatalogapp.exception.DBException;

public interface PublisherDAO {
	void save(Publisher pub) throws DBException ;
	List<Publisher> findAll() throws DBException ;
	void update(Publisher pub) throws DBException ;
	void delete(int pubId) throws DBException ;
}
