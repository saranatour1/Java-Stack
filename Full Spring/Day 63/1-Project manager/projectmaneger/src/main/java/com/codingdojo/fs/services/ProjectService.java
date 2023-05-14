package com.codingdojo.fs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.fs.models.Project;
import com.codingdojo.fs.repositories.ProjectRepository;

@Service
public class ProjectService {
  @Autowired
  private ProjectRepository projectRepo;

  public Project findProjectById(Long id) {
    return projectRepo.findById(id).get();
  }

  public Project addProject(Project b) {
    return projectRepo.save(b);
  }

  // edit a project
  public void updateProject(Project b) {
    projectRepo.save(b);
  }

  // to delete a project
  public void deleteProject(Long id) {
    projectRepo.deleteById(id);
  }

  public List<Project> findAllProjects() {
    return projectRepo.findAll();
  }

  public List<Object[]> findAllProjectsForUser1(Long id) {
    return projectRepo.findAllProjectsForUser(id);
  }

  public List<Object[]> findallNotInUser(Long id){
    return projectRepo.findAllProjectsNotinUser(id);
  }
}
