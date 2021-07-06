package com.coderscampus.FinalProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.coderscampus.FinalProject.Service.UserService;
import com.coderscampus.FinalProject.domain.User;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/register")
	public String CreateUser (ModelMap model) {
		User user = new User();
		model.put("user", user);
		return "register";
	}
	
	@PostMapping("/register")
	public String postCreateUser (User user) {
		System.out.println(user);
		userService.createUser(user);
		return "redirect:/register";
	}

}