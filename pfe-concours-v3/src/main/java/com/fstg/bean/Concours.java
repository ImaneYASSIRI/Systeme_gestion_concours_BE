package com.fstg.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Concours implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	private String description;
	private int nbreEtudiantAdmisOrale;
	private int nbreEtudiantAdmisEcrit;
	private int nbreEtudiantAdmis;
	@Temporal(TemporalType.DATE)
	private Date dateOrale;
	@Temporal(TemporalType.DATE)
	private Date dateEcrit;
	@Temporal(TemporalType.DATE)
	private Date dateAffichageResultatFinal;
	private int annee;
	@Temporal(TemporalType.DATE)
	@OneToMany(mappedBy = "concours")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Inscription> inscriptions;
	@OneToMany(mappedBy = "concours")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<ConfigConcours> configConcourss = new ArrayList<ConfigConcours>();

	public Concours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Concours(Long id, String reference, String description, int nbreEtudiantAdmisOrale,
			int nbreEtudiantAdmisEcrit, int nbreEtudiantAdmis, Date dateOrale, Date dateEcrit,
			Date dateAffichageResultatFinal, int annee, List<Inscription> inscriptions,
			List<ConfigConcours> configConcourss) {
		super();
		this.id = id;
		this.reference = reference;
		this.description = description;
		this.nbreEtudiantAdmisOrale = nbreEtudiantAdmisOrale;
		this.nbreEtudiantAdmisEcrit = nbreEtudiantAdmisEcrit;
		this.nbreEtudiantAdmis = nbreEtudiantAdmis;
		this.dateOrale = dateOrale;
		this.dateEcrit = dateEcrit;
		this.dateAffichageResultatFinal = dateAffichageResultatFinal;
		this.annee = annee;
		this.inscriptions = inscriptions;
		this.configConcourss = configConcourss;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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

	public int getNbreEtudiantAdmisOrale() {
		return nbreEtudiantAdmisOrale;
	}

	public void setNbreEtudiantAdmisOrale(int nbreEtudiantAdmisOrale) {
		this.nbreEtudiantAdmisOrale = nbreEtudiantAdmisOrale;
	}

	public int getNbreEtudiantAdmisEcrit() {
		return nbreEtudiantAdmisEcrit;
	}

	public void setNbreEtudiantAdmisEcrit(int nbreEtudiantAdmisEcrit) {
		this.nbreEtudiantAdmisEcrit = nbreEtudiantAdmisEcrit;
	}

	public int getNbreEtudiantAdmis() {
		return nbreEtudiantAdmis;
	}

	public void setNbreEtudiantAdmis(int nbreEtudiantAdmis) {
		this.nbreEtudiantAdmis = nbreEtudiantAdmis;
	}

	public Date getDateOrale() {
		return dateOrale;
	}

	public void setDateOrale(Date dateOrale) {
		this.dateOrale = dateOrale;
	}

	public Date getDateEcrit() {
		return dateEcrit;
	}

	public void setDateEcrit(Date dateEcrit) {
		this.dateEcrit = dateEcrit;
	}

	public Date getDateAffichageResultatFinal() {
		return dateAffichageResultatFinal;
	}

	public void setDateAffichageResultatFinal(Date dateAffichageResultatFinal) {
		this.dateAffichageResultatFinal = dateAffichageResultatFinal;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annee;
		result = prime * result + ((configConcourss == null) ? 0 : configConcourss.hashCode());
		result = prime * result + ((dateAffichageResultatFinal == null) ? 0 : dateAffichageResultatFinal.hashCode());
		result = prime * result + ((dateEcrit == null) ? 0 : dateEcrit.hashCode());
		result = prime * result + ((dateOrale == null) ? 0 : dateOrale.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inscriptions == null) ? 0 : inscriptions.hashCode());
		result = prime * result + nbreEtudiantAdmis;
		result = prime * result + nbreEtudiantAdmisEcrit;
		result = prime * result + nbreEtudiantAdmisOrale;
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
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
		Concours other = (Concours) obj;
		if (annee != other.annee)
			return false;
		if (configConcourss == null) {
			if (other.configConcourss != null)
				return false;
		} else if (!configConcourss.equals(other.configConcourss))
			return false;
		if (dateAffichageResultatFinal == null) {
			if (other.dateAffichageResultatFinal != null)
				return false;
		} else if (!dateAffichageResultatFinal.equals(other.dateAffichageResultatFinal))
			return false;
		if (dateEcrit == null) {
			if (other.dateEcrit != null)
				return false;
		} else if (!dateEcrit.equals(other.dateEcrit))
			return false;
		if (dateOrale == null) {
			if (other.dateOrale != null)
				return false;
		} else if (!dateOrale.equals(other.dateOrale))
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
		if (inscriptions == null) {
			if (other.inscriptions != null)
				return false;
		} else if (!inscriptions.equals(other.inscriptions))
			return false;
		if (nbreEtudiantAdmis != other.nbreEtudiantAdmis)
			return false;
		if (nbreEtudiantAdmisEcrit != other.nbreEtudiantAdmisEcrit)
			return false;
		if (nbreEtudiantAdmisOrale != other.nbreEtudiantAdmisOrale)
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}

}