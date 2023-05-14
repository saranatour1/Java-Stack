package com.codingdojo.fs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingdojo.fs.models.Project;

// import com.codingdojo.fs.models.User;
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

  List<Project> findAll();

  /*
   * Task 1 :
   * if the user is not part of the project, return all the projects
   * what I need , Project name, project owner, projecct due date.
   * SELECT
   * projects.title,
   * projects.descreption,
   * projects.due_date,
   * users.first_name ,
   * users.last_name
   * FROM projects
   * INNER JOIN users ON projects.leader_id = users.id
   * WHERE projects.joinee_id = 2;
   * *
   */

  @Query(value = "SELECT  projects.id, projects.title, users.first_name , projects.due_date , projects.leader_id FROM projects "
      +
      "INNER JOIN users ON projects.leader_id = users.id  " +
      "WHERE projects.joinee_id = :id ", nativeQuery = true)
  List<Object[]> findAllProjectsForUser(@Param("id") Long id);

  /*
   * Task 2 : Get all the projects the user is not a part of
   * SELECT
   * projects.id,
   * projects.title,
   * projects.due_date,
   * projects.leader_id,
   * projects.joinee_id
   * FROM projects
   * WHERE projects.id NOT IN (
   * SELECT projects.id
   * FROM projects
   * WHERE joinee_id = 2
   * );
   */

}
