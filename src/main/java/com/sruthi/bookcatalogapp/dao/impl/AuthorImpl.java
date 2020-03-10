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
import com.sruthi.bookcatalogapp.dao.AuthorDAO;
import com.sruthi.bookcatalogapp.domain.Author;
import com.sruthi.bookcatalogapp.exception.DBException;

import com.sruthi.bookcatalogapp.util.ConnectionUtil;

@Repository

public class AuthorImpl implements AuthorDAO {

	private static final Logger logger = LoggerFactory.getLogger(AuthorImpl.class);

	@Override
	public void save(Author author)throws DBException {
		String sql = "insert into authors1(author_name,author_mail_id,author_ph) values(?,?,?)";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, author.getName());
			pst.setString(2, author.getMailId());
			pst.setLong(3, author.getPhoneNumber());
			int rows = pst.executeUpdate();
			logger.info("No of rows inserted:" + rows);
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DBException("Unable to add");


		}

	}

	public List<Author> findAll() throws DBException {
		List<Author> a = new ArrayList<>();
		String sql = "select author_id,author_name,author_mail_id,author_ph from authors1";

		try (Connection connection = ConnectionUtil.getConnection(); Statement stmt = connection.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					int authorId = rs.getInt("author_id");
					String authorName = rs.getString("author_name");
					String authorMailId = rs.getString("author_mail_id");
					long authorPhNo = rs.getLong("author_ph");
					Author author = new Author();
					author.setId(authorId);
					author.setName(authorName);
					author.setMailId(authorMailId);
					author.setPhoneNumber(authorPhNo);
					a.add(author);
				}
			}
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException("Unable to display");
		}

		return a;
	}

	public void update(Author author) throws DBException {
		String sql = "update authors1 set author_mail_id = ?,author_ph = ? where author_id = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, author.getMailId());
			pst.setLong(2, author.getPhoneNumber());
			pst.setInt(3, author.getId());

			int rows = pst.executeUpdate();
			logger.debug("No of rows updated:" + rows);
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException("Unable to update");
		}

	}

	public void delete(int authorId) throws DBException {
		String sql = "Delete authors1 where author_id = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, authorId);
			int rows = pst.executeUpdate();
			logger.debug("No of rows deleted:" + rows);
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException("Unable to delete");
		}

	}

}
