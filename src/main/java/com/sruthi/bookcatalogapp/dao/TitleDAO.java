package com.sruthi.bookcatalogapp.dao;


import java.time.LocalDate;
import java.util.List;



import com.sruthi.bookcatalogapp.domain.Title;
import com.sruthi.bookcatalogapp.exception.DBException;

public interface TitleDAO {
	void addTitle(Title title) throws DBException ;
	void changePubDate(Title title)throws DBException ;
	List<Title> displayTitleWithPrice()throws DBException ;
	void deleteTitle(int titleId) throws DBException;
	List<Title> displayTitleForCourseId(int courseId) throws DBException;
	List<Title> displayYearWiseBooks(LocalDate pubDate) throws DBException;
	List<Title> displayBooksPublishedByIndividualPublishers()throws DBException;
	List<Title> displayByRecentBooks() throws DBException;
	List<Title> displayTitle(int pubId)throws DBException;
	List<Title> displayTitleForPubName(String pubName)throws DBException;
	List<Title> displayTitleForAuthorName(String authorName)throws DBException;
	List<Title> displayTitleForSubName(String subName)throws DBException;
	int displayPrice(String title,int version)throws DBException;
}
