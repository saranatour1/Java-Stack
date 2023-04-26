package com.codingdojo.Daikichi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/daikichi")
public class Daikichil {

    @RequestMapping("") 
    public String index(){
      return "Welcome!";
    }

    @RequestMapping("/Today") 
    public String index1(){
      return "'Today you will find luck in all your endeavors!";
    }

    @RequestMapping("/Tommorow") 
    public String index2(){
      return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }

}
