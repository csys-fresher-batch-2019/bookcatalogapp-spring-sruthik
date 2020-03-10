package com.sruthi.bookcatalogapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sruthi.bookcatalogapp.dao.TitleDAO;
import com.sruthi.bookcatalogapp.domain.Title;
import com.sruthi.bookcatalogapp.exception.DBException;
import com.sruthi.bookcatalogapp.util.ConnectionUtil;

@Repository
public class TitleImpl implements TitleDAO {
	private static final Logger logger = LoggerFactory.getLogger(TitleImpl.class);
	private static final String TITLE = "TITLE";
	private static final String PRICE = "PRICE";

	@Override
	public void save(Title title) throws DBException {
		String sql = "insert into titles(pub_id,author_id,sub_id,pub_date,title,version_number,price)values(?,?,?,?,?,?,?)";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, title.getPublisherId());
			pst.setInt(2, title.getAuthorId());
			pst.setInt(3, title.getId());
			pst.setDate(4, Date.valueOf(title.getPublishedDate()));
			pst.setString(5, title.getTitleName());
			pst.setInt(6, title.getVersionNumber());
			pst.setInt(7, title.getPrice());

			int rows = pst.executeUpdate();
			logger.debug("No of rows inserted:" + rows);
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException("Unable to add");
		}
	}

	@Override
	public void update(Title title) throws DBException {
		String sql = "Update titles set pub_date = ? where title = ? and version_number = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setDate(1, Date.valueOf(title.getPublishedDate()));
			pst.setString(2, title.getTitleName());
			pst.setInt(3, title.getVersionNumber());
			int rows = pst.executeUpdate();
			logger.debug("No of rows updated:" + rows);
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException("Unable to update");
		}
	}

	@Override
	public List<Title> findAll() throws DBException {
		List<Title> list = new ArrayList<>();
		String sql = "select title,price,version_number,pub_date,title_id,pub_id,author_id,sub_id from titles";
		try (Connection connection = ConnectionUtil.getConnection(); Statement stmt = connection.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					int titleId = rs.getInt("title_id");
					int pubId = rs.getInt("pub_id");
					int authorId = rs.getInt("author_id");
					int subId = rs.getInt("sub_id");
					String title = rs.getString(TITLE);
					int price = rs.getInt(PRICE);
					int versionNumber = rs.getInt("version_number");
					LocalDate date = rs.getDate("pub_date").toLocalDate();
					

					Title t = new Title();
					t.setId(titleId);
					t.setPublisherId(pubId);
					t.setAuthorId(authorId);
					t.setSubjectId(subId);
					t.setTitleName(title);
					t.setPrice(price);
					t.setVersionNumber(versionNumber);
					t.setPublishedDate(date);

					list.add(t);

				}
			}
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException("Unable to display");
		}
		return list;
	}

	@Override
	public void delete(int titleId) throws DBException {
		String sql = "Delete from titles where title_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, titleId);
			int rows = pst.executeUpdate();
			logger.debug("No of rows deleted:" + rows);
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException("Unable to delete");
		}
	}

	public List<Title> findByCourseId(int courseId) throws DBException {
		List<Title> list = new ArrayList<>();
		String sql = "select pub_id,author_id,sub_id,title,version_number,price,pub_date,course_id from titles t INNER JOIN course_titles c ON t.title_id = c.title_id where course_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, courseId);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					int pubId = rs.getInt("pub_id");
					int authorId = rs.getInt("author_id");
					int subId = rs.getInt("sub_id");
					String name = rs.getString(TITLE);
					int versionNumber = rs.getInt("version_number");
					int price = rs.getInt(PRICE);
					LocalDate pubDate = rs.getDate("pub_date").toLocalDate();
					Title t = new Title();
					t.setPublisherId(pubId);
					t.setAuthorId(authorId);
					t.setSubjectId(subId);
					t.setTitleName(name);
					t.setVersionNumber(versionNumber);
					t.setPrice(price);
					t.setPublishedDate(pubDate);
					list.add(t);

				}
			}
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException("Unable to display");
		}

		return list;

	}

	@Override
	public List<Title> findByYear(LocalDate pubDate) throws DBException {
		List<Title> list = new ArrayList<>();
		String sql = "select pub_id,author_id,sub_id,title,version_number,price from titles where to_char(pub_date,'yyyy') = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			
				pst.setInt(1, pubDate.getYear());
			
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					int pubId = rs.getInt("pub_id");
					int authorId = rs.getInt("author_id");
					int subId = rs.getInt("sub_id");
					String title = rs.getString(TITLE);
					int version = rs.getInt("version_number");
					int price = rs.getInt("PRICE");
					Title t = new Title();
					t.setPublisherId(pubId);
					t.setAuthorId(authorId);
					t.setSubjectId(subId);
					t.setTitleName(title);
					t.setVersionNumber(version);
					t.setPrice(price);
					list.add(t);
							}
			} 
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DBException("Unable to display");
		}
		return list;
	}

	

	@Override
	public List<Title> findRecentBooks() throws DBException {
		List<Title> list = new ArrayList<>();
		String sql = "select pub_id,author_id,sub_id,title,version_number,price,pub_date from titles order by pub_date desc";
		try (Connection connection = ConnectionUtil.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {

			while (rs.next()) {
				int pubId = rs.getInt("pub_id");
				int authorId = rs.getInt("author_id");
				int subId = rs.getInt("sub_id");
				String title = rs.getString(TITLE);
				int price = rs.getInt(PRICE);
				LocalDate date = rs.getDate("pub_date").toLocalDate();
				int version = rs.getInt("version_number");
				Title t = new Title();
				t.setPublisherId(pubId);
				t.setAuthorId(authorId);
				t.setSubjectId(subId);
				t.setTitleName(title);
				t.setPrice(price);
				t.setPublishedDate(date);
				t.setVersionNumber(version);
				list.add(t);

			}
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException("Unable to display");
		}
		return list;
	}

	public List<Title> findByPublisherName(String pubName) throws DBException {
		List<Title> list = new ArrayList<>();
		String sql = "select title,version_number,price from titles t INNER JOIN publishers p ON t.pub_id = p.pub_id where pub_name=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, pubName);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {

					String name = rs.getString(TITLE);
					int versionNumber = rs.getInt("version_number");
					int price = rs.getInt(PRICE);

					Title t = new Title();

					t.setTitleName(name);
					t.setVersionNumber(versionNumber);
					t.setPrice(price);
					list.add(t);

				}
			}
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException("Unable to display");
		}

		return list;

	}

	
	public List<Title> findBySubjectName(String subName) throws DBException {
		List<Title> list = new ArrayList<>();
		String sql = "select pub_id,author_id,TITLE,version_number,PRICE from titles t INNER JOIN subjects s ON t.sub_id = s.sub_id where sub_name=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, subName);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					int pubId = rs.getInt("pub_id");
					int authorId = rs.getInt("author_id");
					String name = rs.getString(TITLE);
					int versionNumber = rs.getInt("version_number");
					int price = rs.getInt(PRICE);

					Title t = new Title();
					t.setPublisherId(pubId);
					t.setAuthorId(authorId);
					t.setTitleName(name);
					t.setVersionNumber(versionNumber);
					t.setPrice(price);
					list.add(t);

				}
			}
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DBException("Unable to display");
		}

		return list;

	}

	@Override
	public List<Title> findByAuthorName(String authorName) throws DBException {
		List<Title> list = new ArrayList<>();
		String sql = "select TITLE,version_number,PRICE from titles t INNER JOIN authors1 a ON t.author_id = a.author_id where author_name=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, authorName);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {

					String name = rs.getString(TITLE);
					int versionNumber = rs.getInt("version_number");
					int price = rs.getInt(PRICE);

					Title t = new Title();

					t.setTitleName(name);
					t.setVersionNumber(versionNumber);
					t.setPrice(price);
					list.add(t);

				}
			}
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException("Unable to display");
		}

		return list;

	}

	
}
