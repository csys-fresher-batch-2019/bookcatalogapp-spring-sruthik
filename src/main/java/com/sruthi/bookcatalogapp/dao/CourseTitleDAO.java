package com.sruthi.bookcatalogapp.dao;

import java.util.List;



import com.sruthi.bookcatalogapp.domain.CourseTitles;
import com.sruthi.bookcatalogapp.exception.DBException;

public interface CourseTitleDAO {
    void save(CourseTitles course) throws DBException;
    void delete(int courseId) ;
    void update(CourseTitles course);
    List<CourseTitles> findAll() ;
}
