package com.fstg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.bean.Filiere;

@Repository
public interface FiliereDao extends JpaRepository<Filiere, Long> {
	Filiere findByLibelle(String libelle);

	public int deleteByLibelle(String libelle);

	public int deleteByDepartementReference(String reference);

	public List<Filiere> findByDepartementReference(String reference);
}
