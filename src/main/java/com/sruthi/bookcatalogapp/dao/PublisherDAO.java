package com.sruthi.bookcatalogapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sruthi.bookcatalogapp.domain.Publisher;
import com.sruthi.bookcatalogapp.exception.DBException;

public interface PublisherDAO {
	void addPublisher(Publisher pub) throws DBException ;
	List<Publisher> displayPubId() throws DBException ;
	void updateMailIdAndPhNo(Publisher pub) throws DBException ;
	void deletePublisher(int pubId) throws DBException ;
}
