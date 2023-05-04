package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.hibernate.mapping.List;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
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


  //rendering all the categories and products
  /**
   * @param model
   * @return
   */
  @RequestMapping("/")
  public String showMain(Model model ){
    List <Product> products = catServices.allProduct();

    List <Category> categories =catServices.allCategories();
    
    model.addAttribute("categories", categories);
    model.addAttribute("products", products);


    return "index.jsp";
  }

  //adding a new product 
  //rendering 

    /**
     * @param product
     * @return
     */
    @RequestMapping("/product/new")
    public String showForm(@ModelAttribute("product") Product product){
      return "newproduct.jsp";
    }

  //handling the action of adding a new procuct
  /**
   * @param product
   * @param result
   * @return
   */
  @PostMapping("/product/new")
  public String create(@Valid @ModelAttribute("product") Product product , BindingResult result) {
      if (result.hasErrors()) {
          return "newproduct.jsp";
      } else {
        catServices.createProduct(product);
          return "redirect:/";
      }
  }

  // /category/new


    /**
     * @param category
     * @return
     */
    @RequestMapping("/category/new")
    public String showForm1(@ModelAttribute("category") Category category){
      return "newcat.jsp";
    }

  //handling the action of adding a new procuct
  /**
   * @param category
   * @param result
   * @return
   */
  @PostMapping("/category/new")
  public String create1(@Valid @ModelAttribute("category") Category category , BindingResult result) {
      if (result.hasErrors()) {
          return "newcat.jsp";
      } else {
        catServices.createCategory(category);
          return "redirect:/";
      }
  }

  // Show Category page
  // /category/${category.id}

  // add product to category 
//I probably need a form here, but is it assigned to the third table as a modelattribute?
  // Show all Catogegories and add poducct to category 
/**
 * @param id
 * @param model
 * @return
 */
@RequestMapping("/category/{id}")
  public String showCat(@PathVariable("id") Long id, Model model) {
    Category cat = catServices.findCategory(id);
    model.addAttribute("cat", cat);
    List<Product> prod = catServices.allProduct();
    model.addAttribute("prod", prod);
    return "showcat.jsp";
  }

  // @ModelAttribute("categoryProductObj") CategoryProduct categoryProduct

  //add category to procuct 
    /**
     * @param id
     * @param model
     * @param prodId
     * @return
     */
    @RequestMapping(value="/category/{id}", method = RequestMethod.POST)
    public String addproductToCategory(@PathVariable("id") Long id, Model model, @RequestParam(value = "product") Long prodId) {
      catServices.addProductToCategory(id, prodId);
      return "redirect:/";
    }

  //show all Products and add category to priduct
// /products/${product.id}
    /**
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/products/{id}")

    public String showProd(@PathVariable("id") Long id, Model model) {
      Product prod =catServices.findProduct(id);
      List<Category> categories =catServices.allCategories();

      model.addAttribute("allcats", categories);
      model.addAttribute("product", prod);

      return "showprod.jsp";
    }

    /**
     * @param id
     * @param model
     * @param catId
     * @return
     */
    @RequestMapping(value="/products/{id}", method = RequestMethod.POST)
    public String addcatToprod(@PathVariable("id") Long id, Model model, @RequestParam(value = "cat") Long catId) {
      catServices.addCategoryToProduct(id,catId);
      return "redirect:/";
    }





}
