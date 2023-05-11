package com.codingdojo.datepicker;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DateController {
	// Date today=new Date();
	@RequestMapping("")
	public String chooseMethod() {
		return "index.jsp";
	}

	// date today
	@RequestMapping("/date")
	public String pickDate(Model model) {
		Date today = new Date();

		SimpleDateFormat DateFor = new SimpleDateFormat("EEEE, MMMM d , y");
		String stringDate = DateFor.format(today); // Thu, Apr 27, '23

		// System.out.println(stringDate); //Thu Apr 27 14:12:33 IDT 2023

		model.addAttribute("date", stringDate);
		return "date.jsp";
	}

	@RequestMapping("/time")
	public String pickTime(Model model) {
		Date today = new Date();
		SimpleDateFormat TimeFor = new SimpleDateFormat("h:m:s a");
		String stringTime = TimeFor.format(today); // Thu, Apr 27, '23

		// System.out.println(stringTime); //Thu Apr 27 14:12:33 IDT 2023
		model.addAttribute("time", stringTime);
		return "time.jsp";
	}

}
