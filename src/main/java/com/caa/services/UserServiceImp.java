package com.caa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caa.entities.User;
import com.caa.repo.UsersRepo;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UsersRepo userRepo;
	
	@Override
	public List<User> listAll() {
		return this.userRepo.findAll();
	}

	@Override
	public User update(User user,int id) throws Exception {
		Optional<User> user_ = this.userRepo.findById(id);
		if(!user_.isPresent()) {
			throw new Exception("user not found with the given id");
		}else if(this.userRepo.findbyUserName(user.getUsername())!= null) {
			throw new Exception("user cannot be update with the given username, username already exist");
		}
		user_.get().setFirst_name(user.getFirst_name());
		user_.get().setLast_name(user.getLast_name());
		user_.get().setUsername(user.getUsername());
		
		return this.userRepo.save(user_.get());
	}

	@Override
	public User create(User user) {
		return this.userRepo.save(user);
	}

	@Override
	public User findById(int id) {
		return this.userRepo.findById(id).get();
	}

}
