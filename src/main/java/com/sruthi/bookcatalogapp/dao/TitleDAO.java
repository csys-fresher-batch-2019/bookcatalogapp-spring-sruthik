package com.sruthi.bookcatalogapp.dao;


import java.time.LocalDate;
import java.util.List;



import com.sruthi.bookcatalogapp.domain.Title;
import com.sruthi.bookcatalogapp.exception.DBException;

public interface TitleDAO {
	void save(Title title) throws DBException ;
	void update(Title title)throws DBException ;
	List<Title> findAll()throws DBException ;
	void delete(int titleId) throws DBException;
	List<Title> findByCourseId(int courseId) throws DBException;
	List<Title> findByYear(LocalDate pubDate) throws DBException;
	List<Title> findByPublisherCount()throws DBException;
	List<Title> findByRecentBooks() throws DBException;
	List<Title> findByPublisherId(int pubId)throws DBException;
	List<Title> findByPublisherName(String pubName)throws DBException;
	List<Title> findByAuthorName(String authorName)throws DBException;
	List<Title> findBySubjectName(String subName)throws DBException;
	
}
