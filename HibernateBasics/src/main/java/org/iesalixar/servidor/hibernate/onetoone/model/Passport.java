package org.iesalixar.servidor.hibernate.onetoone.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="passports")
public class Passport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "number", nullable = false, unique = true)
	private String number;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "expedition", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfExpedition;
	
	@Column(name = "validity" , nullable = false)
	@Temporal(TemporalType.DATE)
	private Date endOfValidity;
	
	//Para el caso bidireccional
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

	public Passport() {
		// TODO Auto-generated constructor stub
	}

	
	public Passport(Long id, String number, String country, Date dateOfExpedition, Date endOfValidity) {
		super();
		this.id = id;
		this.number = number;
		this.country = country;
		this.dateOfExpedition = dateOfExpedition;
		this.endOfValidity = endOfValidity;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDateOfExpedition() {
		return dateOfExpedition;
	}

	public void setDateOfExpedition(Date dateOfExpedition) {
		this.dateOfExpedition = dateOfExpedition;
	}

	public Date getEndOfValidity() {
		return endOfValidity;
	}

	public void setEndOfValidity(Date endOfValidity) {
		this.endOfValidity = endOfValidity;
	}


	//No tiene sentido el setId porque se generará
	public Long getId() {
		return id;
	}


	//Para el caso de relación bidireccional
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}	
	
	
	
}
