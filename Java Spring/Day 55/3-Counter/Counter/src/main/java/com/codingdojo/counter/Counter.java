package com.codingdojo.counter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/sara_server")
public class Counter {
    @RequestMapping("")
    public String chooseMethod(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }
        session.setAttribute("count", count+=1);
        return "index.jsp";
    }
    
    @RequestMapping("/counter")
    public String displayCounter(Model model) {
        return "Counter.jsp";
    }
//    Button function 
//    public void resetButton(HttpSession session) {
//    	session.invalidate(); //to reset the session
//    }
    
}
