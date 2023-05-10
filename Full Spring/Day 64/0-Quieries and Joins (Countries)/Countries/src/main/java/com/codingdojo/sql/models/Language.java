package com.codingdojo.sql.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.persistence.FetchType;


@Entity
@Table(name = "languages")
public class Language {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(max = 2)
  private String countryCode;

  @Size(max = 30)
  private String language;

  @Enumerated(EnumType.STRING)
  // @Column(name="resourceType")
  private IsOfficial isOfficial;

  // enum()
  public enum IsOfficial {
    T ,
    F
  }

  private double percentage;


  // country_id


  // Many to one with the countries
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="country_id")
  private Country country;


  public Language(Country country) {
    this.country = country;
  }


  public Language(@Size(max = 2) String countryCode, @Size(max = 30) String language, IsOfficial isOfficial,
      double percentage) {
    this.countryCode = countryCode;
    this.language = language;
    this.isOfficial = isOfficial;
    this.percentage = percentage;
  }


  public Language() {
  }


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public String getCountryCode() {
    return countryCode;
  }


  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }


  public String getLanguage() {
    return language;
  }


  public void setLanguage(String language) {
    this.language = language;
  }


  public IsOfficial getIsOfficial() {
    return isOfficial;
  }


  public void setIsOfficial(IsOfficial isOfficial) {
    this.isOfficial = isOfficial;
  }


  public double getPercentage() {
    return percentage;
  }


  public void setPercentage(double percentage) {
    this.percentage = percentage;
  }


  public Country getCountry() {
    return country;
  }


  public void setCountry(Country country) {
    this.country = country;
  }

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
