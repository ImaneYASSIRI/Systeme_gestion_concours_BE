package com.fstg.service.facade;

import java.util.List;

import com.fstg.bean.Concours;
import com.fstg.bean.ConfigConcours;
import com.fstg.bean.TypeDiplome;

public interface ConfigConcoursService {

	public List<ConfigConcours> findAll();

	public List<ConfigConcours> findByConcoursReference(String reference);

	public List<ConfigConcours> findByTypeDiplomeLibelle(String libelle);

	// public ConfigConcours findByTypeDiplomeLibelle(String libelle);

	public int save(ConfigConcours configConcours);

	public int save(Concours concours, List<ConfigConcours> configConcourss);

	public ConfigConcours findByConcoursReferenceAndTypeDiplomeLibelle(String reference, String libelle);

	public boolean validateConfigConcours(Concours concours, List<ConfigConcours> configConcourss);

	public int deleteByTypeDiplomeLibelle(String libelle);

	public int deleteByConcoursReference(String reference);

	public int save(TypeDiplome typeDiplome, List<ConfigConcours> configConcourss);

	public ConfigConcours update(Long id, double noteMin, int nbreMaxAdmis, int nbreMaxEcritAdmis,
			int nbreMaxOraleAdmis);

	public int deleteById(Long id);

}
