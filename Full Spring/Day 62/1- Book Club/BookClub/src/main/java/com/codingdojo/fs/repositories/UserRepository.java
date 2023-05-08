package com.codingdojo.fs.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.fs.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
  //find by email 
    Optional<User> findByEmail(String email);
    
}