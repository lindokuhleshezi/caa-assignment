package com.caa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caa.entities.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer>{
 
}

