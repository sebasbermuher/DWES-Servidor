package org.iesalixar.servidor.hibernate.manytomany.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="student")
public class Student implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="dni", nullable=false, unique = true, length=20)	
	private String DNI;
	
	@Column(name="firstName",nullable = false, length=50)
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name = "dateOfBirth" , nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@ManyToMany(mappedBy = "student")
	private Set<Subject> subjects = new HashSet<>();
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	//No tiene sentido el Set ya que es auto generado por Hibernate
	public Long getId() {
		return id;
	}	


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String DNI) {
		DNI = DNI;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Set<Subject> getSubjects() {
		return subjects;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(DNI);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(DNI, other.DNI);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", DNI=" + DNI + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", subjects=" + subjects + "]";
	}
	

}
