package com.codingdojo.mvc.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;

// import org.hibernate.annotations.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //name of category
    @NotNull
    @Size(min = 3, max = 200)
    private String catName;
  
    //created at and updated at 
    //created at and the updated at columns 
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    public Category(){}
    public Category(@NotNull @Size(min = 3, max = 200) String catName) {
      this.catName = catName;
    }
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    //The many to many relationship 
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", //the name of the relationship
        joinColumns = @JoinColumn(name = "category_id"), 
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;


    public List<Product> getProducts() {
      return products;
    }
    public void setProducts(List<Product> products) {
      this.products = products;
    }
    public Long getId() {
      return id;
    }
    public void setId(Long id) {
      this.id = id;
    }


    public String getCatName() {
      return catName;
    }
    public void setCatName(String catName) {
      this.catName = catName;
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
    
        

}

// // ..
// @Entity
// @Table(name="categories")
// public class Category {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String name;
//     @Column(updatable=false)
//     private Date createdAt;
//     private Date updatedAt;
//     @ManyToMany(fetch = FetchType.LAZY)
//     @JoinTable(
//         name = "categories_products", 
//         joinColumns = @JoinColumn(name = "category_id"), 
//         inverseJoinColumns = @JoinColumn(name = "product_id")
//     )
//     private List<Product> products;
    
//     public Category() {
        
//     }
    
//     // ...
//     // getters and setters removed for brevity
//     // ...
// }