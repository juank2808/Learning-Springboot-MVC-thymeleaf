package com.ideasbage.springboot.app.controllers;

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

}
