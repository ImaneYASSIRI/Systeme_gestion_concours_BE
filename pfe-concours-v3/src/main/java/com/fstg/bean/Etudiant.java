package com.fstg.bean;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Etudiant implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cne;
	private String cin;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	@Temporal(TemporalType.DATE)
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateNaissance;
	private double noteS1;
	private double noteS2;
	private double noteS3;
	private double noteS4;
	private double moyenneBac;
	private int anneeBac;
	private double moyenne;
	@ManyToOne
	private TypeDiplome typeDiplome;
	@OneToMany(mappedBy = "etudiant")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Inscription> inscriptions;
	private File imageBac;
	private File imageS1;
	private File imageS2;
	private File imageS3;
	private File imageS4;

	private String password;
	private boolean bloqued;
	private int nbrTentativeRestant;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date dateBloquage;

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(Long id, String cne, String cin, String nom, String prenom, String email, String telephone,
			Date dateNaissance, double noteS1, double noteS2, double noteS3, double noteS4, double moyenneBac,
			int anneeBac, double moyenne, TypeDiplome typeDiplome, List<Inscription> inscriptions, File imageBac,
			File imageS1, File imageS2, File imageS3, File imageS4, String password, boolean bloqued,
			int nbrTentativeRestant, Date dateBloquage) {
		super();
		this.id = id;
		this.cne = cne;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.noteS1 = noteS1;
		this.noteS2 = noteS2;
		this.noteS3 = noteS3;
		this.noteS4 = noteS4;
		this.moyenneBac = moyenneBac;
		this.anneeBac = anneeBac;
		this.moyenne = moyenne;
		this.typeDiplome = typeDiplome;
		this.inscriptions = inscriptions;
		this.imageBac = imageBac;
		this.imageS1 = imageS1;
		this.imageS2 = imageS2;
		this.imageS3 = imageS3;
		this.imageS4 = imageS4;
		this.password = password;
		this.bloqued = bloqued;
		this.nbrTentativeRestant = nbrTentativeRestant;
		this.dateBloquage = dateBloquage;
	}

	public double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public double getNoteS1() {
		return noteS1;
	}

	public void setNoteS1(double noteS1) {
		this.noteS1 = noteS1;
	}

	public double getNoteS2() {
		return noteS2;
	}

	public void setNoteS2(double noteS2) {
		this.noteS2 = noteS2;
	}

	public double getNoteS3() {
		return noteS3;
	}

	public void setNoteS3(double noteS3) {
		this.noteS3 = noteS3;
	}

	public double getNoteS4() {
		return noteS4;
	}

	public void setNoteS4(double noteS4) {
		this.noteS4 = noteS4;
	}

	public double getMoyenneBac() {
		return moyenneBac;
	}

	public void setMoyenneBac(double moyenneBac) {
		this.moyenneBac = moyenneBac;
	}

	public TypeDiplome getTypeDiplome() {
		return typeDiplome;
	}

	public void setTypeDiplome(TypeDiplome typeDiplome) {
		this.typeDiplome = typeDiplome;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public File getImageBac() {
		return imageBac;
	}

	public void setImageBac(File imageBac) {
		this.imageBac = imageBac;
	}

	public File getImageS1() {
		return imageS1;
	}

	public void setImageS1(File imageS1) {
		this.imageS1 = imageS1;
	}

	public File getImageS2() {
		return imageS2;
	}

	public void setImageS2(File imageS2) {
		this.imageS2 = imageS2;
	}

	public File getImageS3() {
		return imageS3;
	}

	public void setImageS3(File imageS3) {
		this.imageS3 = imageS3;
	}

	public File getImageS4() {
		return imageS4;
	}

	public void setImageS4(File imageS4) {
		this.imageS4 = imageS4;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isBloqued() {
		return bloqued;
	}

	public void setBloqued(boolean bloqued) {
		this.bloqued = bloqued;
	}

	public int getNbrTentativeRestant() {
		return nbrTentativeRestant;
	}

	public void setNbrTentativeRestant(int nbrTentativeRestant) {
		this.nbrTentativeRestant = nbrTentativeRestant;
	}

	public Date getDateBloquage() {
		return dateBloquage;
	}

	public void setDateBloquage(Date dateBloquage) {
		this.dateBloquage = dateBloquage;
	}

	public int getAnneeBac() {
		return anneeBac;
	}

	public void setAnneeBac(int anneeBac) {
		this.anneeBac = anneeBac;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof User)) {
			return false;
		}
		Etudiant other = (Etudiant) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.AgenceLocation.bean.User[ id=" + id + " ]";
	}
}
