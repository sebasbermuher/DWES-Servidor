package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Offices;

public interface OfficesDAO {
	
	public List<Offices> getAllOffices();
	public Offices getEmployeesByCity(String city);

}
