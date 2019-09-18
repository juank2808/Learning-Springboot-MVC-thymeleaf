package com.ideasbage.springboot.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ideasbage.springboot.app.models.Usuario;

@Controller
public class IndexController {
	//inject values using @Value annotation
	@Value("${application.index.mensaje}")
	private String mensaje;
	@Value("${application.perfil.mensaje}")
	private String perfil;
	@Value("${application.listar.mensaje}")
	private String lista;
	
	@GetMapping("/")/*this is the index  / */
	public String hola(Model model) {
		model.addAttribute("mensaje",mensaje);
		return "hola";/*view name */
	}
	/**In this method i use model in this case usuario **/
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario=new Usuario();
		usuario.setNombre("Eustakio");/*in the future this instance could come from a database query*/
		usuario.setApellido("Rodriguez");
		usuario.setEmail("example@example.com");
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo",perfil);
		/*return the view name*/
		return "perfil";
	}
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		/* OP 1
		 
		List<Usuario> usuarios=new ArrayList<>(); 
		usuarios.add(new Usuario("Eustakio","Rodriguez","example@example.com"));
		usuarios.add(new Usuario("lorenzo","perez","example@example.com"));
		usuarios.add(new Usuario("jordano","jimenez","example@example.com"));
		*/
		/* OP 2*/
		List<Usuario> usuarios= Arrays.asList(new Usuario("Eustakio","Rodriguez","example@example.com"),
				new Usuario("lorenzo","perez","example@example.com"),
				new Usuario("jordano","jimenez","example@example.com"),
				new Usuario("Jacinto","Tocasuche","example@example.com"));
		model.addAttribute("usuarios",usuarios);
		model.addAttribute("titulo",lista);
		/*return the view name*/
		return "listar";
	}
	/*new way to display data in the view with ModelAttribute annotation*/
	@ModelAttribute("usuarios")
	/*we can use this to fill in forms of all kinds, selects inputs ...*/
	/* or we can use too when we wanna  display the same data in several views*/
	public List<Usuario> showUsuarios(){
		List<Usuario> usuarios= Arrays.asList(new Usuario("Eustakio","Rodriguez","example@example.com"),
				new Usuario("lorenzo","perez","example@example.com"),
				new Usuario("jordano","jimenez","example@example.com"),
				new Usuario("Jacinto","Tocasuche","example@example.com"));
		return usuarios;
	}
}
