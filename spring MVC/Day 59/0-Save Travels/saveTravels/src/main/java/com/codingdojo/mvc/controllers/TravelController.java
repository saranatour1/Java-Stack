package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.mvc.models.Travel;
import com.codingdojo.mvc.services.TravelService;
// import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.validation.Valid;

@Controller
public class TravelController {

  @Autowired
  TravelService travelService;

  @RequestMapping("/")
  public String showMain(@ModelAttribute("travel") Travel travel, Model model) {
    List<Travel> travels = travelService.allTravels();
    model.addAttribute("trips", travels);
    return "index.jsp";
  }

  @PostMapping("/")
  public String create(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
    if (result.hasErrors()) {
      List<Travel> travels = travelService.allTravels();
      model.addAttribute("trips", travels);
      return "index.jsp";
    } else {
      travelService.createTravel(travel);
      return "redirect:/";
    }
  }

  @RequestMapping("/travel/{id}/edit")
  public String edit(@PathVariable("id") Long id, Model model) {
    Travel travel = travelService.findTravel(id);
    model.addAttribute("travel", travel);
    return "edit.jsp";
  }

  // handling the edit requet
  @RequestMapping(value = "/Travel/{id}", method = RequestMethod.PUT)
  public String update(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("travel", travel);
      return "edit.jsp";
    } else {
      travelService.updateTravel(travel);
      return "redirect:/";
    }
  }

  // deleteing an entitiy
  @DeleteMapping("/travel/{id}")
  public String destroy(@PathVariable("id") Long id) {
    travelService.deleteTravel(id);
    return "redirect:/";
  }

  // get a specific travel

  @GetMapping("/travel/{id}")
  public String getTravel(@PathVariable("id") Long id, Model model) {
    // travelService.deleteTravel(id);
    Travel travel = travelService.findTravel(id);
    model.addAttribute("travel", travel);
    // bookService.deleteBook(id);
    return "show.jsp";
  }

}
