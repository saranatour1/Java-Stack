package com.codingdojo.fs.models;

import java.util.Date;
// import java.util.List;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

//Define that an entity will be saved to the database, and define the table name, here it is called users

@Entity
@Table(name = "users")
public class User {
  // define all the variables with their corrosponding validations , from id, name
  // email password

  // adding the id, applying the rule that it is a unique id , and is auto
  // generated
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // First name
  @NotEmpty(message = "first name is required!")
  @Size(min = 3, max = 30, message = "first name must be between 3 and 30 characters")
  private String firstName;

  // Last name
  @NotEmpty(message = "last name is required!")
  @Size(min = 3, max = 30, message = "last name must be between 3 and 30 characters")
  private String lastName;

  @NotEmpty(message = "Email is required!")
  @Email(message = "Please enter a valid email!")
  private String email;

  @NotEmpty(message = "Password is required!")
  @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
  private String password;

  @Transient
  @NotEmpty(message = "Confirm Password is required!")
  @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters")
  private String confirm;

  // adding the created at and updated at is crusial for me

  // created at and the updated at columns
  @Column(updatable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createdAt;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updatedAt;

  // Constructor
  public User(
      @NotEmpty(message = "first name is required!") @Size(min = 3, max = 30, message = "first name must be between 3 and 30 characters") String firstName,
      @NotEmpty(message = "last name is required!") @Size(min = 3, max = 30, message = "last name must be between 3 and 30 characters") String lastName,
      @NotEmpty(message = "Email is required!") @Email(message = "Please enter a valid email!") String email,
      @NotEmpty(message = "Password is required!") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters") String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  }

  @OneToMany(mappedBy="leader", fetch = FetchType.LAZY)
  private List<Project> projects;

  // joinee or peple that join the team
  // @OneToMany(mappedBy = "joinee", fetch = FetchType.LAZY)
  // private List<Project> projectsShared;

  @JsonIgnore
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "memebers_projects", 
      joinColumns = @JoinColumn(name = "joinee_id"), 
      inverseJoinColumns = @JoinColumn(name = "project_id")
  )
  private List<Project> ProjectsIamPartOf;
  

  // public User(List<Project> projectsShared) {
  //   this.projectsShared = projectsShared;
  // }

  // public List<Project> getProjectsShared() {
  //   return projectsShared;
  // }

  // public void setProjectsShared(List<Project> projectsShared) {
  //   this.projectsShared = projectsShared;
  // }

  public List<Project> getProjectsIamPartOf() {
    return ProjectsIamPartOf;
  }

  public void setProjectsIamPartOf(List<Project> projectsIamPartOf) {
    ProjectsIamPartOf = projectsIamPartOf;
  }

  public User(List<Project> projects) {
    this.projects = projects;
  }

  // public User(List<Project> projects) {
  //   this.projects = projects;
  // }

  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }

  // empty constructor
  public User() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirm() {
    return confirm;
  }

  public void setConfirm(String confirm) {
    this.confirm = confirm;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

}
