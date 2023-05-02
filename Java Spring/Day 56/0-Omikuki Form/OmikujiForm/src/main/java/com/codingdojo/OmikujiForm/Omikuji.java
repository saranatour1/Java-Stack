package com.codingdojo.OmikujiForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/omikuji")
public class Omikuji {
  @RequestMapping("/omikuji")
  public String showForm() {
    return "index.jsp";
  }

  //	Handle the form 
  //	handleform

  @RequestMapping(value = "/omikuji/handleform", method = RequestMethod.POST)
  public String handleForm(@RequestParam(value = "num") int num,
    @RequestParam(value = "city") String city,
    @RequestParam(value = "person_name") String personName,
    @RequestParam(value = "hobby") String hobby,
    @RequestParam(value = "living_thing") String livingThing,
    @RequestParam(value = "say_something") String saySomething ,
    HttpSession session
  ) {
		session.setAttribute("num", num);
		session.setAttribute("city", city);
		session.setAttribute("person_name", personName);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living_thing", livingThing);
		session.setAttribute("say_something", saySomething );
		// System.out.println(saySomething);
		// System.out.println(num);
		// System.out.println(personName);
    return "redirect:/omikuji/show";
  }

  @RequestMapping("/omikuji/show")
	public String showResult() {
// there is no need to send anything from here since it is a session
	
			return "result.jsp";
	}
	
}