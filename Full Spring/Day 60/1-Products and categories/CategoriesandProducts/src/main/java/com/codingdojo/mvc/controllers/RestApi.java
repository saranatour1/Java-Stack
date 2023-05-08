package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public ResponseEntity<Category> getCategory(@PathVariable("id" ) long id){

  Category cat =catServices.findCategory(id);
  System.out.println(cat.getCatName());
  // JSONObject obj = (JSONObject);
  return ResponseEntity.ok(cat);

//   HttpHeaders headers = new HttpHeaders();
         
//   ResponseEntity<Category> entity = new ResponseEntity<Category>(cat, headers,HttpStatus.CREATED);

// return entity; 
}



}
