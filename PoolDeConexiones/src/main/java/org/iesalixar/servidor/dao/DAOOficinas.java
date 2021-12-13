package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Offices;

public interface DAOOficinas {
	
	public List<Offices> getAllOficinas();
	public Offices getOffice(String officeCode);

}
