package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.model.Profesor;

public interface ProfesorService {

	public List<Profesor> getAllProfesores();
	public Profesor findProfesorById(Long id);
	public Profesor insertarProfesor(Profesor profesor);
	public Profesor getProfesorByNombre(String nombre);
	
}
