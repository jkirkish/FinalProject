package com.coderscampus.FinalProject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.coderscampus.FinalProject.domain.User;

@Controller
public class LoginController {

	//http://localhost:8080/login
	@GetMapping("/login")
	public String getLogin(ModelMap model) {
		User user = new User();
		model.put("user", user);
		return "login";
	}
}
