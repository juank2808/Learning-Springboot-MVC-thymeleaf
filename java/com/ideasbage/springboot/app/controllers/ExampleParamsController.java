package com.ideasbage.springboot.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ExampleParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	//send to the controller data 
	@GetMapping("/string")
	/*the param is not required and with default value*/
	public String param(@RequestParam(name="texto",required=false, defaultValue="some value") String texto,Model model) {
		/*send parameters via URL using the GET method*/
		model.addAttribute("respuesta","The text sent is: "+texto);
		return "params/show";
	}
	@GetMapping("/mix-params")
	public String param(@RequestParam String hello ,@RequestParam Integer number,Model model) {
		/*send more than one parameter via URL using the GET method*/
		model.addAttribute("respuesta","The text sent is: "+hello+ " and the number is: "+number);
		return "params/show";
	}
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest resquest,Model model) {
		/*send more than one parameter via URL using the GET method*/
		/*now using HTTPServletRequest to extract the values*/
		String hello = resquest.getParameter("hello");
		/*if the value is different to Integer we use try and catch*/
		Integer number=null;
		try {
			 number = Integer.parseInt(resquest.getParameter("number"));
		}catch(NumberFormatException e){
			number=0;
		}
		
		model.addAttribute("respuesta","The text sent is: "+hello+ " and the number is: "+number);
		return "params/show";
	}

}
