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
import com.sruthi.bookcatalogapp.exception.DBException;
import com.sruthi.bookcatalogapp.util.ConnectionUtil;

@Repository
public class SubjectImpl implements SubjectDAO {
	private static final Logger logger = LoggerFactory.getLogger(SubjectImpl.class);

	@Override
	public void save(Subject sub) throws DBException {
		String sql = "insert into subjects(sub_name)values(?)";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, sub.getName());
			int rows = pst.executeUpdate();
			logger.debug("No of rows inserted:" + rows);

		} catch (SQLException e) {

			logger.debug(e.getMessage());
			throw new DBException("Unable to add");
		}

	}

	@Override
	public List<Subject> findAll() throws DBException {
		List<Subject> list = new ArrayList<>();

		String sql = "select sub_id,sub_name from subjects";
		try (Connection connection = ConnectionUtil.getConnection(); Statement stmt = connection.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {

					int subId = rs.getInt("sub_id");
					String subName = rs.getString("sub_name");
					Subject sub = new Subject();
					sub.setId(subId);
					sub.setName(subName);
					list.add(sub);

				}
			}
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DBException("Unable to display");
		}

		return list;
	}

	@Override
	public void update(Subject sub) throws DBException {
		String sql = "update subjects set sub_name = ?where sub_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, sub.getName());
			pst.setInt(2, sub.getId());
			int rows = pst.executeUpdate();
			logger.debug("No of rows updated:" + rows);
		} catch (SQLException e) {

			logger.debug(e.getMessage());
			throw new DBException("Unable to update");
		}

	}

	@Override
	public void delete(int subId) throws DBException {
		String sql = "Delete from subjects where sub_id = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, subId);
			int rows = pst.executeUpdate();
			logger.debug("No of rows deleted:" + rows);
		} catch (SQLException e) {

			logger.debug(e.getMessage());
			throw new DBException("Unable to delete");
		}

	}

}
