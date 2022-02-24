package org.iesalixar.servidor.hibernate.manytomany.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.manytomany.dao.StudentDAO;
import org.iesalixar.servidor.hibernate.manytomany.dao.StudentDAOImpl;
import org.iesalixar.servidor.hibernate.manytomany.model.Student;

public class StudentServiceImpl implements StudentService {

	// El servicio encapsulará el uso del DAO
	// y añadirá logica de negocio necesaria
	private StudentDAO studentDao;

	public StudentServiceImpl(final Session session) {

			this.studentDao = new StudentDAOImpl(session);
		}

	@Override
	public void insertNewStudent(final Student student) {

		// Compruebo que no es nulo y que aún no existe
		// es decir no tiene ID
		if (student != null && student.getId() == null) {
			// Inserción del publisher
			studentDao.insert(student);
		}

	}

	@Override
	public void updateStudent(final Student student) {

		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (student != null && student.getId() != null) {

			// Actualizo el teacher
			studentDao.update(student);
		}
	}

	@Override
	public void deleteStudent(final Student student) {

		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (student != null && student.getId() != null) {

			// Borro el teacher
			studentDao.delete(student);
		}
	}

	@Override
	public Student searchById(final Long studentId) {

		Student student = null;

		if (studentId != null) {

			student = studentDao.searchById(studentId);
		}

		return student;
	}

	@Override
	public List<Student> searchAll() {

		List<Student> studentList = new ArrayList<Student>();

		studentList = studentDao.searchAll();

		return studentList;
	}

	@Override
	public Student searchStudentByDNI(final String dni) {

		Student student = null;

		if (dni != null) {

			student = studentDao.searchByDNI(dni);
		}

		return student;
	}

}
