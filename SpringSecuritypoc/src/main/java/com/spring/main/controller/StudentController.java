package com.spring.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.main.model.Book;
import com.spring.main.model.CustomUserDeatails;
import com.spring.main.model.User;
import com.spring.main.service.BookService;
import com.spring.main.service.UserService;
import com.spring.main.utility.UserBook;

@Controller
@RequestMapping("/student")
@PreAuthorize("hasAnyRole('STU')")
public class StudentController {
	
	@Autowired
	private UserService ur;
	
	@Autowired
	private BookService bs;
	
	
	@GetMapping("")
	public String welcome() {
		return "Student/student";
	}
	
	@GetMapping("/searchbook")
	public ModelAndView searchbook()
	{
		List<Book> b=bs.getBook();
		List<UserBook> ub=new ArrayList<UserBook>();
		List<User> userlist=new ArrayList<>();
		boolean isAssigned;
		Object user=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u=(CustomUserDeatails)user;
		for(Book book:b)
		{
			userlist=book.getUser();
			if(userlist.contains(u))
			{
				isAssigned=true;
			}
			else
			{
				isAssigned=false;
			}
			ub.add(new UserBook(book,isAssigned));
		}
		return new ModelAndView("Student/searchbook","userbook",ub);
	}
	
	@PostMapping("/searchbook")
	public ModelAndView searchbook(@RequestParam("searchby") String searchby,@RequestParam("searchvalue") String value)
	{
		List<Book> b=new ArrayList<>();
		Object user=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u=(CustomUserDeatails)user;
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
		List<UserBook> ub=new ArrayList<UserBook>();
		List<User> userlist=new ArrayList<>();
		boolean isAssigned;
		for(Book book:b)
		{
			userlist=book.getUser();
			if(userlist.contains(u))
			{
				isAssigned=true;
			}
			else
			{
				isAssigned=false;
			}
			ub.add(new UserBook(book,isAssigned));
		}
		return new ModelAndView("Student/searchbook","userbook",ub);
	}
	
	
	@PostMapping("/viewbookassigned")
	public ModelAndView assignbooks(@RequestParam("assign") String b[]) {
		Object user=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u=(CustomUserDeatails)user;
		List<Long> ids=new ArrayList<>();
		for(String id:b)
		{
			System.out.println(id);
			ids.add(Long.parseLong(id));
		}
		List<Book> book=new ArrayList<>();
		Book b1;
		for(Long id:ids)
		{
			b1 =bs.bookbyid(id);
			if(book.isEmpty())
			{
				book.add(b1);
			}
			else
			{
				book=u.getBook();
				//book.add(b1);
			}
			
		}
		u.setBook(book);
		return new ModelAndView("redirect:/student/viewbook");
		
	}
	
	@GetMapping("/viewbook")
	public ModelAndView viewbook() {
		Object user=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u=(CustomUserDeatails)user;
		return new ModelAndView("Student/viewbook","books",u.getBook());
	}

}
