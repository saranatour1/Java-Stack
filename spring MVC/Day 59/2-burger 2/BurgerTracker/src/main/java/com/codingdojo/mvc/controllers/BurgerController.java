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
// import org.springframework.web.bind.annotation.RequestParam;

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

  // editing
  // to render the editing page
  @RequestMapping("/burgers/{id}/edit")
  public String edit(@PathVariable("id") Long id, Model model) {
    Burger burger = burgerService.findBurger(id);
    model.addAttribute("burger", burger);
    return "edit.jsp";
  }

  // handling the edit requet
  @RequestMapping(value = "/burger/{id}", method = RequestMethod.PUT)
  public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("burger", burger);
      return "edit.jsp";
    } else {
      burgerService.updateBurger(burger);
      return "redirect:/";
    }
  }

}
