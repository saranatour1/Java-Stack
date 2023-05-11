package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Travel;
import com.codingdojo.mvc.reposetories.TravelRepository;

@Service
public class TravelService {

  private final TravelRepository travelRepository;

  public TravelService(TravelRepository travelRepository) {
    this.travelRepository = travelRepository;
  }

  // get all travel items
  public List<Travel> allTravels() {
    return travelRepository.findAll();
  }

  // Create a new travel instance
  public Travel createTravel(Travel b) {
    return travelRepository.save(b);
  }

  public Travel findTravel(Long id) {
    Optional<Travel> optionalTravel = travelRepository.findById(id);
    if (optionalTravel.isPresent()) {
      return optionalTravel.get();
    } else {
      return null;
    }
  }

  public void updateTravel(Travel travel) {
    travelRepository.save(travel);
  }

  // delete

  public void deleteTravel(Long id) {
    travelRepository.deleteById(id);
    // bookRepository.
  }

}
