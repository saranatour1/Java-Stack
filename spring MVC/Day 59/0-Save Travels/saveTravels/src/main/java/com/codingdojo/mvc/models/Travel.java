package com.codingdojo.mvc.models;
// Travel table done
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

// import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
// import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="travel") 
public class Travel {
  // empty constructor 
  public Travel(){

  }
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @NotNull
  @Size(min = 5, max = 200)
  private String expense;


  public Travel(@NotNull @Size(min = 5, max = 200) String expense) {
    this.expense = expense;
  }
  @NotNull
  @Size(min = 5, max = 200)
  private String vendor;

  @NotNull
  @Min(value= 3, message="Must be at least 3")
  private Integer amount;

  @NotNull
  @Size(min = 5, max = 200)
  private String descreption;

  @Column(updatable=false)
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date createdAt;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date updatedAt;
  





//Normal Constucor with Values
  public Travel(String expense, String vendor, Integer amount, String desc){
    this.amount = amount;
    this.descreption = desc;
    this.expense = expense;
    this.vendor = vendor;
  }

  // This will not allow the createdAt column to be updated after creation


  @PrePersist
  protected void onCreate(){
      this.createdAt = new Date();
  }

  @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getExpense() {
	return expense;
}

public void setExpense(String expense) {
	this.expense = expense;
}

public String getVendor() {
	return vendor;
}

public void setVendor(String vendor) {
	this.vendor = vendor;
}

public Integer getAmount() {
	return amount;
}

public void setAmount(Integer amount) {
	this.amount = amount;
}

public String getDescreption() {
	return descreption;
}

public void setDescreption(String descreption) {
	this.descreption = descreption;
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
