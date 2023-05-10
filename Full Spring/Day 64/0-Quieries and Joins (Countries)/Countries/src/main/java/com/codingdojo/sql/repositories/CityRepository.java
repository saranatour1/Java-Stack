package com.codingdojo.sql.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.sql.models.City;
@Repository 
public interface CityRepository extends CrudRepository<City, Long> {
  
  List<City> findAll();
}


