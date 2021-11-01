package com.fstg.service.facade;

import java.util.List;
import java.util.Optional;

import com.fstg.bean.TypeDiplome;

public interface TypeDiplomeService {

	public TypeDiplome findByLibelle(String libelle);

	public TypeDiplome findById(Long id);

	public List<TypeDiplome> findAll();

	public int save(TypeDiplome typeDiplome);

	public int deleteByLibelle(String libelle);

	public TypeDiplome update(Long id, String libelle, String description);

}
