package com.fstg.service.facade;

import java.util.List;

import com.fstg.bean.Etudiant;
import com.fstg.bean.Inscription;
import com.fstg.bean.TypeDiplome;

public interface EtudiantService {
	public Etudiant findByCne(String cne);

	public List<Etudiant> findAll();

	// public int save(Etudiant etudiant);

	public int saveEtudiant(Etudiant etudiant);

	public List<Etudiant> findByInscriptionsConcoursReference(String reference);

	public int deleteByTypeDiplomeLibelle(String libelle);

	int seConnecter(Etudiant etudiant);

	int register(Etudiant etudiant);

	public Etudiant update(Long id, String cne, String nom, String prenom, String email);

	public Etudiant updateEtudiant(Long id, String cin, String cne, String nom, String prenom, String email,
			TypeDiplome typeDiplome, List<Inscription> inscriptions);

	public Etudiant updateNew(String cne, Etudiant etudiant2);

	public List<Etudiant> findByMoyenne(double seuil);
	
	public List<Etudiant> findByTypeDiplomeLibelle(String libelle);


}
