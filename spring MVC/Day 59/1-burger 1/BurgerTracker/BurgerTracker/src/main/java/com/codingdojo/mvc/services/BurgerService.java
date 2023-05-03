package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Burger;
import com.codingdojo.mvc.repositories.BurgerRepository;

@Service
public class BurgerService {
  private final BurgerRepository burgerRepository;

  public BurgerService(BurgerRepository burgerRepository) {
    this.burgerRepository = burgerRepository;
  }

  public  List<Burger> allBurgers() {
    return burgerRepository.findAll();
  }

//   public List<Book> allBooks() {
//     return bookRepository.findAll();
// }

  public Burger createBurger(Burger b) {
    return burgerRepository.save(b);
  }

  public Burger findBook(Long id) {
    Optional<Burger> optionalBurger = burgerRepository.findById(id);
    if(optionalBurger.isPresent()) {
        return optionalBurger.get();
    } else {
        return null;
    }
}


}



