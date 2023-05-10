package com.codingdojo.sql.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.sql.models.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
  
  List<Country> findAll();
}
