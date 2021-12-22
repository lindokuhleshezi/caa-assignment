package com.caa.services;

import java.util.List;

import com.caa.entities.Task;

public interface TaskService {

	Task createTask();
	boolean deleteTask();
	Task updateTask();
	List<Task> getAllTask();
}
