package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("contenido", "INICIO");
		return "index";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("contenido", "ABOUT");

		return "about";
	}

	@RequestMapping("/products")
	public String products(@RequestParam(name = "product", required = false, defaultValue = "Cafe") String product,
			@RequestParam(name = "brand", required = false, defaultValue = "Saimaza") String brand,
			@RequestParam(name = "category", required = false, defaultValue = "Colombo") String category, Model model) {
		model.addAttribute("contenido", "PRODUCTOS");
		model.addAttribute("product", product);
		model.addAttribute("brand", brand);
		model.addAttribute("category", category);

		return "products";
	}

	@RequestMapping("/services")
	public String services(@RequestParam(name = "enMesa", required = false, defaultValue = "Atender en mesa") String enMesa,
			@RequestParam(name = "paraLlevar", required = false, defaultValue = "Pedir para llevar a casa") String paraLlevar, Model model) {
		model.addAttribute("contenido", "SERVICIOS");
		model.addAttribute("enMesa", enMesa);
		model.addAttribute("paraLlevar", paraLlevar);

		return "services";
	}

}
