package com.coderscampus.FinalProject.web;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.coderscampus.FinalProject.Service.UserService;
import com.coderscampus.FinalProject.domain.User;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//http://localhost:8080/user
	@GetMapping("/user")
	public String getAllUsers(ModelMap model) {
		List<User>users = userService.findAll();
		model.put("user", users);
		return "user";	
	}
	
	
	//http://localhost:8080//user/1..2..3..etc
	@GetMapping("/user/{userId}")
	public String getOneUser(ModelMap model, @PathVariable Long userId)
	{
		User user = userService.findById(userId);
		model.put("user", Arrays.asList(user));
		model.put("user", user);
		return "user";
	}
	//http://localhost:8080//user/1..2..3..etc
	@PostMapping("/user/{userId}")
	public String postOneUser(User user)
	{
		userService.save(user);
		return "redirect:/user/"+user.getUserId();
	}
	//http://localhost:8080///user/{userId}/delete
	@PostMapping("/user/{userId}/delete")
	public String deleteOneUser(@PathVariable Long userId)
	{
		userService.delete(userId);
		return "redirect:/user";
	}
	
	

}
