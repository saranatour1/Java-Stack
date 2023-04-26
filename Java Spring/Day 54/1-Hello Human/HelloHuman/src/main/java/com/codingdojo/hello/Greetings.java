package com.codingdojo.hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
public class Greetings {
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String name ,@RequestParam(value="last_name", required=false) String last_name ) {
		if(name == null && last_name ==null){
			return "Hello Human";
		}else{
			return "Hello" +" "+ name +" "+ last_name;
		}

}
@RequestMapping("/l")
public String second(@RequestParam(value = "name", required = false ) String name, @RequestParam(value = "times", required = false) int times){	
	String str = "";
	String newline = System.lineSeparator();
	for(int i =0 ; i< times; i++){
		str += "hello" + " " + name + "<br>";
	}
	return str ;
	}



	
}
