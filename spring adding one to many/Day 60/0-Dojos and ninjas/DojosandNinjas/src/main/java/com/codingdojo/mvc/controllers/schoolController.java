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

import com.codingdojo.mvc.models.Dojo;
import com.codingdojo.mvc.models.Ninja;
import com.codingdojo.mvc.services.SchoolSrevice;

import jakarta.validation.Valid;

@Controller
public class schoolController {
  @Autowired
	SchoolSrevice schoolSrevice;

  @RequestMapping("/dojos/new")
  public String showMain(@ModelAttribute("dojo") Dojo dojo ){

    return "index.jsp";
  }

  @PostMapping("/dojos/new")
  public String create(@Valid @ModelAttribute("dojo") Dojo dojo , BindingResult result) {
      if (result.hasErrors()) {
          return "index.jsp";
      } else {
          schoolSrevice.createDojo(dojo);
          return "redirect:/dojos/new";
      }
  }

  @RequestMapping("/dojos/{id}")
  public String showDojo(@PathVariable("id") Long id, Model model) {
    Dojo dojo =schoolSrevice.findDojo(id);
    model.addAttribute("dojo", dojo);
    // List<Ninja> ninjas = schoolSrevice.allNinja();
    // model.addAttribute("ninjas", ninjas);
    return "show.jsp";
  }

  // @GetMapping("/dojos/{dojoId}")
	// public String showDojo(@PathVariable("dojoId") long id, Model model) {
	// 	Dojo dojo = dojoNinjaServ.singleDojo(id);
	// 	model.addAttribute("dojo", dojo);
	// 	return "/DojosAndNinjas/show.jsp";
	// }





  @RequestMapping("/ninjas/new")
  public String showNinja(@ModelAttribute("ninja") Ninja ninja, Model model ){
    List<Dojo> dojos= schoolSrevice.allDojo();
    model.addAttribute("dojos", dojos);
    return "new.jsp";
  }

    @PostMapping("/ninjas/new")
  public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja , BindingResult result) {
      if (result.hasErrors()) {
          return "new.jsp";
      } else {
          schoolSrevice.createNinja(ninja);
          return "redirect:/ninjas/new";
      }
  }






}
