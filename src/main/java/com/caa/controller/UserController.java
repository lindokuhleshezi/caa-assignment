package com.caa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caa.entities.User;
import com.caa.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/user")
	public List<User> listAll() {
		return this.userService.listAll();
	}

	@PutMapping(value = "/user/{id}")
	public User update(@RequestBody User user, @PathVariable int id) throws Exception {
		return this.userService.update(user, id);
	}

	@GetMapping(value = "/user/{id}")
	public User findByid(@PathVariable int id) throws Exception {
		return this.userService.findById(id);
	}

	@PostMapping(value = "/user")
	public User create(@RequestBody User user) {
		return this.userService.create(user);
	}
}
