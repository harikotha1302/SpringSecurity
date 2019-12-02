package com.spring.main.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.main.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer>{

}
