package com.spring.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.main.service.UserService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private UserService ur;
	
	@GetMapping("/")
	public String welcome() {
		return "Student/student";
	}
	
	

}
