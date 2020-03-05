package com.sruthi.bookcatalogapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sruthi.bookcatalogapp.domain.Users;
import com.sruthi.bookcatalogapp.exception.DBException;

public interface UserDAO {
	List<Users> displayUsers()throws DBException  ;
	int addUser(Users user) throws DBException;

}
