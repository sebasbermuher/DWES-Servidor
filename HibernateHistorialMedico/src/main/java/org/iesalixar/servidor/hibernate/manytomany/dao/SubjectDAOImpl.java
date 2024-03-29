package org.iesalixar.servidor.hibernate.manytomany.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.manytomany.model.Subject;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAOImpl;

public class SubjectDAOImpl extends GenericDAOImpl<Subject> implements SubjectDAO {

	private Session session;

	public SubjectDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	public Subject searchByName(String name) {
		// Compruebo que la conexión está actica
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Recupero los libros por isbn
		// No es una consulta Nativa uso el nombre de la clase
		List<Subject> subjectList = session.createQuery("FROM Subject WHERE name=:name").setParameter("name", name)
				.list();

		// Como el ISBN es único si me devuelve algo me quedo con el primero
		Subject subject = null;
		if (subjectList != null && subjectList.size() > 0) {
			subject = subjectList.get(0);
		}

		return subject;
	}

}
