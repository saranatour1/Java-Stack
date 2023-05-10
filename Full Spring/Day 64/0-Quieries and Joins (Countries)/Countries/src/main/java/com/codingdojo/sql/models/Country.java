package com.codingdojo.sql.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.persistence.FetchType;

// import javax.persistence.FetchType;


@Entity
@Table(name = "countries")
public class Country {



  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(max = 3)
  private String code;

  @Size(max = 52)
  private String name;

  @Enumerated(EnumType.STRING)
  // @Column(name="resourceType")
  private Continent continent;

  // enum()
  public enum Continent {
    ASIA,
    EUROPE,
    NORTH_AMERICA,
    AFRICA,
    OCEANIA,
    ANTARCTICA,
    SOUTH_AMERICA
  }

  @Size(max = 26)
  private String region;

  // Definition: surface_area float(10,2)
  private double surface_area;

  private short indep_year;

  private int population;

  private double lifeExpectancy;

  private double gnp;

  private double gnpOld;

  @Size(max = 45)
  private String localName;

  @Size(max = 45)
  private String governmentForm;

  @Size(max = 60)
  private String headOfState;

  private int capital;

  @Size(max = 2)
  private String code2;


  //one to many relationship between languages and Countries, on is on the countries side 
  @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
  private List<Language> languages;


  // one to many wtith the cities 

  @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
  private List<City> cities;


  public Country() {
  }

  public Country(@Size(max = 3) String code, @Size(max = 52) String name, Continent continent,
  @Size(max = 26) String region, double surface_area, short indep_year, int population, double lifeExpectancy,
  double gnp, double gnpOld, @Size(max = 45) String localName, @Size(max = 45) String governmentForm,
  @Size(max = 60) String headOfState, int capital, @Size(max = 2) String code2) {
this.code = code;
this.name = name;
this.continent = continent;
this.region = region;
this.surface_area = surface_area;
this.indep_year = indep_year;
this.population = population;
this.lifeExpectancy = lifeExpectancy;
this.gnp = gnp;
this.gnpOld = gnpOld;
this.localName = localName;
this.governmentForm = governmentForm;
this.headOfState = headOfState;
this.capital = capital;
this.code2 = code2;
}


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public String getCode() {
    return code;
  }


  public void setCode(String code) {
    this.code = code;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public Continent getContinent() {
    return continent;
  }


  public void setContinent(Continent continent) {
    this.continent = continent;
  }


  public String getRegion() {
    return region;
  }


  public void setRegion(String region) {
    this.region = region;
  }


  public double getSurface_area() {
    return surface_area;
  }


  public void setSurface_area(double surface_area) {
    this.surface_area = surface_area;
  }


  public short getIndep_year() {
    return indep_year;
  }


  public void setIndep_year(short indep_year) {
    this.indep_year = indep_year;
  }


  public int getPopulation() {
    return population;
  }


  public void setPopulation(int population) {
    this.population = population;
  }


  public double getLifeExpectancy() {
    return lifeExpectancy;
  }


  public void setLifeExpectancy(double lifeExpectancy) {
    this.lifeExpectancy = lifeExpectancy;
  }


  public double getGnp() {
    return gnp;
  }


  public void setGnp(double gnp) {
    this.gnp = gnp;
  }


  public double getGnpOld() {
    return gnpOld;
  }


  public void setGnpOld(double gnpOld) {
    this.gnpOld = gnpOld;
  }


  public String getLocalName() {
    return localName;
  }


  public void setLocalName(String localName) {
    this.localName = localName;
  }


  public String getGovernmentForm() {
    return governmentForm;
  }


  public void setGovernmentForm(String governmentForm) {
    this.governmentForm = governmentForm;
  }


  public String getHeadOfState() {
    return headOfState;
  }


  public void setHeadOfState(String headOfState) {
    this.headOfState = headOfState;
  }


  public int getCapital() {
    return capital;
  }


  public void setCapital(int capital) {
    this.capital = capital;
  }


  public String getCode2() {
    return code2;
  }


  public void setCode2(String code2) {
    this.code2 = code2;
  }


  public List<Language> getLanguages() {
    return languages;
  }


  public void setLanguages(List<Language> languages) {
    this.languages = languages;
  }


  public List<City> getCities() {
    return cities;
  }


  public void setCities(List<City> cities) {
    this.cities = cities;
  }
  



/*
  Columns:
  +---------------+------------------+
  |     Column    |      Data Type   |    
  |       id      |       int        |     
  |      name     |    char(35)      |  
  |  country_code |    char(3)       |  
  |   district    | char(20)         |  
  |  population   |   float(4,1)     | 
  |  country_id   |       int        | --> from joined tables  
  +---------------+------------------+
*/


}
