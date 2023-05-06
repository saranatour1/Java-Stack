package com.codingdojo.mvc.services;

import java.util.List;
// import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Category;
import com.codingdojo.mvc.models.Product;
import com.codingdojo.mvc.repository.categoryRepository;
import com.codingdojo.mvc.repository.productRepository;

@Service
public class CatServices {
  private final productRepository productrepository;
  private final categoryRepository catrepository;
  public CatServices(productRepository productrepository, categoryRepository catrepository) {
    this.productrepository = productrepository;
    this.catrepository = catrepository;
  }

  //Get all the products
  public  List<Product> allProduct() {
    return productrepository.findAll();
  }

  //get all the categories 
  public List<Category> allCategories(){
    return catrepository.findAll();
  }

  //add a new product 

    public Product createProduct(Product b){
      return productrepository.save(b);
    }

    //add a new category 
    public Category createCategory(Category b){
      return catrepository.save(b);
    }

    //find a product by id 
    public Product findProduct(Long id){
      return productrepository.findById(id).get();
    }

    public Category findCategory(Long id){
      return catrepository.findById(id).get();
    }

    public void addProductToCategory(Long catId, Long productId){
      Category thisCategory =findCategory(catId);
      Product thisProduct = findProduct(productId);      
      thisCategory.getProducts().add(thisProduct);
      catrepository.save(thisCategory);	
    }

    public void addCategoryToProduct(Long productId, Long categoryId) {
      Product product =findProduct(productId);
      Category category = findCategory(categoryId);
      product.getCategories().add(category);
      productrepository.save(product);
  }

  // list the all the categories that do not have the product in them
// so here I assume that the ID will be passed here, while the Product is passed to the category repository
  public List <Category> allCategoriesNotInProduct(Product product){
    return catrepository.findByProductsNotContains(product);
  } 

  public List <Product> allProductsNotInCategory(Category category){
    return productrepository.findByCategoriesNotContains(category);
  }

  public List <Product> allProductsInCat(Category category){
    return productrepository.findAllByCategories(category);
  }
  
  public List <Category> allCatsInProduct(Product product){
    return catrepository.findAllByProducts(product);
  }





}
