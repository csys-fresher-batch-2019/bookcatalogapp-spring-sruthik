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
import com.sruthi.bookcatalogapp.exception.ErrorConstant;
import com.sruthi.bookcatalogapp.util.ConnectionUtil;

@Repository
public class TitleImpl implements TitleDAO {
	private static final Logger logger = LoggerFactory.getLogger(TitleImpl.class);
	private static final String ACTION_1 = "title";
	private static final String ACTION_2 = "price";

	@Override
	public void addTitle(Title title) throws DBException {
		String sql = "insert into titles(pub_id,author_id,sub_id,pub_date,title,version_number,price)values(?,?,?,?,?,?,?)";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, title.getPubId());
			pst.setInt(2, title.getAuthorId());
			pst.setInt(3, title.getSubId());
			pst.setDate(4, Date.valueOf(title.getPubDate()));
			pst.setString(5, title.getTitle());
			pst.setInt(6, title.getVersionNumber());
			pst.setInt(7, title.getPrice());

			int rows = pst.executeUpdate();
			logger.debug("No of rows inserted:" + rows);
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
	}

	@Override
	public void changePubDate(Title title) throws DBException {
		String sql = "Update titles set pub_date = ? where title = ? and version_number = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setDate(1, Date.valueOf(title.getPubDate()));
			pst.setString(2, title.getTitle());
			pst.setInt(3, title.getVersionNumber());
			int rows = pst.executeUpdate();
			logger.debug("No of rows updated:" + rows);
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}
	}

	@Override
	public List<Title> displayTitleWithPrice() throws DBException {
		List<Title> list = new ArrayList<>();
		String sql = "select title,price,version_number,pub_date,title_id,pub_id,author_id,sub_id from titles";
		try (Connection connection = ConnectionUtil.getConnection(); Statement stmt = connection.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					int titleId = rs.getInt("title_id");
					int pubId = rs.getInt("pub_id");
					int authorId = rs.getInt("author_id");
					int subId = rs.getInt("sub_id");
					String title = rs.getString(ACTION_1);
					int price = rs.getInt(ACTION_2);
					int versionNumber = rs.getInt("version_number");
					LocalDate date = rs.getDate("pub_date").toLocalDate();
					logger.debug("title-id: " + titleId + "pub-id : " + pubId + "Author-id : " + authorId
							+ "Subject-Id : " + subId + "title: " + title + "\nprice: " + price + "\nversion: "
							+ versionNumber + "Published-date: " + date);

					Title t = new Title();
					t.setTitleId(titleId);
					t.setPubId(pubId);
					t.setAuthorId(authorId);
					t.setSubId(subId);
					t.setTitle(title);
					t.setPrice(price);
					t.setVersionNumber(versionNumber);
					t.setPubDate(date);

					list.add(t);

				}
			}
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	@Override
	public void deleteTitle(int titleId) throws DBException {
		String sql = "Delete from titles where title_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, titleId);
			int rows = pst.executeUpdate();
			logger.debug("No of rows deleted:" + rows);
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_DELETE);
		}
	}

	public List<Title> displayTitleForCourseId(int courseId) throws DBException {
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
					String name = rs.getString(ACTION_1);
					int versionNumber = rs.getInt("version_number");
					int price = rs.getInt(ACTION_2);
					LocalDate pubDate = rs.getDate("pub_date").toLocalDate();
					Title t = new Title();
					t.setPubId(pubId);
					t.setAuthorId(authorId);
					t.setSubId(subId);
					t.setTitle(name);
					t.setVersionNumber(versionNumber);
					t.setPrice(price);
					t.setPubDate(pubDate);
					list.add(t);

				}
			}
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}

		return list;

	}

	@Override
	public List<Title> displayYearWiseBooks(LocalDate pubDate) throws DBException {
		List<Title> list = new ArrayList<>();
		String sql = "select pub_id,author_id,sub_id,title,version_number,price from titles where to_char(pub_date,'yyyy') = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			try {
				pst.setInt(1, pubDate.getYear());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					int pubId = rs.getInt("pub_id");
					int authorId = rs.getInt("author_id");
					int subId = rs.getInt("sub_id");
					String title = rs.getString(ACTION_1);
					int version = rs.getInt("version_number");
					int price = rs.getInt("price");
					Title t = new Title();
					t.setPubId(pubId);
					t.setAuthorId(authorId);
					t.setSubId(subId);
					t.setTitle(title);
					t.setVersionNumber(version);
					t.setPrice(price);
					list.add(t);
					logger.debug("title : " + title + "\nVersion number : " + version + "\nPrice : " + price);
				}
			} catch (SQLException e) {
				logger.debug(e.getMessage());
				throw new DBException(ErrorConstant.INVALID_SELECT);
			}
		} catch (SQLException e2) {

			e2.printStackTrace();

			logger.error(e2.getMessage());
		}

		return list;
	}

	@Override
	public List<Title> displayBooksPublishedByIndividualPublishers() throws DBException {

		List<Title> list = new ArrayList<>();
		String sql = "select pub_name, count(*) as count from   publishers p, titles t where  p.pub_id = t.pub_id group  by pub_name";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				String pubName = rs.getString("pub_name");
				int count = rs.getInt("count");

				logger.debug(("Publisher-Name : " + pubName + "\nNo of books Published : " + count));

			}
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	@Override
	public List<Title> displayByRecentBooks() throws DBException {
		List<Title> list = new ArrayList<>();
		String sql = "select pub_id,author_id,sub_id,title,version_number,price,pub_date from titles order by pub_date desc";
		try (Connection connection = ConnectionUtil.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {

			while (rs.next()) {
				int pubId = rs.getInt("pub_id");
				int authorId = rs.getInt("author_id");
				int subId = rs.getInt("sub_id");
				String title = rs.getString(ACTION_1);
				int price = rs.getInt(ACTION_2);
				LocalDate date = rs.getDate("pub_date").toLocalDate();
				int version = rs.getInt("version_number");
				Title t = new Title();
				t.setPubId(pubId);
				t.setAuthorId(authorId);
				t.setSubId(subId);
				t.setTitle(title);
				t.setPrice(price);
				t.setPubDate(date);
				t.setVersionNumber(version);
				list.add(t);

			}
		} catch (Exception e) {
			
			logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	@Override
	public List<Title> displayTitle(int pubId) {
		List<Title> list = new ArrayList<>();
		String sql = "select title from titles where pub_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, pubId);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					String title = rs.getString(ACTION_1);
					int version = rs.getInt("version_number");
					int price = rs.getInt("price");
					Title t = new Title();
					t.setTitle(title);
					t.setVersionNumber(version);
					t.setPrice(price);
					list.add(t);
					logger.debug("title : " + title + "\nVersion number : " + version + "\nPrice : " + price);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return list;
	}

	public List<Title> displayTitleForPubName(String pubName) throws DBException {
		List<Title> list = new ArrayList<>();
		String sql = "select title,version_number,price from titles t INNER JOIN publishers p ON t.pub_id = p.pub_id where pub_name=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, pubName);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {

					String name = rs.getString(ACTION_1);
					int versionNumber = rs.getInt("version_number");
					int price = rs.getInt(ACTION_2);

					Title t = new Title();

					t.setTitle(name);
					t.setVersionNumber(versionNumber);
					t.setPrice(price);
					list.add(t);

				}
			}
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}

		return list;

	}

	public List<Title> displayTitleForSubName(String subName) {
		List<Title> list = new ArrayList<>();
		String sql = "select pub_id,author_id,title,version_number,price from titles t INNER JOIN subjects s ON t.sub_id = s.sub_id where sub_name=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, subName);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					int pubId = rs.getInt("pub_id");
					int authorId = rs.getInt("author_id");
					String name = rs.getString(ACTION_1);
					int versionNumber = rs.getInt("version_number");
					int price = rs.getInt(ACTION_2);

					Title t = new Title();
					t.setPubId(pubId);
					t.setAuthorId(authorId);
					t.setTitle(name);
					t.setVersionNumber(versionNumber);
					t.setPrice(price);
					list.add(t);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
		}

		return list;

	}

	@Override
	public List<Title> displayTitleForAuthorName(String authorName) throws DBException {
		List<Title> list = new ArrayList<>();
		String sql = "select title,version_number,price from titles t INNER JOIN authors1 a ON t.author_id = a.author_id where author_name=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, authorName);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {

					String name = rs.getString(ACTION_1);
					int versionNumber = rs.getInt("version_number");
					int price = rs.getInt(ACTION_2);

					Title t = new Title();

					t.setTitle(name);
					t.setVersionNumber(versionNumber);
					t.setPrice(price);
					list.add(t);

				}
			}
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}

		return list;

	}

	public int displayPrice(String title, int version) throws DBException {
		int price = 0;
		String sql = "select price from titles where title = ? and version_number = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, title);
			pst.setInt(2, version);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

					price = rs.getInt(ACTION_2);

					logger.debug("price: " + price);

					Title t = new Title();
					t.setPrice(price);

				}
			}
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return price;

	}
}
