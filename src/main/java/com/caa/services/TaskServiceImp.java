package com.caa.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caa.entities.Task;
import com.caa.entities.User;
import com.caa.repo.TaskRepo;

@Service
public class TaskServiceImp implements TaskService{

	@Autowired
	private TaskRepo taskRepo;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Task createTask(Task task,int user_id) {	
		Task t = null;
		try {
			User user = this.userService.findById(user_id);
			
			if(user != null) {
				task.setUser_id(user_id);
				t = this.taskRepo.save(task);
			}
		} catch (Exception e) {
			System.out.println("user not found with the given id ,task is not created");
		}
		return t;
	}

	@Override
	public String deleteTask(int user_id,int task_id) {
		Optional<Task> task = this.taskRepo.findById(task_id);
		if(task.isPresent() && task.get().getUser_id() == user_id) {
			this.taskRepo.delete(task.get());
			if(!this.taskRepo.findById(task_id).isPresent()) {
				return "Deleted";
			}			
		}
		return "Not Deleted";
	}

	@Override
	public Task updateTask(Task task, int user_id,int task_id) throws Exception{
		System.out.println("task id "+task_id);
		Optional<Task> task_ = this.taskRepo.findById(task_id);
		if(!task_.isPresent()) {
			throw new Exception("task not found with the given id");
		}
		task_.get().setDate_time(task.getDate_time());;
		task_.get().setDescription(task.getDescription());;
		task_.get().setName(task.getName());
		task.setId(task_id);
		try {
			User user = this.userService.findById(user_id);
			
			if(user != null) {
				task.setUser_id(user_id);
				task = this.taskRepo.save(task);
			}
		} catch (Exception e) {
			System.out.println("user not found with the given id ,task is not updated");
		}
		
		return task;
	}

	@Override
	public List<Task> getAllTask() {
		return this.taskRepo.findAll();
	}

	@Override
	public Task findByInfo(int user_id, int task_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
