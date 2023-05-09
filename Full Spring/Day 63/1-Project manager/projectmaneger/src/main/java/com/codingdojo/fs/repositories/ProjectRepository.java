package com.codingdojo.fs.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.fs.models.Project;

// import com.codingdojo.fs.models.User;
@Repository
public interface ProjectRepository  extends CrudRepository<Project, Long> {
  
  List<Project> findAll();


  
}
