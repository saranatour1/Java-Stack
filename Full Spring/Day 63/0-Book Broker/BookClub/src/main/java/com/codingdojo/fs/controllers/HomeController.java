package com.codingdojo.fs.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.fs.models.Book;
import com.codingdojo.fs.models.LoginUser;
import com.codingdojo.fs.models.User;
import com.codingdojo.fs.repositories.BookRepository;
import com.codingdojo.fs.services.UserService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

  // Add once service is implemented:
  @Autowired
  private UserService userServ;

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

    return "redirect:/books";
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
    return "redirect:/books";
  }

  @GetMapping("/books")
  public String homePage(Model model, HttpSession session) {
    Long newUserId = (Long) session.getAttribute("newUser");
    User thisUser = userServ.findUserById(newUserId);
    model.addAttribute("thisUser", thisUser);

    // adding all books that the user didn't borrow
    List<Book> books = userServ.findallBooks();

    model.addAttribute("allbooks", books);
    return "hello.jsp";
  }

  @RequestMapping("/booksmarket")
  public String market(Model model, HttpSession session) {
    Long newUserId = (Long) session.getAttribute("newUser");
    User thisUser = userServ.findUserById(newUserId);
    model.addAttribute("thisUser", thisUser);

    // adding all books that the user didn't borrow

    
    List<Book> books = userServ.findallBooks();
    List<Book> borrowedBooks = new ArrayList<>();
    List<Book> notborrowedBooks = new ArrayList<>();
    for (Book book : books) {
      if (book.getUser_that_borrowed() == thisUser) {
        borrowedBooks.add(0, book);
      } else if (book.getUser_that_borrowed() == null || book.getUser() == thisUser) {
        notborrowedBooks.add(0, book);
      }
    }
    // for(int i= 0; i<books )

    model.addAttribute("allbooks", notborrowedBooks);
    model.addAttribute("borrowedBooks", borrowedBooks);
    return "market.jsp";
  }

  @RequestMapping("/books/{id}/return")
  public String returnBook(@PathVariable("id") Long id) {
    Book book = userServ.findBook(id);

    book.setUser_that_borrowed(null);
    userServ.updateBook(book);
    return "redirect:/books";
  }

  // adding a new book
  // rendering the page
  @RequestMapping("/books/new")
  public String showAddingBookPage(@ModelAttribute("book") Book book, Model model) {
    // to capture the form input
    model.addAttribute("book", new Book());

    return "addbook.jsp";
  }

  // post mapping method
  @PostMapping("/books/new")
  public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
    if (result.hasErrors()) {
      return "addbook.jsp";
    } else {
      Long userId = (Long) session.getAttribute("newUser");
      User user = userServ.findUserById(userId);
      book.setUser(user);
      userServ.addBook(book);
      return "redirect:/books";
    }
  }
  // edit delete maybe thursday?

  @GetMapping("/books/{id}")
  public String showBook(@PathVariable("id") Long id, Model model) {

    Book book = userServ.findBook(id);
    model.addAttribute("book", book);
    return "book.jsp";
  }

  // edit path

  @RequestMapping("/books/{id}/edit")
  public String edit(@PathVariable("id") Long id, Model model) {
    // Burger burger = burgerService.findBurger(id);
    Book book = userServ.findBook(id);
    model.addAttribute("book", book);
    return "edit.jsp";
  }

  // handling the edit requet
  @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
  public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
      HttpSession session) {
    if (result.hasErrors()) {
      model.addAttribute("book", book);
      return "edit.jsp";
    } else {
      // I can put this in a function later on
      Long userId = (Long) session.getAttribute("newUser");
      User user = userServ.findUserById(userId);
      book.setUser(user);
      userServ.updateBook(book);
      return "redirect:/books";
    }
  }

  // to delete a book
  @RequestMapping(value = "/books/{id}/delete", method = RequestMethod.DELETE)
  public String delete(@PathVariable("id") Long id, Model model, HttpSession session) {

    userServ.deleteBook(id);
    return "redirect:/books";
  }

  // /books/${book.id}/borrow
  // borrow
  @RequestMapping(value = "/books/{id}/borrow")
  public String borrow(@PathVariable("id") Long id, HttpSession session) {
    Book book = userServ.findBook(id);
    Long userId = (Long) session.getAttribute("newUser");
    User user = userServ.findUserById(userId);
    book.setUser_that_borrowed(user);

    userServ.updateBook(book);
    System.out.println("Successs!");
    return "redirect:/booksmarket";
  }

  // change /books to book market
  // get a new edit path

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.removeAttribute("newUser");
    return "redirect:/";
  }

}
