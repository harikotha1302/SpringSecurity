package com.spring.main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.main.model.Role;
import com.spring.main.model.User;
import com.spring.main.repositories.RoleRepo;
import com.spring.main.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService us;
	
	@Autowired
	private RoleRepo rr;
	
	@ModelAttribute("userForm")
	public User create()
	{
		return new User();
	}
	
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/registration")
	public ModelAndView registration(Model model)
	{
		List<Role> roles=rr.findAll();
		ModelAndView mav=new ModelAndView("registration","radio",roles);
		return mav;
	}
	
	@PostMapping("/registration")
	public String registration(@ModelAttribute("userform") User user)
	{
		us.save(user);
		return "redirect:/login";
	}
	
	@GetMapping("/")
	public String index() {
		

        return "index";
	}
	
	@GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
	
	
}
