package com.spring.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.main.model.Book;
import com.spring.main.model.User;
import com.spring.main.repositories.UserRepo;

@Service
public class UserService{

	@Autowired
	private UserRepo ur;
	
	@Autowired
	private PasswordEncoder pe;
	
	
	public void save(User user) {
		User u=new User();
		u.setUserid(user.getUserid());
		u.setPassword(pe.encode(user.getPassword()));
		u.setUsername(user.getUsername());
		u.setRoles(user.getRoles());
		ur.save(u);
	}
	
	public List<Book> getBooks(Long id)
	{
		List<Book> b=new ArrayList<Book>();
		User u=new User();
		u=ur.findByUserid(id);
		b=u.getBook();
		return b;
	}
	
	public Optional<User> findByUserName(String username)
	{
		return ur.findByUsername(username);
		
	}
	
}
