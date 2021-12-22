package com.caa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caa.entities.Task;
import com.caa.services.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {

	@Autowired
	private TaskService taskService;

//	@GetMapping(value = "/user/{user_id}/task")
//	public List<Task> listAll(@PathVariable int user_id) {
//		return this.taskService.getAllTask();
//	}
//
	@PutMapping(value = "/user/{user_id}/task/{task_id}")
	public Task update(@RequestBody Task task, @PathVariable int user_id,@PathVariable int task_id) throws Exception {
		return this.taskService.updateTask(task, user_id,task_id);
	}
//
//	@GetMapping(value = "/user/{user_id}/task/{task_id}")
//	public Task findByinfo(@PathVariable int user_id,@PathVariable int task_id) throws Exception {
//		return this.taskService.findByInfo(user_id,task_id);
//	}

	@PostMapping(value = "/user/{user_id}/task/{task_id}")
	public Task create(@RequestBody Task task, @PathVariable int user_id) {
		return this.taskService.createTask(task,user_id);
	}
	
	@DeleteMapping(value = "/user/{user_id}/task/{task_id}")
	public String delete(@PathVariable int user_id,@PathVariable int task_id) {
		return this.taskService.deleteTask(user_id,task_id);
	}
}
