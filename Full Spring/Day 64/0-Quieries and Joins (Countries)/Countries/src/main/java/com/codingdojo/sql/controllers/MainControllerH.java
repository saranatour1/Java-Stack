package com.codingdojo.sql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.sql.models.City;
import com.codingdojo.sql.models.Country;
import com.codingdojo.sql.models.Language;
import com.codingdojo.sql.services.CountriesService;

@RestController
public class MainControllerH {
  @Autowired
  private CountriesService serv;

  // for testing purpusos it is more than one
  @RequestMapping("/")
  public List<Country> showAll() {
    return serv.findAllCountries();
  }

  /*
   * Task 1 : find all counties speaking slovene
   */
  @RequestMapping("/task1")
  public List<Object[]> firstTask() {
    return serv.findCountriesSpeakingSlovene();
  }

  /*
   * Task 2 : find number of cities per country
   */

  @RequestMapping("/task2")
  public List<Object[]> secondTask() {
    return serv.findNumberOfCitiesPerCountry();
  }

  /*
   * Task 3 : population of cities in mixico
   */

  @RequestMapping("/task3")
  public List<Object[]> thirdTask() {
    return serv.findPopulationInMexico();
  }

  /*
   * Task 4 : all languages by countries
   * 
   */

  @RequestMapping("/task4")
  public List<Object[]> fourthTask() {
    return serv.findLanguages();
  }

  @RequestMapping("/task5")
  public List<Object[]> fifthTask() {
    return serv.findCountriesBySurfaceArea();
  }

  @RequestMapping("/task6")
  public List<Object[]> sixthTask() {
    return serv.findCountriesByGovermentForm();
  }

  @RequestMapping("/task7")
  public List<Object[]> seventhTask() {
    return serv.findCitiesInArgantina();
  }
  
  @RequestMapping("/task8")
  public List<Object[]> eighthTask() {
    return serv.numberRegion();
  }






}
