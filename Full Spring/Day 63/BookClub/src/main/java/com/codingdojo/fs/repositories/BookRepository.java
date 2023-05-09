package com.codingdojo.fs.repositories;


import java.util.List;
import org.springframework.data.repository.CrudRepository;

// import com.codingdojo.fs.models.User;
import com.codingdojo.fs.models.Book;

public interface BookRepository  extends CrudRepository<Book, Long>  {
 
  List<Book> findAll();


  
  
}
