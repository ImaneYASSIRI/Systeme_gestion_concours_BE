package com.fstg.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class TypeDiplome implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	private String description;

	@OneToMany(mappedBy = "typeDiplome")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<ConfigConcours> configConcourss = new ArrayList<ConfigConcours>();

	@OneToMany(mappedBy = "typeDiplome")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Etudiant> etudiants = new ArrayList<Etudiant>();

	public TypeDiplome(Long id, String libelle, String description, List<ConfigConcours> configConcourss,
			List<Etudiant> etudiants) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.configConcourss = configConcourss;
		this.etudiants = etudiants;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((configConcourss == null) ? 0 : configConcourss.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeDiplome other = (TypeDiplome) obj;
		if (configConcourss == null) {
			if (other.configConcourss != null)
				return false;
		} else if (!configConcourss.equals(other.configConcourss))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}

	public TypeDiplome() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeDiplome(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
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

	public List<ConfigConcours> getConfigConcourss() {
		return configConcourss;
	}

	public void setConfigConcourss(List<ConfigConcours> configConcourss) {
		this.configConcourss = configConcourss;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

}