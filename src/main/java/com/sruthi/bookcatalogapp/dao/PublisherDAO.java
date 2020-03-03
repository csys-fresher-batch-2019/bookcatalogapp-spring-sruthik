package com.sruthi.bookcatalogapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sruthi.bookcatalogapp.domain.Publisher;

public interface PublisherDAO {
	void addPublisher(Publisher pub) ;
	List<Publisher> displayPubId() ;
	void updateMailIdAndPhNo(Publisher pub) ;
	void deletePublisher(int pubId) ;
}
