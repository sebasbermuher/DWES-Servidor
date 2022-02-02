package org.iesalixar.servidor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HeaderController {

	@GetMapping("/servicios")
	public String servicios(Model model) {

		return "servicios";
	}
	
	@GetMapping("/productos")
	public String productos(Model model) {

		return "productos";
	}
	
	@GetMapping("/sobrenosotros")
	public String sobrenosotros(Model model) {

		return "sobrenosotros";
	}
}
