package com.coderscampus.FinalProject.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.FinalProject.domain.User;
import com.coderscampus.FinalProject.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User createUser(User user) {
		Long id = user.getUserId();
		user.setUserId(id);
		return userRepo.save(user);
	}
	
	public User save(User user) {
		return userRepo.save(user);
	}
	
	public List<User>findAll (){
		return userRepo.findAll();
	}
	public User findById(Long userId)
	{	
		Optional<User> userOpt = userRepo.findById(userId);
		return userOpt.orElse(new User());
	}
	public void delete(Long userId) {
		userRepo.deleteById(userId);	
		
	}

}
