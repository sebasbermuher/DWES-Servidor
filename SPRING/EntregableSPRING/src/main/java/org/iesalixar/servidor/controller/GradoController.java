package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.GradoDTO;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.GradoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradoController {

	@Autowired
	GradoServiceImpl gradoService;

	@Autowired
	AsignaturaServiceImpl asignaturaService;

	@RequestMapping("/grado")
	public String grado(Model model) {

		List<Grado> grado = gradoService.getAllGrado();

		model.addAttribute("contenido", "grados");
		model.addAttribute("grado", grado);
		return "grado";
	}

	@GetMapping("/grado/asignaturas")
	public String asignaturasGrados(@RequestParam(required = false, name = "codigo") String codigo, Model model) {

		if (codigo == null) {

			return "redirect:/grado/";
		}

		Optional<Asignatura> asignatura = asignaturaService.findAsignaturaById(Long.parseLong(codigo));
		model.addAttribute("asignatura", asignatura.get());

		return "asignaturasGrados";
	}

	@GetMapping("/grado/addGrado")
	public String addGradoGet(@RequestParam(required = false, name = "error") String error,
			@RequestParam(required = false, name = "grado") String nombre, Model model) {

		GradoDTO gradodto = new GradoDTO();

		model.addAttribute("gradodto", gradodto);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "addGrado";
	}

	@PostMapping("/grado/addGrado")
	public String addGradoPost(@ModelAttribute GradoDTO gradoDTO, Model model) {

		Grado gradoBD = new Grado();
		gradoBD.setNombre(gradoDTO.getNombre());

		if (gradoService.insertarGrado(gradoBD) == null) {
			return "redirect:/grado/addGrado?error=Existe&grado=" + gradoDTO.getNombre();
		}

		return "redirect:/grado";
	}
}
