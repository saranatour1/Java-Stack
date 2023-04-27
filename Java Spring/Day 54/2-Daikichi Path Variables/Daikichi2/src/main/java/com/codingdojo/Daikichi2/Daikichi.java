package com.codingdojo.Daikichi2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class Daikichi {

  @RequestMapping("/travel/{placeOfTravel}")
    public String travel(@PathVariable("placeOfTravel") String placeOfTravel){
    	return "Congratulations! You will soon travel to" +" "+ placeOfTravel+"!";
    }
  
  @RequestMapping("/lotto/{unknownNumber}")
  public String lotto(@PathVariable("unknownNumber") int unknownNumber){
    if(unknownNumber %2 == 0){
      return "You will take a grand journey in the near future, but be weary of tempting offers";
    }else{
      return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
    }

  }

}


