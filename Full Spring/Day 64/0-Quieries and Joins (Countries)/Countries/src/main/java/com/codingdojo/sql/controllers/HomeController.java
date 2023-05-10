package com.codingdojo.sql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.sql.models.Country;
import com.codingdojo.sql.models.Language;
import com.codingdojo.sql.services.CountriesService;

// import ch.qos.logback.core.model.Model;

@Controller
public class HomeController {
  @Autowired
  private CountriesService serv;

  @RequestMapping("/")
  public String showAll(Model model){
    List<Object[]> task1 =serv.findCountriesSpeakingSlovene();
    List<Object[]> task2 =serv.findNumberOfCitiesPerCountry();
    List<Object[]> task3 =serv.findPopulationInMexico();
    List<Object[]> task4 =serv.findLanguages();
    List<Object[]> task5 =serv.findCountriesBySurfaceArea();
    List<Object[]> task6 =serv.findCountriesByGovermentForm();
    List<Object[]> task7 =serv.findCitiesInArgantina();
    List<Object[]> task8 =serv.numberRegion();
    // List<Object[]> task8 =serv.numberRegion();

    


    // System.out.print(task1);
    model.addAttribute("task1", task1);
    model.addAttribute("task2", task2);
    model.addAttribute("task3", task3);
    model.addAttribute("task4", task4);
    model.addAttribute("task5", task5);
    model.addAttribute("task6", task6);
    model.addAttribute("task7", task7);
    model.addAttribute("task8", task8);

    return "index.jsp";
  }





}
