package org.iesalixar.servidor.hibernate.manytomany.dao;

import org.iesalixar.servidor.hibernate.manytomany.model.Student;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAO;

public interface StudentDAO extends GenericDAO<Student> {

	public Student searchByDNI(final String dni);
}
