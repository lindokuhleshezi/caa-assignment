package com.caa.services;

import java.util.List;

import com.caa.entities.User;

public interface UserService {

	List<User> listAll();
	
	User update(User user,int id)throws Exception;
	
	User create(User user);
	
	User findById(int id) throws Exception;
}
