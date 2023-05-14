package com.codingdojo.fs.controllers;

// import java.text.ParseException;
// import java.text.SimpleDateFormat;
import java.util.ArrayList;
// import java.util.Date;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.xml.utils.ObjectStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.fs.models.LoginUser;
import com.codingdojo.fs.models.Project;
import com.codingdojo.fs.models.User;
import com.codingdojo.fs.services.ProjectService;
import com.codingdojo.fs.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

  // Add once service is implemented:
  @Autowired
  private UserService userServ;

  @Autowired
  private ProjectService projectServ;

  // the main page, rendering the form with the basic things.
  // i did something wrong here most likely

  @RequestMapping("/")
  public String showForm(@ModelAttribute("newUser") User user, Model model) {
    // Bind empty User and LoginUser objects to the JSP
    // to capture the form input
    model.addAttribute("newUser", new User());
    model.addAttribute("newLogin", new LoginUser());
    return "index.jsp";
  }

  // Post operation for Regesteration handling
  @PostMapping("/register")
  public String register(@Valid @ModelAttribute("newUser") User newUser,
      BindingResult result, Model model, HttpSession session) {

    // placed the user into a variable
    User registeredUser = userServ.register(newUser, result);

    session.setAttribute("newUser", registeredUser);
    if (result.hasErrors()) {
      // this is needed at all times to capture the incorrect user values
      model.addAttribute("newLogin", new LoginUser());
      return "index.jsp";
    }

    // Store the registered user's ID in session or perform any necessary login
    // operations
    session.setAttribute("newUser", registeredUser.getId());

    return "redirect:/dashboard";
  }

  @PostMapping("/login")
  public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
      BindingResult result, Model model, HttpSession session) {

    User user = userServ.login(newLogin, result);

    if (result.hasErrors()) {
      // to capture the form inputs
      model.addAttribute("newUser", new User());
      return "index.jsp";
    }

    // Store the logged-in user's ID in session or perform any necessary login
    // operations
    session.setAttribute("newUser", user.getId());
    return "redirect:/dashboard";
  }

  // main page
  @GetMapping("/dashboard")
  public String homePage(Model model, HttpSession session) {
    Long newUserId = (Long) session.getAttribute("newUser");
    User thisUser = userServ.findUserById(newUserId);
    model.addAttribute("thisUser", thisUser);

    // all the projects regardless
    List<Project> projects = projectServ.findAllProjects();
    List<Project> allProjectUserIsNotJoinedat = new ArrayList<>();
    List<Project> allProjectsUSerISpartOf = new ArrayList<>();

    for (Project project : projects) {
      if (project.getJoinee() != thisUser) {
        allProjectUserIsNotJoinedat.add(0, project);
      } else {
        allProjectsUSerISpartOf.add(0, project);
      }

    }

    model.addAttribute("allprojects", allProjectsUSerISpartOf);
    model.addAttribute("notallprojects", allProjectUserIsNotJoinedat);

    List<Object[]> test = projectServ.findAllProjectsForUser1(newUserId);
    List<Object[]> test2 = projectServ.findallNotInUser(newUserId);
    for (Object[] item : test2) {
      for (Object value : item) {
        System.out.print(value + " ");
      }
      System.out.println();
    }
    model.addAttribute("test1", test);
    model.addAttribute("test2", test2);
    return "hello.jsp";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.removeAttribute("newUser");
    return "redirect:/";
  }

  // adding a new project

  @RequestMapping("/projects/new")
  public String showAddingProjectsPage(@ModelAttribute("project") Project project, Model model) {
    // to capture the form input
    // [2023-09-05]
    // System.out.println(project.getDueDate());
    model.addAttribute("project", new Project());
    return "addproject.jsp";
  }

  @PostMapping("/projects/new")
  public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result,
      HttpSession session) {
    if (result.hasErrors()) {
      return "addproject.jsp";
    } else {
      Long userId = (Long) session.getAttribute("newUser");
      User user = userServ.findUserById(userId);

      project.setLeader(user);
      project.setJoinee(user);
      projectServ.addProject(project);
      return "redirect:/dashboard";
    }
  }

  // editing a project

  @RequestMapping("/projects/{id}/edit")
  public String edit(@PathVariable("id") Long id, Model model) {

    // Burger burger = burgerService.findBurger(id);
    Project project = projectServ.findProjectById(id);
    model.addAttribute("project", project);
    return "edit.jsp";
  }

  // // handling the edit requet
  @RequestMapping(value = "/projects/{id}/edit", method = RequestMethod.PUT)
  public String update(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model,
      HttpSession session) {
    if (result.hasErrors()) {
      model.addAttribute("project", project);
      return "edit.jsp";
    } else {
      // I can put this in a function later on
      Long userId = (Long) session.getAttribute("newUser");
      User user = userServ.findUserById(userId);
      project.setLeader(user);
      projectServ.updateProject(project);
      return "redirect:/dashboard";
    }
  }

  // /projects/${project.id}/delete
  @RequestMapping(value = "/projects/{id}/delete", method = RequestMethod.DELETE)
  public String delete(@PathVariable("id") Long id, Model model, HttpSession session) {
    projectServ.deleteProject(id);
    return "redirect:/dashboard";
  }

  // //projects/${project.id}/leave
  @RequestMapping("/projects/{id}/leave")
  public String leave(@PathVariable("id") Long id) {
    Project project = projectServ.findProjectById(id);
    project.setJoinee(null);
    projectServ.updateProject(project);
    return "redirect:/dashboard";
  }

  /// projects/${project.id}/join
  @RequestMapping(value = "/projects/{id}/join")
  public String borrow(@PathVariable("id") Long id, HttpSession session) {
    Project project = projectServ.findProjectById(id);
    Long userId = (Long) session.getAttribute("newUser");
    User user = userServ.findUserById(userId);
    project.setJoinee(user);

    projectServ.updateProject(project);
    System.out.println("Successs!");
    return "redirect:/dashboard";
  }

  // /projects/${project.id}

  @GetMapping("/projects/{id}")
  public String showProject(@PathVariable("id") Long id, Model model) {
    Project project = projectServ.findProjectById(id);

    model.addAttribute("project", project);
    return "project.jsp";
  }

}
