package com.bolsadeideas.springboot.app.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"/index", "/", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "hola Spring con Model");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario= new Usuario();
		usuario.setNombre("Nancy");
		usuario.setApellido("Alvarez");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "El nombre del usuario es: ".concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		
		model.addAttribute("titulo", "Listado de usuarios");
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		
		List<Usuario> usuarios = Arrays.asList(new Usuario("Nancy", "Alvarez", "nancymarcela"),
			     new Usuario("Abel", "Alvarez", "abelcorreo"), new Usuario("Ana", "Perez", "anacorreo"));
		
	
		return usuarios;
	}
	
	
	

}
