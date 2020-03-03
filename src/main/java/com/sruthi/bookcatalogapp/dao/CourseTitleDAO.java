package com.sruthi.bookcatalogapp.dao;

import java.util.List;



import com.sruthi.bookcatalogapp.domain.CourseTitles;

public interface CourseTitleDAO {
    void addCourseTitle(CourseTitles course);
    void deleteCourseTitle(int courseId) ;
    void updateCourseTitle(CourseTitles course);
    List<CourseTitles> displayCourseTitles() ;
}
