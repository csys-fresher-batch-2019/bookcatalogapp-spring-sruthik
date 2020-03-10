package com.sruthi.bookcatalogapp.dao;

import java.util.List;
import com.sruthi.bookcatalogapp.domain.Users;
import com.sruthi.bookcatalogapp.exception.DBException;

public interface UserDAO {
	List<Users> findAll()throws DBException  ;
	int save(Users user) throws DBException;

}
