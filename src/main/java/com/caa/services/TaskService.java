package com.caa.services;

import java.util.List;

import com.caa.entities.Task;

public interface TaskService {

	Task createTask(Task task,int user_id);
	boolean deleteTask(int id);
	Task updateTask(Task task,int user_id,int task_id) throws Exception;
	List<Task> getAllTask();
	Task findByInfo(int user_id,int task_id);
}
