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
      // Optional<Product> optionalproduct = productrepository.findById(id);
      return productrepository.findById(id).get();
      // if(optionalproduct.isPresent()){
      //   return optionalproduct.get();
      // } else{
      //   return null;
      // }
    }

    public Category findCategory(Long id){
      // Optional<Category> cat = catrepository.findById(id);
      return catrepository.findById(id).get();
      // if(opOptionalCategory.isPresent()){
      //   return opOptionalCategory.get();
      // }else{
      //   return null;
      // }
    }

    //add product to category

    // public void add(Long catId , Long productId){
    //   Category thisCategory =findCategory(catId);
    //   Product thisProduct = findProduct(productId);   
    //   thisCategory.getProducts().add(thisProduct);
    //   catrepository.save(thisCategory);	
    // }


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
  


        // add the product to this category's list of products
       
        
        // Save thisCategory, since you made changes to its product list.





}
