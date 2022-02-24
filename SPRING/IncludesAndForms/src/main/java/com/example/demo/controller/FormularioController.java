package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.Usuario;

@Controller
@RequestMapping("/forms")
public class FormularioController {

	@GetMapping("/registro")
	public String registro(Model model) {

		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);

		return "forms/registro";

	}

	@PostMapping("/registro")
	public String registroPost(@ModelAttribute Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "forms/registro";

	}

}
