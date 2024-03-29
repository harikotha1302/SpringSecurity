package com.spring.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.main.model.Book;
import com.spring.main.model.User;
import com.spring.main.repositories.BookRepo;
import com.spring.main.repositories.UserRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo br;
	
	@Autowired
	private UserRepo ur;
	
	List<Book> ls=new ArrayList<Book>();
	
	public List<Book> getBook(){
		ls.clear();
		for(Book b:br.findAll())
		{
			ls.add(b);
		}
		return ls;
	}
	
	public Book bookbyid(long id)
	{
		Optional<Book> book=br.findByBookid(id);
		return book.isPresent()?book.get():null;
	}
	
	public List<Book> bookbysubject(String subject) {
		ls.clear();
		ls=br.findBySubject(subject);
		return ls;
		
	}
	
	public List<User> userbybook(Long id)
	{
		ls.clear();
		Optional<Book> book=br.findByBookid(id);
		List<User> lu=new ArrayList<>();
		lu=book.get().getUser();
		return lu;
	}
	
	public Long save(Book b)
	{
		Book book=br.save(b);
		return book==null?-1:book.getBookid();
	}
	
	public Long delete(long id)
	{
		if(br.existsById(id))
		{
			br.deleteById(id);
			return id;
		}
		
		else {
			return (long) -1;
		}
	}
}
