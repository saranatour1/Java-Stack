package com.codingdojo.mvc.repository;

import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Category;
import com.codingdojo.mvc.models.Product;
@Repository
public interface categoryRepository  extends CrudRepository<Category, Long>{
    
  List<Category> findAll();
    // Retrieves a list of all categories for a particular product
  List<Category> findAllByProducts(Product product);
    // products is the name of the table 
    // Retrieves a list of any categories a particular product
    // does not belong to.
  List<Category> findByProductsNotContains(Product product);

  /*
   * Adding Native Queries to the scene
   * SQL query:
   * SELECT cat_name
   * FROM categories
   * INNER JOIN categories_products  ON categories.id = categories_products.category_id
   * INNER JOIN products ON products.id = categories_products.product_id;
   * that's not right. 
   * where category_id = ?1 
   * ^ this returns the firs argument 
   */


   @Query(value = "SELECT cat_name FROM categories   INNER JOIN categories_products  ON categories.id = categories_products.category_id   INNER JOIN products ON products.id = categories_products.product_id where product_id = :id " ,nativeQuery = true)
   List<Object[]> findCategoriesInProduct(@Param("id")  Long id);

   /*
    * the same query displays them for the products
    * SELECT prod_name FROM categories   INNER JOIN categories_products 
    * ON categories.id = categories_products.category_id   
    * INNER JOIN products ON products.id = categories_products.product_id where category_id =6;
    */
}
// List<Category> findAllByProducts(Product product);
// List<Category> findByProductsNotContains(Product product);