package org.iesalixar.servidor.hibernate.manytomany.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.manytomany.model.Student;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAOImpl;

public class StudentDAOImpl extends GenericDAOImpl<Student> implements StudentDAO {

	private Session session;

	public StudentDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	public Student searchByDNI(String dni) {
		// Compruebo que la conexión está actica
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Recupero los profesores
		// No es una consulta Nativa uso el nombre de la clase
		List<Student> studentList = session.createQuery("FROM Student WHERE dni=:dni").setParameter("dni", dni).list();

		// Como el NSS es único si me devuelve algo me quedo con el primero
		Student student = null;
		if (studentList != null && studentList.size() > 0) {
			student = studentList.get(0);
		}

		return student;

	}

}
