package com.spring.main.utility;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.main.model.Book;

@Component
public class UserBook {

	private Book b;
	private boolean isAssigned;
	
	public UserBook() {
		super();
	}

	public UserBook(Book b, boolean isAssigned) {
		super();
		this.b = b;
		this.isAssigned = isAssigned;
	}

	public Book getB() {
		return b;
	}

	public void setB(Book b) {
		this.b = b;
	}

	public boolean getIsAssigned() {
		return isAssigned;
	}

	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}
	
	
}
