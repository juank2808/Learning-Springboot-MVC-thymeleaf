package com.ideasbage.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	/*Trying redirect to index controller*/
	@GetMapping("/")
	public String home() {
		return "redirect:/app/index";
		/*we can use "forward to keep URL value*/
	}
}
