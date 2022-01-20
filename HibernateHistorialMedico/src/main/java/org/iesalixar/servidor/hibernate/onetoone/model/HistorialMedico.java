package org.iesalixar.servidor.hibernate.onetoone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class HistorialMedico {

	@Entity
	@Table(name = "HistorialMedico")
	public class Passport {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

		@Column(name = "country", nullable = false)
		private String country;

		// Para el caso bidireccional
		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "person_id")
		private Person person;
	}
}
