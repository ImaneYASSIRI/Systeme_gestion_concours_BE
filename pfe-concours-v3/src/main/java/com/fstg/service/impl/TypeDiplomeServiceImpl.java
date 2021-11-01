package com.fstg.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.bean.TypeDiplome;
import com.fstg.dao.TypeDiplomeDao;
import com.fstg.service.facade.ConfigConcoursService;
import com.fstg.service.facade.EtudiantService;
import com.fstg.service.facade.TypeDiplomeService;

@Service
public class TypeDiplomeServiceImpl implements TypeDiplomeService {
	@Autowired
	private TypeDiplomeDao typeDiplomeDao;

	@Autowired
	private ConfigConcoursService configConcoursService;

	@Autowired
	private EtudiantService etudiantService;

	@Override
	public TypeDiplome findByLibelle(String libelle) {
		return typeDiplomeDao.findByLibelle(libelle);
	}

	@Override
	public int save(TypeDiplome typeDiplome) {
		TypeDiplome foundedTypeDiplome = findByLibelle(typeDiplome.getLibelle());
		if (foundedTypeDiplome != null) {
			return -1;
		} else {
			typeDiplomeDao.save(typeDiplome);
			// Update
			configConcoursService.save(typeDiplome, typeDiplome.getConfigConcourss());
		}
		return 1;
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		int resConfigConcours = configConcoursService.deleteByTypeDiplomeLibelle(libelle);
		int resEtudiant = etudiantService.deleteByTypeDiplomeLibelle(libelle);
		int resTypeDiplome = typeDiplomeDao.deleteByLibelle(libelle);
		return resConfigConcours * resTypeDiplome * resEtudiant;
	}

	@Override
	public List<TypeDiplome> findAll() {
		return typeDiplomeDao.findAll();
	}

	@Override
	public TypeDiplome update(Long id, String libelle, String description) {
		TypeDiplome foundedTypeDiplome = findById(id);
		foundedTypeDiplome.setLibelle(libelle);
		foundedTypeDiplome.setDescription(description);
		TypeDiplome updatedTypeDiplome = typeDiplomeDao.save(foundedTypeDiplome);
		return updatedTypeDiplome;
	}

	public TypeDiplome findById(Long id) {
		return typeDiplomeDao.getOne(id);
	}

}