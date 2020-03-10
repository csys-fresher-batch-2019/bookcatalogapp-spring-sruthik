package com.sruthi.bookcatalogapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sruthi.bookcatalogapp.dao.CourseTitleDAO;
import com.sruthi.bookcatalogapp.domain.CourseTitles;
import com.sruthi.bookcatalogapp.exception.DBException;
import com.sruthi.bookcatalogapp.exception.ErrorConstant;
import com.sruthi.bookcatalogapp.util.ConnectionUtil;

@Repository
public class CourseTitleImpl implements CourseTitleDAO {
	private static final Logger logger = LoggerFactory.getLogger(CourseTitleImpl.class);

	@Override
	public void save(CourseTitles course) throws DBException {

		String sql = "insert into course_titles(course_id,title_id)values(?,?)";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, course.getCourseId());
			pst.setInt(2, course.getTitleId());
			int rows = pst.executeUpdate();
			logger.debug("No of rows inserted:" + rows);
		} catch (SQLException e) {

			throw new DBException(ErrorConstant.INVALID_ADD);
		}

	}

	@Override
	public void delete(int courseId) {

		String sql = "Delete from course_titles where course_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, courseId);
			int rows = pst.executeUpdate();
			logger.debug("No of rows deleted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
		}

	}

	public void update(CourseTitles course) {

		String sql = "Update course_titles set course_id = ? where title_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, course.getCourseId());
			pst.setInt(2, course.getTitleId());
			int rows = pst.executeUpdate();
			logger.debug("No of rows deleted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
		}

	}

	@Override
	public List<CourseTitles> findAll() {

		List<CourseTitles> list = new ArrayList<>();
		String sql = "select course_id,title_id from course_titles";
		try (Connection connection = ConnectionUtil.getConnection(); Statement stmt = connection.createStatement()) {

			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					int courseId = rs.getInt("course_id");
					int titleId = rs.getInt("title_id");
					CourseTitles course = new CourseTitles();
					course.setCourseId(courseId);
					course.setTitleId(titleId);
					list.add(course);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
		}

		return list;
	}

}
