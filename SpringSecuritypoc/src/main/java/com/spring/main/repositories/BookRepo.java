package com.spring.main.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.main.model.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {

	List<Book> findBySubject(String subject);


}
