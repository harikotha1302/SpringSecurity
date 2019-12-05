package com.spring.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.main.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
