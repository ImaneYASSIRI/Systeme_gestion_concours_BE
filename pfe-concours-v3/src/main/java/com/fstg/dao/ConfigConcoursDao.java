package com.fstg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.bean.ConfigConcours;

@Repository
public interface ConfigConcoursDao extends JpaRepository<ConfigConcours, Long> {

	public List<ConfigConcours> findByTypeDiplomeLibelle(String libelle);

	// public ConfigConcours findByTypeDiplomeLibelle(String libelle);

	public List<ConfigConcours> findByConcoursReference(String reference);

	public ConfigConcours findByConcoursReferenceAndTypeDiplomeLibelle(String reference, String libelle);

	public int deleteByTypeDiplomeLibelle(String libelle);

	public int deleteByConcoursReference(String reference);

}
