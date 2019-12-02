package com.spring.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.main.model.Book;
import com.spring.main.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bs;
	
	@GetMapping("/")
	public String welcome()
	{
		return "welcome";
	}

	@GetMapping("/book")
	public ModelAndView getbooks()
	{
		ModelAndView mav=new ModelAndView("viewbook");
		List<Book> b=bs.getBook();
		mav.addObject("books",b);
		return mav;
		
	}
	
	@GetMapping("/viewbook")
	public ModelAndView viewbooks()
	{
		ModelAndView mav=new ModelAndView("viewbook");
		List<Book> b=bs.getBook();
		mav.addObject("books",b);
		return mav;
		
	}
	
	@GetMapping("/addbook")
	public ModelAndView addbook()
	{
		ModelAndView mav=new ModelAndView("addbook","bookadd",new Book());
		return mav;
	}
	
	@PostMapping("/addbook")
	public ModelAndView addbook(@Valid @ModelAttribute("bookadd") Book book,BindingResult result)
	{
		ModelAndView mav=null;
		if(result.hasErrors())
		{
			mav=new ModelAndView("addbook","bookattribute",book);
			return mav;
		}
		else
		{
			bs.save(book);
			mav=new ModelAndView("redirect:/viewbook");
			return mav;
		}
		
	}
	
//	@GetMapping("/searchbook")
	
	
}
