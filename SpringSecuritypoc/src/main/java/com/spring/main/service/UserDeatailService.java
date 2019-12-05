package com.spring.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.main.model.CustomUserDeatails;
import com.spring.main.model.User;

@Service
public class UserDeatailService implements UserDetailsService {

	@Autowired
	private UserService us;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionaluser=us.findByUserName(username);
		optionaluser
		.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	return optionaluser
            .map(CustomUserDeatails::new).get(); 
	}

}
