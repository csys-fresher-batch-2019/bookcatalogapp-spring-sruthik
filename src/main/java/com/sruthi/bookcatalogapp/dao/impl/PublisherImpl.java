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

import com.sruthi.bookcatalogapp.dao.PublisherDAO;
import com.sruthi.bookcatalogapp.domain.Publisher;
import com.sruthi.bookcatalogapp.exception.DBException;
import com.sruthi.bookcatalogapp.exception.ErrorConstant;
import com.sruthi.bookcatalogapp.util.ConnectionUtil;
@Repository
public class PublisherImpl implements PublisherDAO {
	private static final Logger logger = LoggerFactory.getLogger(PublisherImpl.class);
	@Override
	public void save(Publisher pub) throws DBException  {
		String sql = "insert into publishers(pub_name,pub_mail_id,pub_ph_no)values(?,?,?)";
		
		
		try(Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);
				) {
			pst.setString(1, pub.getPubName());
			pst.setString(2, pub.getPubMailId());
			pst.setLong(3, pub.getPubPhNo());
			
			//step 3:Execute the query
			int rows = pst.executeUpdate();
			logger.debug("No of rows inserted:"+rows);
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
					}
	
	
	

	@Override
	public void update(Publisher pub) throws DBException  {
		
		String sql = "update publishers set pub_mail_id = ?,pub_ph_no = ? where pub_id = ?";
		try(Connection connection = ConnectionUtil.getConnection();
		        PreparedStatement pst = connection.prepareStatement(sql);
		        ) {
			pst.setString(1, pub.getPubMailId());
			pst.setLong(2, pub.getPubPhNo());
			pst.setInt(3, pub.getPubId());
			int rows = pst.executeUpdate();
			logger.debug("No of rows updated:"+rows);
		} catch (SQLException e) {
			
			logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}
	}
	

@Override
public void delete(int pubId) throws DBException  {
	String sql = "Delete publishers where pub_id = ?";
	try(Connection connection = ConnectionUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql)
		    ) {
		pst.setInt(1, pubId);
		int rows = pst.executeUpdate();
		logger.debug("No of rows deleted:"+rows);
	} catch (SQLException e) {
		
		logger.debug(e.getMessage());
		throw new DBException(ErrorConstant.INVALID_DELETE);
	}
	
}



@Override
public List<Publisher> findAll() throws DBException {
	List<Publisher> list = new ArrayList<>();
	String sql = "select pub_id,pub_name,pub_mail_id,pub_ph_no from publishers";
	
	try(Connection connection = ConnectionUtil.getConnection();
			Statement stmt=connection.createStatement();
		    ) {
		try(ResultSet rs = stmt.executeQuery(sql)){
		while(rs.next()) {
			int pubId = rs.getInt("pub_id");
			String pubName = rs.getString("pub_name");
			String pubMailId = rs.getString("pub_mail_id");
			Long pubPhNo = rs.getLong("pub_ph_no");
			Publisher pub = new Publisher();
			pub.setPubId(pubId);
			pub.setPubName(pubName);
			pub.setPubMailId(pubMailId);
			pub.setPubPhNo(pubPhNo);
			logger.debug("Publisher-Id"+pubId+"Publisher Name : "+pubName+"\nPublisher Mail-id : "+pubMailId+"\nPublisher Ph-no : "+pubPhNo);
			list.add(pub);
		}
		}
	} catch (SQLException e) {
		
		logger.debug(e.getMessage());
		throw new DBException(ErrorConstant.INVALID_SELECT);
	}
    
	
	return list;
}

}
