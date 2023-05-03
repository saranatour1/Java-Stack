package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.mvc.models.Burger;
import com.codingdojo.mvc.services.BurgerService;
// this is a testing file
@RestController
public class Burgerapi {
  
  private final BurgerService burgerService;
  public Burgerapi(BurgerService burgerService){
      this.burgerService = burgerService;
  }

  @RequestMapping("/api/burgers")
  public List<Burger> index() {
      return burgerService.allBurgers();
  }

  @RequestMapping(value="/api/burgers", method=RequestMethod.POST)
  public Burger create(@RequestParam(value="burgerName") String burgerName, @RequestParam(value="restName") String restName, @RequestParam(value="notes") String notes, @RequestParam(value="rating") Integer rating) {
      Burger burger = new Burger(burgerName, restName, notes, rating);
      return burgerService.createBurger(burger);
  }

  @RequestMapping("/api/burgers/{id}")
  public Burger show(@PathVariable("id") Long id) {
      Burger burger = burgerService.findBurger(id);
      return burger;
  }




}
