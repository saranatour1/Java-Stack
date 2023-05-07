package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.mvc.models.Category;
import com.codingdojo.mvc.models.Product;
import com.codingdojo.mvc.services.CatServices;

@RestController
public class RestApi {
  
  private final CatServices catServices;
  public RestApi(CatServices catServices){
      this.catServices = catServices;
  }

@RequestMapping("/test/cat/{id}")
public Category getCategory(@PathVariable("id" ) long id){
  System.out.println("HI");
return catServices.findCategory(id); 
}



}
