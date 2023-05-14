package com.codingdojo.fs.models;

// import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
// import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "projects")
public class Project {

  public Project() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty(message = "title connot be empty! ")
  @Size(min = 3, message = "Title must be atleast 3 charecters! ")
  private String title;

  @NotEmpty(message = "descreption connot be empty! ")
  @Size(min = 3, message = "descreption  must be atleast 3 charecters! ")
  private String descreption;

  // @NotEmpty(message = "date connot be empty! ")
  // must check this
  // supported :D;D
  // @NotNull(message = "date cannot be empty!")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Future(message = "date must be in the future!")
  private Date dueDate;

  @Column(updatable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createdAt;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updatedAt;

  public Project(
      @NotEmpty(message = "title connot be empty! ") @Size(min = 3, message = "Title must be atleast 3 charecters! ") String title,
      @NotEmpty(message = "descreption connot be empty! ") @Size(min = 3, message = "descreption  must be atleast 3 charecters! ") String descreption,
      @NotEmpty(message = "date connot be empty! ") @Future Date dueDate) {
    this.title = title;
    this.descreption = descreption;
    this.dueDate = dueDate;
  }

  // ze relation // user can have many projects , // one user can be assosiated
  // with one 1 project

  // leader_id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "leader_id")
  private User leader;

  // joineees
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "joinee_id")
  private User joinee;

  public User getJoinee() {
    return joinee;
  }

  public void setJoinee(User joinee) {
    this.joinee = joinee;
  }

  public Project(User leader) {
    this.leader = leader;
  }

  public User getLeader() {
    return leader;
  }

  public void setLeader(User leader) {
    this.leader = leader;
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescreption() {
    return descreption;
  }

  public void setDescreption(String descreption) {
    this.descreption = descreption;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
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

  // private LocalDate dateOfBirth;

  // public Optional<@Past LocalDate> getDateOfBirth() {
  // return Optional.of(dateOfBirth);
  // }
}
