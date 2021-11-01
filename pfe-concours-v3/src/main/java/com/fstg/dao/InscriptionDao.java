package com.fstg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.bean.Inscription;

@Repository
public interface InscriptionDao extends JpaRepository<Inscription, Long> {

	public Inscription findByReference(String reference);

	public List<Inscription> findByConcoursReference(String reference);

	public List<Inscription> findByConcoursId(Long id);

	public List<Inscription> findByConcoursDescription(String description);
	
	public Inscription findByEtudiantCneAndConcoursReference(String cne, String reference);
	
	public int deleteByConcoursReference(String reference);
	
	public int deleteByEtudiantCne(String cne);


}