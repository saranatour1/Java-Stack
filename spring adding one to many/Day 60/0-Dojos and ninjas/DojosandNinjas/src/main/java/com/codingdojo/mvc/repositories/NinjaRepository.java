package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.mvc.models.Ninja;
@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>  {
  
  List<Ninja> findAll();
  // List<Ninja> findAllByDojo();
}
