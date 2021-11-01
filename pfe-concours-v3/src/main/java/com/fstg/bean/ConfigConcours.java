package com.fstg.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ConfigConcours implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double noteMin;
	private int nbreMaxAdmis;
	private int nbreMaxEcritAdmis;
	private int nbreMaxOraleAdmis;
	@ManyToOne
	private TypeDiplome typeDiplome;
	@ManyToOne
	private Concours concours;
	private int anneeBacMax;
	private int anneeBacMin;

	public ConfigConcours() {
		super();
	}

	/*public ConfigConcours(Long id, double noteMin, int nbreMaxAdmis, int nbreMaxEcritAdmis, int nbreMaxOraleAdmis,
			TypeDiplome typeDiplome, Concours concours) {
		super();
		this.id = id;
		this.noteMin = noteMin;
		this.nbreMaxAdmis = nbreMaxAdmis;
		this.nbreMaxEcritAdmis = nbreMaxEcritAdmis;
		this.nbreMaxOraleAdmis = nbreMaxOraleAdmis;
		this.typeDiplome = typeDiplome;
		this.concours = concours;
	}*/

	public ConfigConcours(Long id, double noteMin, int nbreMaxAdmis, int nbreMaxEcritAdmis, int nbreMaxOraleAdmis,
			TypeDiplome typeDiplome, Concours concours, int anneeBacMax, int anneeBacMin) {
		super();
		this.id = id;
		this.noteMin = noteMin;
		this.nbreMaxAdmis = nbreMaxAdmis;
		this.nbreMaxEcritAdmis = nbreMaxEcritAdmis;
		this.nbreMaxOraleAdmis = nbreMaxOraleAdmis;
		this.typeDiplome = typeDiplome;
		this.concours = concours;
		this.anneeBacMax = anneeBacMax;
		this.anneeBacMin = anneeBacMin;
	}

	public TypeDiplome getTypeDiplome() {
		return typeDiplome;
	}

	public void setTypeDiplome(TypeDiplome typeDiplome) {
		this.typeDiplome = typeDiplome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getNoteMin() {
		return noteMin;
	}

	public void setNoteMin(double noteMin) {
		this.noteMin = noteMin;
	}

	public double getNbreMaxAdmis() {
		return nbreMaxAdmis;
	}

	public void setNbreMaxAdmis(int nbreMaxAdmis) {
		this.nbreMaxAdmis = nbreMaxAdmis;
	}

	public double getNbreMaxEcritAdmis() {
		return nbreMaxEcritAdmis;
	}

	public void setNbreMaxEcritAdmis(int nbreMaxEcritAdmis) {
		this.nbreMaxEcritAdmis = nbreMaxEcritAdmis;
	}

	public double getNbreMaxOraleAdmis() {
		return nbreMaxOraleAdmis;
	}

	public void setNbreMaxOraleAdmis(int nbreMaxOraleAdmis) {
		this.nbreMaxOraleAdmis = nbreMaxOraleAdmis;
	}

	public Concours getConcours() {
		return concours;
	}

	public void setConcours(Concours concours) {
		this.concours = concours;
	}

	public int getAnneeBacMax() {
		return anneeBacMax;
	}

	public void setAnneeBacMax(int anneeBacMax) {
		this.anneeBacMax = anneeBacMax;
	}

	public int getAnneeBacMin() {
		return anneeBacMin;
	}

	public void setAnneeBacMin(int anneeBacMin) {
		this.anneeBacMin = anneeBacMin;
	}

}
