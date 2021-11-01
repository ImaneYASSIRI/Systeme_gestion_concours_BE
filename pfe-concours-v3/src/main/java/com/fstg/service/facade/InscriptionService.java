package com.fstg.service.facade;

import java.util.List;

import com.fstg.bean.Concours;
import com.fstg.bean.Etudiant;
import com.fstg.bean.Inscription;

public interface InscriptionService {
	public Inscription findByReference(String reference);

	public List<Inscription> findByConcoursReference(String reference);

	public List<Inscription> findAll();

	public int save(Inscription inscription);

	public int save(Concours concours, List<Inscription> inscriptions);

	public int save(Etudiant etudiant, List<Inscription> inscriptions);

	public List<Inscription> findByConcoursId(Long id);

	public List<Inscription> findByConcoursDescription(String description);

	public Inscription findByEtudiantCneAndConcoursReference(String cne, String reference);

	public int deleteByConcoursReference(String reference);
	
	public int deleteByEtudiantCne(String cne);


}
