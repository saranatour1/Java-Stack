package com.codingdojo.sql.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "cities")
public class City {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  
  @Size( max = 35)
  private String name;

  @Size(max= 3)
  private String  countryCode;

  @Size(max = 20)
  private String district;


  private int population;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="country_id")
  private Country country;


  public City(Country country) {
    this.country = country;
  }


  public City(@Size(max = 35) String name, @Size(max = 3) String countryCode, @Size(max = 20) String district,
      int population) {
    this.name = name;
    this.countryCode = countryCode;
    this.district = district;
    this.population = population;
  }


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getCountryCode() {
    return countryCode;
  }


  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }


  public String getDistrict() {
    return district;
  }


  public void setDistrict(String district) {
    this.district = district;
  }


  public int getPopulation() {
    return population;
  }


  public void setPopulation(int population) {
    this.population = population;
  }


  public Country getCountry() {
    return country;
  }


  public void setCountry(Country country) {
    this.country = country;
  }



  
}
