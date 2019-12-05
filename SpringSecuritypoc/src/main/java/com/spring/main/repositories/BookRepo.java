package com.spring.main.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.main.model.Book;
import com.spring.main.model.User;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {

	List<Book> findBySubject(String subject);

	List<Book> findByUser(User u);

	Optional<Book> findByBookid(Long id);


}
