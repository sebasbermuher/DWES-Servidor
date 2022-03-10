package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	ProfesorRepository profesorRepo;
	
	@Override
	public List<Profesor> getAllProfesores() {
		// Obtengo el resultado a través del repositorio
		List<Profesor> profesorBD = profesorRepo.findAll();

		// Verificando que he obtenido algo
		if (profesorBD != null && profesorBD.size() > 0) {

			return profesorBD;
		}

		// No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
		return new ArrayList<Profesor>();
	}

	@Override
    public Profesor findProfesorById(Long id) {
        // TODO Auto-generated method stub
        return profesorRepo.findById(id).get();
    }

	@Override
	public Profesor insertarProfesor(Profesor profesor) {
		if (profesor != null && getProfesorByNombre(profesor.getNombre()) == null) {
			Profesor prof = profesorRepo.save(profesor);
			return prof;
		}

		return null;
	}

	@Override
	public Profesor getProfesorByNombre(String nombre) {
		if (nombre != null) {

			Profesor profesor = profesorRepo.findByNombre(nombre);

			return profesor;
		}
		return null;

	}
}
