package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vehiculo")
public class Vehiculo implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "matricula", unique = true, length = 100, nullable = false)
    private String matricula;

    @Column(name = "color", unique = true, length = 100, nullable = false)
    private String color;

    @OneToMany(mappedBy="vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Multas> multas = new HashSet<>();



    public Vehiculo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Multas> getMultas() {
        return multas;
    }

    public void setMultas(Set<Multas> multas) {
        this.multas = multas;
    }

    //HELPERS
    public void addMulta(Multas multa) {
        this.multas.add(multa);
        multa.setVehiculo(this);
    }

    public void removeMulta(Multas multa) {
        this.multas.remove(multa);
        multa.setVehiculo(null);
    }

    @Override
    public String toString() {
        return "Vehiculo [id=" + id + ", matricula=" + matricula + ", color=" + color + ", multas=" + multas + "]";
    }



}