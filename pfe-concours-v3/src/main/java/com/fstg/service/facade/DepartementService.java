package com.fstg.service.facade;

import java.util.List;

import com.fstg.bean.Departement;
import com.fstg.bean.TypeDiplome;

public interface DepartementService {
	public int save(Departement departement);

	public Departement findByReference(String reference);

	public List<Departement> findAll();

	public int deleteByReference(String reference);

	public Departement update(Long id, String nom, String reference, String description, String chef);

}