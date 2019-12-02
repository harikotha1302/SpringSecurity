package com.spring.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookid")
	private long bookid;
	
	@Column(name="bookname")
	private String bookname;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="copies")
	private long copies;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_book", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "bookid"))
	private List<User> user;
	
	public Book() {
		super();
	}



	public Book(long bookid, String bookname, String subject, long copies,List<User> user) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.subject = subject;
		this.copies = copies;
		this.user=user;
	}



	public long getBookid() {
		return bookid;
	}



	public void setBookid(long bookid) {
		this.bookid = bookid;
	}



	public String getBookname() {
		return bookname;
	}



	public void setBookname(String bookname) {
		this.bookname = bookname;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public long getCopies() {
		return copies;
	}



	public void setCopies(long copies) {
		this.copies = copies;
	}



	public List<User> getUser() {
		return user;
	}



	public void setUser(List<User> user) {
		this.user = user;
	}
	
	
	
}
