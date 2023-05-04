package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Dojo;
import com.codingdojo.mvc.models.Ninja;
import com.codingdojo.mvc.repositories.DojoRepository;
import com.codingdojo.mvc.repositories.NinjaRepository;

@Service
public class SchoolSrevice {
  private final NinjaRepository ninjarepository;
  private final DojoRepository dojorepository;
  
  public SchoolSrevice(NinjaRepository ninjarepository, DojoRepository dojorepository) {
    this.ninjarepository = ninjarepository;
    this.dojorepository = dojorepository;
  }

  //list of all dojos
    public  List<Dojo> allDojo() {
    return dojorepository.findAll();
  }
  //list of all ninjas 
    public  List<Ninja> allNinja() {
    return ninjarepository.findAll();
  }

  //create a ninja 
  public Ninja createNinja(Ninja b) {
    return ninjarepository.save(b);
  }

  //create a ninja 
  public Dojo createDojo(Dojo b){
    return dojorepository.save(b);
  }

  //find a dojo 
  public Dojo findDojo(Long id){
    Optional<Dojo> optionalDojo =dojorepository.findById(id);
    if(optionalDojo.isPresent()){
      return optionalDojo.get();
    }
    else{
      return null;
    }
  }

  //find a ninja
  public Ninja findNinja(Long id){
    Optional<Ninja> optionalNinja =ninjarepository.findById(id);
    if(optionalNinja.isPresent()){
      return optionalNinja.get();
    }
    else{
      return null;
    }
  }



  
}

