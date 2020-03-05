package com.sruthi.bookcatalogapp.dao;

import java.util.List;



import com.sruthi.bookcatalogapp.domain.CourseTitles;
import com.sruthi.bookcatalogapp.exception.DBException;

public interface CourseTitleDAO {
    void addCourseTitle(CourseTitles course) throws DBException;
    void deleteCourseTitle(int courseId) ;
    void updateCourseTitle(CourseTitles course);
    List<CourseTitles> displayCourseTitles() ;
}
