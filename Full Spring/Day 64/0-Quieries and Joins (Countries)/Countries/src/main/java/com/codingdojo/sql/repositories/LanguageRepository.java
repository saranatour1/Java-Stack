package com.codingdojo.sql.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.sql.models.Language;

public interface LanguageRepository  extends CrudRepository<Language, Long> {
  //the normal 'magical method'
  List<Language> findAll();
}

