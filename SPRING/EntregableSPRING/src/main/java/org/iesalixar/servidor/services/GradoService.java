package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Grado;

public interface GradoService {
	
	public List<Grado> getAllGrado();
//	public Grado getGradoByID(String id);
	public Grado insertarGrado(Grado grado);
	public Grado getGradoByNombre(String nombre);



}
