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

import com.sruthi.bookcatalogapp.dao.SubjectDAO;
import com.sruthi.bookcatalogapp.domain.Subject;
import com.sruthi.bookcatalogapp.util.ConnectionUtil;

@Repository
public class SubjectImpl implements SubjectDAO {
	private static final Logger logger = LoggerFactory.getLogger(SubjectImpl.class);

	@Override
	public void addSubject(Subject sub) {
		String sql = "insert into subjects(sub_name)values(?)";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, sub.getSubName());
			int rows = pst.executeUpdate();
			logger.debug("No of rows inserted:" + rows);

		} catch (SQLException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
		}

	}

	@Override
	public List<Subject> displaySubjectwiseTitles() {
		List<Subject> list = new ArrayList<>();

		String sql = "select sub_id,sub_name from subjects";
		try (Connection connection = ConnectionUtil.getConnection(); Statement stmt = connection.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {

					int subId = rs.getInt("sub_id");
					String subName = rs.getString("sub_name");
					logger.debug("Subject Id : " + subId + "\nSubject Name : " + subName);

					Subject sub = new Subject();
					sub.setSubId(subId);
					sub.setSubName(subName);

					list.add(sub);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
		}

		return list;
	}

	@Override
	public void updateSubject(Subject sub) {
		String sql = "update subjects set sub_name = ?where sub_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, sub.getSubName());
			pst.setInt(2, sub.getSubId());
			int rows = pst.executeUpdate();
			logger.debug("No of rows updated:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
		}

	}

	@Override
	public void deleteSubject(int subId) {
		String sql = "Delete from subjects where sub_id = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, subId);
			int rows = pst.executeUpdate();
			logger.debug("No of rows deleted:" + rows);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
		}

	}

}