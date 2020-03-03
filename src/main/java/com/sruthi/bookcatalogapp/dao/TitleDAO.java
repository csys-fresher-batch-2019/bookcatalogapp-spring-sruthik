package com.sruthi.bookcatalogapp.dao;


import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sruthi.bookcatalogapp.domain.Title;

public interface TitleDAO {
	void addTitle(Title title) ;
	void changePubDate(Title title) ;
	List<Title> displayTitleWithPrice() ;
	void deleteTitle(int titleId) ;
	List<Title> displayTitleForCourseId(int courseId) ;
	List<Title> displayYearWiseBooks(LocalDate pubDate) ;
	List<Title> displayBooksPublishedByIndividualPublishers();
	List<Title> displayByRecentBooks() ;
	List<Title> displayTitle(int pubId);
	List<Title> displayTitleForPubName(String pubName);
	List<Title> displayTitleForAuthorName(String authorName);
	List<Title> displayTitleForSubName(String subName);
	int displayPrice(String title,int version);
}
