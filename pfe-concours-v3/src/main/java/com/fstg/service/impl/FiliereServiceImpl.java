package com.fstg.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.bean.Departement;
import com.fstg.bean.Filiere;
import com.fstg.bean.TypeDiplome;
import com.fstg.dao.DepartementDao;
import com.fstg.dao.FiliereDao;
import com.fstg.service.facade.FiliereService;

@Service
public class FiliereServiceImpl implements FiliereService {

	@Autowired
	private FiliereDao filiereDao;

	@Override
	public Filiere findByLibelle(String libelle) {
		return filiereDao.findByLibelle(libelle);
	}

	@Override
	public List<Filiere> findAll() {
		return filiereDao.findAll();
	}

	@Override
	public int save(Departement departement , List<Filiere> filieres) {
		for (Filiere filiere : filieres) {
			filiere.setDepartement(departement);
			filiereDao.save(filiere);
		}
		return 1;
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		Filiere foundedFiliere = findByLibelle(libelle);
		if(foundedFiliere!=null) {
			int resDepartemen = filiereDao.deleteByLibelle(libelle);
			return resDepartemen;
		}else {
			return -1;
		}
	}

	@Override
	public List<Filiere> findByDepartementRefrence(String reference) {
		return filiereDao.findByDepartementReference(reference);
	}

	@Override
	public int deleteByDepartementReference(String reference) {
		return filiereDao.deleteByDepartementReference(reference);
	}

	@Override
	public int deleteById(Long id) {
		filiereDao.deleteById(id);
		return 1;
	}

	@Override
	public Filiere update(Long id, String libelle, String description, String responsable) {
		Filiere foundedFiliere = findById(id);
		foundedFiliere.setLibelle(libelle);
		foundedFiliere.setDescription(description);
		foundedFiliere.setResponsable(responsable);
		Filiere updatedFiliere = filiereDao.save(foundedFiliere);
		return updatedFiliere;
	}

	public Filiere findById(Long id) {
		return filiereDao.getOne(id);
	}

}