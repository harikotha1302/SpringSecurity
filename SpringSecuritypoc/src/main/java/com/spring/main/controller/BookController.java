package com.spring.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.main.model.Book;
import com.spring.main.model.User;
import com.spring.main.service.BookService;

@Controller
@RequestMapping("/library")
@PreAuthorize("hasAnyRole('LIB')")
public class BookController {
	
	@Autowired
	private BookService bs;
	
	@GetMapping("")
	public String library()
	{
		return "Librarian/Library";
	}
		
	@GetMapping("/viewbook")
	public ModelAndView viewbooks()
	{
		ModelAndView mav=new ModelAndView("Librarian/viewbook");
		List<Book> b=new ArrayList<>();
		b=bs.getBook();
		mav.addObject("books",b);
		return mav;
		
	}
	
	@GetMapping("/addbook")
	public ModelAndView addbook()
	{
		ModelAndView mav=new ModelAndView("Librarian/addbook","bookadd",new Book());
		return mav;
	}
	
	@PostMapping("/addbook")
	public ModelAndView addbook(@Valid @ModelAttribute("bookadd") Book book,BindingResult result)
	{
		ModelAndView mav=null;
		if(result.hasErrors())
		{
			mav=new ModelAndView("Librarian/addbook","bookattribute",book);
			return mav;
		}
		else
		{
			bs.save(book);
			mav=new ModelAndView("redirect:/library/viewbook");
			return mav;
		}
		
	}
	
	@GetMapping("/searchbook")
	public ModelAndView searchbook() {
		List<Book> b=bs.getBook();
		ModelAndView mav=new ModelAndView("Librarian/searchbook","books",b);
		return mav;
		
	}
	
	@PostMapping("/searchbook")
	public ModelAndView searchbook(@RequestParam("searchby") String searchby,@RequestParam("searchvalue") String value) {
		List<Book> b=new ArrayList<Book>();
		if(searchby.equals("id"))
		{
			Long id=Long.parseLong(value);
			System.out.println(id);
			b.add(bs.bookbyid(id));
		}
		else
		{
			b=bs.bookbysubject(value);
		}
		return new ModelAndView("Librarian/searchbook","books",b);
	}
	
	@GetMapping("/delete")
	public ModelAndView delete() {
		List<Book> b=new ArrayList<Book>();
		b=bs.getBook();
		return new ModelAndView("Librarian/delete","books",b);
	}
	
	@GetMapping("/deletebook")
	public ModelAndView delete(@RequestParam("bookid") long id) {
		bs.delete(id);
		return new ModelAndView("redirect:/library/viewbook");
		
	}
	
	@GetMapping("/viewuser")
	public ModelAndView users(@RequestParam("bookid") long id)
	{
		List<User> u=new ArrayList<>();
		u=bs.bookByuser(id);
		return new ModelAndView("Librarian/viewuser","user",u);
	}
	
}
