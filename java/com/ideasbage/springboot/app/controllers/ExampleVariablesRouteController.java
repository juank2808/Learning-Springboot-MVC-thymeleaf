package com.ideasbage.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class ExampleVariablesRouteController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title","Send route parameters (@Pathvariable)");
		return "variables/index";
	}
	//here i use the path variable to send values like a parameter, is similar like a GET method
	@GetMapping("/string/{text}")
	public String variables(@PathVariable String text, Model model) {
		model.addAttribute("title","Receive route parameters (@Pathvariable)");
		model.addAttribute("result", "The text sent in the route is: "+text);
		
		//i redirect the result to the template show-variables
		return "variables/show-variables";
	}
	//the same but with more variables
	@GetMapping("/string/{text}/{number}")
	public String variables(@PathVariable String text,@PathVariable int number, Model model) {
		model.addAttribute("title","Receive route parameters (@Pathvariable)");
		model.addAttribute("result", "The text sent in the route is: "+text);
		model.addAttribute("result2", "The number sent in the route is: "+number);
		
		//i redirect the result to the template show-variables
		return "variables/show-variables";
	}
}
