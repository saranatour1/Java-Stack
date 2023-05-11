package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Burger;
import com.codingdojo.mvc.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {

  @Autowired
  BurgerService burgerService;

  @RequestMapping("/")
  public String showMain(@ModelAttribute("burger") Burger burger, Model model) {
    List<Burger> burgers = burgerService.allBurgers();
    model.addAttribute("burg", burgers);
    return "index.jsp";
  }

  @PostMapping("/")
  public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
    if (result.hasErrors()) {
      return "index.jsp";
    } else {
      burgerService.createBurger(burger);
      return "redirect:/";
    }
  }

  // @PostMapping("/")
  // public String create(
  // @RequestParam("burgerName") String burgerName,
  // @RequestParam("restName") String restName,
  // @RequestParam("notes") String notes,
  // @RequestParam("rating") Integer rating)
  // {
  // // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
  // // Book book = new Book(title, description, language, pages);
  // Burger burger =new Burger(burgerName, restName, notes, rating);
  // // bookService.createBook(book);
  // burgerService.createBurger(burger);
  // return "redirect:/dashboard";
  // }

}
