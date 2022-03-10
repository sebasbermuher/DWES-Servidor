package org.iesalixar.servidor.controller;

import java.util.List;

import org.iesalixar.servidor.dto.ProfesorDTO;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
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
public class ProfesorController {

	@Autowired
	ProfesorServiceImpl profesorService;

	@Autowired
	AsignaturaServiceImpl asignaturaService;
	
	@Autowired
	DepartamentoServiceImpl departamentoService;

	@RequestMapping("/profesores")
	public String profesor(Model model) {

		List<Profesor> profesor = profesorService.getAllProfesores();

		model.addAttribute("contenido", "profesores");
		model.addAttribute("profesor", profesor);
		return "profesor";
	}
	
	
	@GetMapping("/profesores/addAsignatura")
	public String addAsignaturas(Model model) {
		
		return "addAsignatura";
	}
	

	@GetMapping("/profesores/asignaturas")
	public String asignaturasProfesores(@RequestParam(required = false, name = "codigo") String codigo, Model model) {

		if (codigo == null) {

			return "redirect:/profesores/";
		}

		Profesor profesor = profesorService.findProfesorById(Long.parseLong(codigo));

		model.addAttribute("asignatura", profesor);

		return "asignaturasProfesores";
	}

	
	@GetMapping("/profesores/addProfesor")
	public String addProfesorGet(@RequestParam(required = false, name = "error") String error,
			@RequestParam(required = false, name = "profesor")String nombre, Model model) {

		ProfesorDTO profesordto = new ProfesorDTO();
				
		model.addAttribute("depart", departamentoService.getAllDepartments());
		model.addAttribute("profesor", profesordto);
		model.addAttribute("error", error);
		model.addAttribute("nombre", nombre);
		return "addProfesor";
	}

	@PostMapping("/profesores/addProfesor")
	public String addProfesorPost(@ModelAttribute ProfesorDTO profesorDTO, Model model) {

		Profesor profesor = new Profesor();
		profesor.setNombre(profesorDTO.getNombre());
		profesor.setApellido1(profesorDTO.getApellido1());
		profesor.setApellido2(profesorDTO.getApellido2());
		profesor.setCiudad(profesorDTO.getCiudad());
		profesor.setDireccion(profesorDTO.getDireccion());
		profesor.setFechaNacimiento(profesorDTO.getFechaNacimiento());
		profesor.setNif(profesorDTO.getNif());
		profesor.setSexo(profesorDTO.getSexo());
		Departamento departamentos = departamentoService.findDepartamentoById(profesorDTO.getDepartamento());
		profesor.setDepartamento(departamentos);
		
		if (profesorService.insertarProfesor(profesor) == null) {
			return "redirect:/profesores/addProfesor?error=Existe&Profesor=" + profesorDTO.getNombre();
		}
		return "redirect:/profesores";
	}
	
	
}
