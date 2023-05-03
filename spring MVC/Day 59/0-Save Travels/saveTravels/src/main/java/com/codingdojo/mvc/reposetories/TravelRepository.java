package com.codingdojo.mvc.reposetories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Travel;

@Repository
public interface TravelRepository extends CrudRepository<Travel,Long> {
  
  List<Travel> findAll();

  // List<Travel> findByDescContaining(String search);
  // Long countByVendorContaining(String search);
  // Long deleteByExpenseStartingWith(String search);

  Optional<Travel> findById(Long id);
  
}


