package com.spring.main.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.main.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer>{

	Optional<User> findByUsername(String username);

	User findByUserid(Long userid);

}
