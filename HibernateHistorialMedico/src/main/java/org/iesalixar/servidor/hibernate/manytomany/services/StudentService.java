package org.iesalixar.servidor.hibernate.manytomany.services;

import java.util.List;

import org.iesalixar.servidor.hibernate.manytomany.model.Student;

public interface StudentService {
	public void insertNewStudent(final Student student);

	public void updateStudent(final Student student);

	public void deleteStudent(final Student student);

	public Student searchById(final Long studentId);

	public List<Student> searchAll();

	public Student searchStudentByDNI(final String dni);
}