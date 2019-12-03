package com.spring.main.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.main.model.Role;

public interface RoleRepo extends CrudRepository<Role, Integer> {

}
