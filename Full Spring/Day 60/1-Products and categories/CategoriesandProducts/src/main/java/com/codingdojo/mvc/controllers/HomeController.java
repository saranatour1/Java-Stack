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

  // a main function, that shows all the products and all the categories on the
  // same page
  @RequestMapping("/")
  public String showMain(Model model) {
    List<Product> products = catServices.allProduct();
    List<Category> categories = catServices.allCategories();
    model.addAttribute("categories", categories);
    model.addAttribute("products", products);
    return "index.jsp";
  }

  // adding a new product
  @RequestMapping("/product/new")
  private String showForm(@ModelAttribute("product") Product product) {
    return "newproduct.jsp";
  }

  // hamdling adding a new product, which is indicated by 'create'
  @PostMapping("/product/new")
  private String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
    if (result.hasErrors()) {
      return "newproduct.jsp";
    } else {
      catServices.createProduct(product);
      return "redirect:/";
    }
  }

  // adding a new category
  @RequestMapping("/category/new")
  private String showForm1(@ModelAttribute("category") Category category, Model model) {
    model.addAttribute("category", category);
    return "newcat.jsp";
  }

  // handling creating a new category
  @PostMapping("/category/new")
  private String create1(@Valid @ModelAttribute("category") Category category, BindingResult result) {
    if (result.hasErrors()) {

      return "newcat.jsp";
    } else {
      catServices.createCategory(category);
      return "redirect:/";
    }
  }

  /*
   * Here we are showing the catagory of that specific id, and shoing all the
   * products related to it
   * also showing all the products that are not related to it as well.
   * 
   */

  @RequestMapping("/category/{id}")
  private String showCat(@PathVariable("id") Long id, Model model) {
    Category cat = catServices.findCategory(id);
    model.addAttribute("cat", cat);
    List<Product> prodInCat = catServices.allProductsInCat(cat);
    model.addAttribute("prod", prodInCat);
    List<Product> notInCat = catServices.allProductsNotInCategory(cat);
    model.addAttribute("notInCat", notInCat);
    return "showcat.jsp";
  }

  /*
   * handling the post request on the same path, where a product is being added to
   * the category.
   * 
   */

  @RequestMapping(value = "/category/{id}", method = RequestMethod.POST)
  private String addproductToCategory(@PathVariable("id") Long id, Model model,
      @RequestParam(value = "product") Long prodId) {
    catServices.addProductToCategory(id, prodId);
    return "redirect:/";
  }

  /*
   * same thing as before, where a category is being added to the product, shown
   * in the below function, but handled in line 125.
   * 
   */

  @RequestMapping("/products/{id}")
  private String showProd(@PathVariable("id") Long id, Model model) {

    /*
     * to display the categories in the product 
     */
    List<Object[]> items = catServices.allPr(id);
    for (Object[] item : items) {
        for (Object value : item) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


    Product prod = catServices.findProduct(id);
    List<Category> categories = catServices.allCatsInProduct(prod);

    List<Category> notInProduct = catServices.allCategoriesNotInProduct(prod);
    // this worked
    model.addAttribute("notInproduct", notInProduct);
    // System.out.println(notInProduct);
    model.addAttribute("allcats", categories);
    model.addAttribute("product", prod);
    return "showprod.jsp";
  }

  /*
   * The process of handling the addition of a catogery to a product.
   */

  @RequestMapping(value = "/products/{id}", method = RequestMethod.POST)
  private String addcatToprod(@PathVariable("id") Long id, Model model, @RequestParam(value = "cat") Long catId) {
    catServices.addCategoryToProduct(id, catId);
    return "redirect:/";
  }

}