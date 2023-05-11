/*
 * Variables: 
 * total gold = total_gold 
 * forms = farm, cave ,house ,quest 
 * 
 * farm = add 10-20 
 * cave = add 5-10 
 * house = add 2-5 
 * quest = add/delete 0-50 
 */

//  importing the main package
package com.codingdojo.ninjagold;

// import java.lang.ProcessBuilder.Redirect;
// importing all the librarires used in java.util
import java.util.ArrayList;
// this was used here to reverse the array but it gave a wierd behavior of fluctuating the array, so 
// I used a method to add an element at index 0 and this seemed to work. 
// import java.util.Collections;
import java.util.Date;
import java.util.Random;

// importing spring web things
//    return random.nextInt(max - min) + min;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

// Strat of the controller / main class
@Controller
public class NinjaGame {
  // return the data here

  // setting the gold to 0 at first
  int gold = 0;
  // initializing the array list once
  ArrayList<String> activities = new ArrayList<String>(); // dictioonary/ hash map maybe ?

  // first method, showing the forms and activites
  @RequestMapping("/")
  public String mainForm(HttpSession session) {
    // this seemed neccessary to put the gold at 0 at first.
    session.setAttribute("gold", gold);
    return "index.jsp";
  }

  // Handle the form here
  // Second method, where the formType is a request parameter here
  @RequestMapping("/handleform")
  public String handleForm(@RequestParam(value = "formtype") String formType, HttpSession session) {
    // getting the random number from the Random () class
    Random rand = new Random();
    // for testing purposes
    String activity = " ";

    // set the date each time the form is ran, which is what we want
    Date now = new Date();

    // Check for the form vlue, maybe put this in an array
    if (formType.equals("farm")) {
      // add 10 to 20
      int dif = rand.nextInt(20 - 10) + 10;
      gold += dif;

      // set the activity status , repetitive
      activity = (" <p class='ms-3  text-success'> You entered a " + formType + "  you lost " + dif + " gold " + now
          + "<p>");

      // add the activity at the start of the array, to make it appear on the top
      activities.add(0, activity);

      // System.out.println("farm gold = "+ gold + activity);

    } else if (formType.equals("cave")) {
      // add 5 to 10 golds

      int dif = rand.nextInt(10 - 5) + 5;
      gold += dif;
      activity = (" <p class='ms-3  text-success'> You entered a " + formType + "  you lost " + dif + " gold " + now
          + "<p>");

      activities.add(0, activity);
      // System.out.println("cave gold = " + gold + activity);
    } else if (formType.equals("house")) {

      int dif = rand.nextInt(5 - 2) + 2;
      gold += dif;

      activity = (" <p class='ms-3  text-success'> You entered a " + formType + "  you lost " + dif + " gold " + now
          + "<p>");
      activities.add(0, activity);

      // System.out.println( "house gold =" + gold + activity);
    } else if (formType.equals("quest")) {

      // add a random value between -50 and 50
      int dif = rand.nextInt(100) - 50;
      gold += dif;
      // Check for the two possibilites
      if (dif <= 0) {
        activity = (" <p class='ms-3  text-danger'> You entered a " + formType + "  you lost " + dif + " gold " + now
            + "<p>");
        System.out.println("I am here");
      } else {
        activity = (" <p class='ms-3  text-success'> You entered a " + formType + "  you won " + dif + " gold " + now
            + "<p>");
      } // (" <p class='ms-3 mt-3 text-success'> You entered a " + formType +" you lost
        // "+ dif + " gold " + now + "<p>" )

      activities.add(0, activity);

      // System.out.println("quest gold = " + gold + activity);
    } else if (formType.equals("spa")) {

      int dif = rand.nextInt(20 - 5) - 5;
      gold -= dif;
      activity = (" <p class='ms-3  text-danger'> You entered a " + formType + "  you lost " + dif + " gold " + now
          + "<p>");
      activities.add(0, activity);
    }

    // this is setting a wierd bahvior on the activity , it is reversing it each
    // time, so it is just fluctuating, I need a stack

    // Collections.reverse(activities);
    // * NINJA BONUS: Create a fifth place "spa" where the ninja loses 5 - 20 gold
    // (10-45 minutes)

    session.setAttribute("gold", gold);
    session.setAttribute("activities", activities);

    // redriect
    return "redirect:/";
  }

  // Reset method

  @RequestMapping("/reset")
  public String reset(HttpSession session) {
    gold = 0;
    activities.clear();
    session.setAttribute("gold", gold);
    return "redirect:/";
  }

  // Do the ninja tasks
  /*
   * 
   * 
   * NINJA BONUS: Create a reset button (5-30 minutes) // done
   * 
   * NINJA BONUS: Send the ninja to a debtors' prison on a second rendered page if
   * the ninja falls too far into debt (15-60 minutes)
   */

}
