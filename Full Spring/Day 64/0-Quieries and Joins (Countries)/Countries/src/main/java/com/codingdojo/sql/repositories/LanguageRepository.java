package com.codingdojo.sql.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.sql.models.Language;

@Repository 
public interface LanguageRepository  extends CrudRepository<Language, Long> {
  //the normal 'magical method'
  List<Language> findAll();
}

