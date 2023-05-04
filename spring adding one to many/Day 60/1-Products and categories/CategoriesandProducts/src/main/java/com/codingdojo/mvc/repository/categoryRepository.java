package com.codingdojo.mvc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Category;
import com.codingdojo.mvc.models.Product;
@Repository
public interface categoryRepository  extends CrudRepository<Category, Long>{
    
  List<Category> findAll();
    // Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Optional<Product> product);
}
