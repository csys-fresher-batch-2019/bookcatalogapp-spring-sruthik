package com.sruthi.bookcatalogapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sruthi.bookcatalogapp.domain.Users;

public interface UserDAO {
	List<Users> displayUsers() ;
	int addUser(Users user) ;

}
