package com.spring.main.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDeatails extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomUserDeatails(final User user) {
		super(user);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRoles()
				.stream()
				.map(role->new SimpleGrantedAuthority("ROLE_"+ role.getRolename())).collect(Collectors.toList());
	}

	 @Override
	    public String getPassword() {
	        return super.getPassword();
	    }

	    @Override
	    public String getUsername() {
	        return super.getUsername();
	    }
	    
	    @Override
	    public long getUserid() {
	    	return super.getUserid();
	    }

	    
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
