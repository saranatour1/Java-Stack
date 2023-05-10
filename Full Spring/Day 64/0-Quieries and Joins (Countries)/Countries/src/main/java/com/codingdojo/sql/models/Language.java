package com.codingdojo.sql.models;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;



@Entity
@Table(name = "languages")
public class Language {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

	private String country_code;
	private String language;
	private String is_official;
	private double percentage;
	private int country_id;

  public Language() {
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getCountry_code() {
    return country_code;
  }
  public void setCountry_code(String country_code) {
    this.country_code = country_code;
  }
  public String getLanguage() {
    return language;
  }
  public void setLanguage(String language) {
    this.language = language;
  }
  public String getIs_official() {
    return is_official;
  }
  public void setIs_official(String is_official) {
    this.is_official = is_official;
  }
  public double getPercentage() {
    return percentage;
  }
  public void setPercentage(double percentage) {
    this.percentage = percentage;
  }
  public int getCountry_id() {
    return country_id;
  }
  public void setCountry_id(int country_id) {
    this.country_id = country_id;
  }


  // country_id


  // // Many to one with the countries
  // @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name="country_id")
  // private Country country;




/*
  Columns:
  +---------------+------------------+
  |     Column    |      Data Type   |  
  +---------------+------------------+
  |       id      |       int        |  
  | country_code  |    char(3)       |  
  |   language    |    char(30)      |  
  | is_official   | enum('T','F')    |  
  |  percentage   |   float(4,1)     |  
  |  country_id   |       int        | --> from joined  table  
  +---------------+------------------+
*/


}
