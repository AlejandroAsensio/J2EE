package org.alejandro.pap.entitites;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Aficion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true) //TODO
	private String nombre;
	
	@ManyToMany(mappedBy = "aficionesGusta")
	private Collection<Persona> personasQueGustan;
	
	// ========================
	public Aficion() {
		this.nombre = "roncar";
		this.personasQueGustan = new ArrayList<Persona>();
	}

	public Aficion(String nombre) {

		this.nombre = nombre;
		this.personasQueGustan = new ArrayList<Persona>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Persona> getPersonasQueGustan() {
		return personasQueGustan;
	}

	public void setPersonasQueGustan(Collection<Persona> personasQueGustan) {
		this.personasQueGustan = personasQueGustan;
	}

	// ==================

}
