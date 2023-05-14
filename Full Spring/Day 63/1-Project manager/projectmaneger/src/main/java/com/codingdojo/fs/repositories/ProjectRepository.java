package com.codingdojo.fs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingdojo.fs.models.Project;
import com.codingdojo.fs.models.User;

// import com.codingdojo.fs.models.User;
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

  List<Project> findAll();


  public List<Project> findByMembersContaining(User user);



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

   /*
    * SELECT * FROM projects p
    WHERE p.leader_id <> 2
    AND 2 NOT IN (
        SELECT joinee_id FROM memebers_projects mp
      WHERE mp.project_id = p.id
    );
    */

    @Query(value = "SELECT p.id, p.title, users.first_name, p.due_date FROM projects p "+
                    "inner join users on p.leader_id = users.id "+
                    "WHERE p.leader_id <> :id "+
                    "AND :id NOT IN ( " +
                    "SELECT joinee_id FROM memebers_projects mp "+
                    "WHERE mp.project_id = p.id)",
                nativeQuery = true)
  List<Object[]> findProjectsNotJoinedByUser(@Param("id") Long id);

   
   


  @Query(value = "SELECT projects.id, projects.title, projects.descreption, projects.due_date, users.first_name "+ 
                "FROM projects " +
                "INNER JOIN memebers_projects ON projects.id = memebers_projects.project_id " +
                "INNER JOIN users ON memebers_projects.joinee_id = users.id "+
                "WHERE memebers_projects.joinee_id = :id", nativeQuery = true)
  List<Object[]> findAllProjectsForUser(@Param("id") Long id);


  // works // is Leader + part of 
  @Query(value = "SELECT projects.id, projects.title, leader.first_name, projects.due_date ,projects.leader_id FROM projects INNER JOIN users AS leader ON projects.leader_id = leader.id LEFT JOIN memebers_projects ON projects.id = memebers_projects.project_id INNER JOIN users ON (projects.leader_id = users.id OR memebers_projects.joinee_id = users.id) WHERE users.id = :id", nativeQuery = true)
  List<Object[]> allProjectsUserIsLeader(@Param("id") Long id);

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

   @Query(value = "SELECT projects.id, projects.title ,users.first_name, Date(projects.due_date) as due_date FROM projects "+
   "join users on leader_id = users.id  "+
   "WHERE projects.id NOT IN ( "+
   "SELECT projects.id " +
   "FROM projects "+
   "WHERE joinee_id = :id) ", nativeQuery = true)
List<Object[]> findAllProjectsNotinUser(@Param("id") Long id);

}
