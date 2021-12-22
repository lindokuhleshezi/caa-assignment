package com.caa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caa.entities.User;

@Repository
public interface UsersRepo extends JpaRepository<User, Integer>{
	public User findbyUserName(String username);
}
