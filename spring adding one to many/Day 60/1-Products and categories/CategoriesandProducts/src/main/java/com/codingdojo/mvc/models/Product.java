package com.codingdojo.mvc.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
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
// import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 200)
    private String prodName;

    @NotNull
    //based on the ERD it does not have any issue with size
    private String descreption;

    @NotNull
    private float price;

    //created at and the updated at columns 
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    public Product() {
    }
    public Product(@NotNull @Size(min = 3, max = 200) String prodName, @NotNull String descreption,
        @NotNull @NotBlank float price) {
      this.prodName = prodName;
      this.descreption = descreption;
      this.price = price;
    }
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "product_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    public List<Category> getCategories() {
      return categories;
    }
    
    public void setCategories(List<Category> categories) {
      this.categories = categories;
    }
    public Long getId() {
      return id;
    }
    public void setId(Long id) {
      this.id = id;
    }
    public String getProdName() {
      return prodName;
    }
    public void setProdName(String prodName) {
      this.prodName = prodName;
    }
    public String getDescreption() {
      return descreption;
    }
    public void setDescreption(String descreption) {
      this.descreption = descreption;
    }
    public float getPrice() {
      return price;
    }
    public void setPrice(float price) {
      this.price = price;
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

// @Entity
// @Table(name="products")
// public class Product {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String name;
//     private String description;
//     private float price;
//     @Column(updatable=false)
//     private Date createdAt;
//     private Date updatedAt;
//     @ManyToMany(fetch = FetchType.LAZY)
//     @JoinTable(
//         name = "categories_products", 
//         joinColumns = @JoinColumn(name = "product_id"), 
//         inverseJoinColumns = @JoinColumn(name = "category_id")
//     )
//     private List<Category> categories;
    
//     public Product() {
        
//     }
//     // ...
//     // getters and setters removed for brevity
//     // ...
// }