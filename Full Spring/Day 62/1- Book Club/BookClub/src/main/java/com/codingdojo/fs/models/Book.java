package com.codingdojo.fs.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;

// import org.hibernate.validator.constraints.NotEmpty;

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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

// . You'll also be implementing a one-to-many relationship between Books
// and Users. That is, users can post (create) many books, 
// but books may only have one user who posted it.

@Entity
@Table(name = "books")
public class Book {
  // adding the id, applying the rule that it is a unique id , and is auto
  // generated
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty(message = "title is required!")
  @Size(min = 3, message = "The title should be more than 3 charecters!")
  private String title;

  @NotEmpty(message = "Author is required!")
  @Size(min = 3, message = "The Author should be more than 3 charecters!")
  private String author;

  @NotEmpty(message = "Thoughts Should not be empty!")
  @Size(min = 3, message = "The Thoughts should be more than 3 charecters!")
  private String myThoughts;

  // created at and the updated at columns
  @Column(updatable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createdAt;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updatedAt;

  // we have no transient here

  //adding the one to many relationship 
  // 1 user many books 
  // 1 book 1 user 
  // while 1 users can add many books 
  // book one to many user  

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="user_id")
  private User user;

  public Book(
      @NotEmpty(message = "title is required!") @Size(min = 3, message = "The title should be more than 3 charecters!") String title,
      @NotEmpty(message = "Author is required!") @Size(min = 3, message = "The Author should be more than 3 charecters!") String author,
      @NotEmpty(message = "Thoughts Should not be empty!") @Size(min = 3, message = "The Thoughts should be more than 3 charecters!") String myThoughts) {
    this.title = title;
    this.author = author;
    this.myThoughts = myThoughts;
  }

  public Book() {
  }

  //not sure
  public Book(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  public String getTitle() {
    return title;
  }
  

  

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setMyThoughts(String myThoughts) {
    this.myThoughts = myThoughts;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Long getId() {
    return id;
  }

  public String getAuthor() {
    return author;
  }

  public String getMyThoughts() {
    return myThoughts;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }



}
