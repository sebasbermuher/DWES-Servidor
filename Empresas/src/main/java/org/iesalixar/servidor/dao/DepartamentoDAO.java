package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.utils.dao.GenericDAO;

public interface DepartamentoDAO extends GenericDAO<Departamento> {
	
	public List<Departamento> searchByName(final String name);
}
