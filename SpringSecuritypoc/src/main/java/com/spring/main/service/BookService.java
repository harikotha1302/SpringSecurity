package com.spring.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.main.model.Book;
import com.spring.main.repositories.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo br;
	
	List<Book> ls=new ArrayList<Book>();;
	
	public List<Book> getBook(){
		for(Book b:br.findAll())
		{
			ls.add(b);
		}
		return ls;
	}
	
	public Book bookbyid(long id)
	{
		Optional<Book> book=br.findById(id);
		return book.isPresent()?book.get():null;
	}
	
	public List<Book> bookbysubject(String subject) {
		ls.clear();
		ls=br.findBySubject(subject);
		return ls;
		
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
