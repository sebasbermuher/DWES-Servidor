package org.iesalixar.servidor.controller;

import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("usuario", new UserDTO());
		return "home";
	}

	@PostMapping("/")
	public String doLogin(@ModelAttribute UserDTO usuario, Model model, HttpSession session) {

		if (usuario.getUsuario().equals("usuario") && usuario.getPassword().equals("usuario")) {
			session.setAttribute("role", "usuario");
			return "redirect:/home/usuario";
		}

		else if (usuario.getUsuario().equals("admin") && usuario.getPassword().equals("admin")) {
			session.setAttribute("role", "admin");
			return "redirect:/home/admin";
		}

		return "redirect:/";
	}

	 @GetMapping("/home/usuario")
	    public String homeUsuario(HttpSession session) {
	        
	        if (session.isNew() || !session.getAttribute("role").equals("usuario")) {
	            session.invalidate();
	            
	            return "redirect:/";
	        }
	        
	        return "usuario";
	    }
	    
	    @GetMapping("/home/admin")
	    public String homeAdmin(HttpSession session) {
	        
	        if (session.isNew() || !session.getAttribute("role").equals("admin")) {
	            session.invalidate();
	            
	            return "redirect:/";
	        }
	        
	        return "admin";
	    }

}
