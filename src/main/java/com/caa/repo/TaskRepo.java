package com.caa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.caa.entities.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
	
	@Query("select u from Task u where u.user_id = ?1 and u.id = ?2")
	Task findByUser_idAndId(int user_id,int id);
	
	@Query("select u from Task u where u.user_id = ?1")
	List<Task> findByallByIdAndUser_id(int user_id);
}
