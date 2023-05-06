package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Category;
import com.codingdojo.mvc.models.Product;
import com.codingdojo.mvc.services.CatServices;

import jakarta.validation.Valid;

// import ch.qos.logback.core.model.Model;
@Controller
public class HomeController {
  @Autowired
  CatServices catServices;


  @RequestMapping("/")
  public String showMain(Model model) {
    List < Product > products = catServices.allProduct();
    List < Category > categories = catServices.allCategories();
    model.addAttribute("categories", categories);
    model.addAttribute("products", products);
    return "index.jsp";
  }


  @RequestMapping("/product/new")
  private String showForm(@ModelAttribute("product") Product product) {
    return "newproduct.jsp";
  }


  @PostMapping("/product/new")
  private String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
    if (result.hasErrors()) {
      return "newproduct.jsp";
    } else {
      catServices.createProduct(product);
      return "redirect:/";
    }
  }

  @RequestMapping("/category/new")
  private String showForm1(@ModelAttribute("category") Category category) {
    return "newcat.jsp";
  }


  @PostMapping("/category/new")
  private String create1(@Valid @ModelAttribute("category") Category category, BindingResult result) {
    if (result.hasErrors()) {
      return "newcat.jsp";
    } else {
      catServices.createCategory(category);
      return "redirect:/";
    }
  }


  @RequestMapping("/category/{id}")
  private String showCat(@PathVariable("id") Long id, Model model) {
    Category cat = catServices.findCategory(id);
    model.addAttribute("cat", cat);
    List < Product > prod = catServices.allProduct();
    model.addAttribute("prod", prod);
    //here we need to return the 

    // productRepository.class.getName()
    return "showcat.jsp";
  }


  @RequestMapping(value = "/category/{id}", method = RequestMethod.POST)
  private String addproductToCategory(@PathVariable("id") Long id, Model model, @RequestParam(value = "product") Long prodId) {
    catServices.addProductToCategory(id, prodId);
    return "redirect:/";
  }

  @RequestMapping("/products/{id}")
  private String showProd(@PathVariable("id") Long id, Model model) {
    Product prod = catServices.findProduct(id);
    List < Category > categories = catServices.allCategories();
    model.addAttribute("allcats", categories);
    model.addAttribute("product", prod);
    return "showprod.jsp";
  }
  


  @RequestMapping(value = "/products/{id}", method = RequestMethod.POST)
  private String addcatToprod(@PathVariable("id") Long id, Model model, @RequestParam(value = "cat") Long catId) {
    catServices.addCategoryToProduct(id, catId);
    return "redirect:/";
  }





}