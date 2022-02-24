package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.DepartamentoDTO;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.DepartamentoServiceImpl;
import org.iesalixar.servidor.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DepartamentoController {

	@Autowired
	DepartamentoServiceImpl departamentoService;

	@Autowired
	ProfesorServiceImpl profesorService;

	@RequestMapping("/departments")
	public String departaments(Model model) {

		List<Departamento> departamentos = departamentoService.getAllDepartments();

		model.addAttribute("contenido", "PRODUCTOS");
		model.addAttribute("departamentos", departamentos);
		return "departments";
	}

	@GetMapping("/departments/add")
	public String addDepartmentGet(@RequestParam(required = false, name = "error") String error,
			@RequestParam(required = false, name = "dpto") String nombre, Model model) {

		DepartamentoDTO dpto = new DepartamentoDTO();

		model.addAttribute("dpto", dpto);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "addDepartment";
	}

	@PostMapping("/departments/add")
	public String addDepartmentPost(@ModelAttribute DepartamentoDTO dpto, Model model) {

		Departamento dptoBD = new Departamento();
		dptoBD.setNombre(dpto.getNombre());

		if (departamentoService.insertarDepartamento(dptoBD) == null) {
			return "redirect:/departments/add?error=Existe&dpto=" + dpto.getNombre();
		}

		return "redirect:/departments";
	}

	@GetMapping("/departments/profesores")
	public String profesoresDepartamentos(@RequestParam(required = false, name = "codigo") String codigo, Model model) {

		if (codigo == null) {

			return "redirect:/departments";
		}

		Departamento dptoEntity = departamentoService.getDepartamentByName(codigo);

		model.addAttribute("departamentos", dptoEntity);

		return "profesorDepartamentos";
	}

}
