package com.fstg.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// hey
@Entity
public class Filiere {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	private String description;
	private String responsable;
	@ManyToOne
	private Departement departement;

	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Filiere(Long id, String libelle, String description, String responsable, Departement departement) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.responsable = responsable;
		this.departement = departement;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

}