package org.iesalixar.servidor.services;

import java.util.Optional;

import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements ProfesorService{

	@Autowired
	ProfesorRepository profRepo;
	
	@Override
	public Optional<Profesor> findProfesorById(Long id) {
		return profRepo.findById(id);
		
	}

}
