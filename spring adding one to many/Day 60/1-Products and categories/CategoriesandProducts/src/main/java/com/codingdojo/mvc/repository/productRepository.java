package com.codingdojo.mvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Category;
import com.codingdojo.mvc.models.Product;

@Repository
public interface productRepository extends CrudRepository<Product, Long> {
  
  List<Product> findAll();

  List<Product> findAllByCategories(Category category);
    
  // Retrieves a list of any categories a particular product
  // does not belong to.
  List<Product> findByCategoriesNotContains(Category category);

}
