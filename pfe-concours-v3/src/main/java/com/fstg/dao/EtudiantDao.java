package com.fstg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fstg.bean.Etudiant;

@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Long> {

	public Etudiant findByCne(String cne);

	public List<Etudiant> findByInscriptionsConcoursReference(String reference);

	public int deleteByTypeDiplomeLibelle(String libelle);

	@Query("SELECT e FROM Etudiant e WHERE e.moyenne >= :seuil")
	public List<Etudiant> findByMoyenne(@Param(value = "seuil") double seuil);
	
	public List<Etudiant> findByTypeDiplomeLibelle(String libelle);
}
