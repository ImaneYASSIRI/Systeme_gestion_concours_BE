package com.fstg.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.bean.Concours;
import com.fstg.bean.Etudiant;
import com.fstg.bean.Inscription;
import com.fstg.dao.InscriptionDao;
import com.fstg.service.facade.ConcoursService;
import com.fstg.service.facade.EtudiantService;
import com.fstg.service.facade.InscriptionService;

@Service
public class InscriptionServiceImpl implements InscriptionService {

	@Autowired
	private InscriptionDao inscriptionDao;

	@Autowired
	private EtudiantService etudiantService;

	@Autowired
	private ConcoursService concoursService;

	@Override
	public List<Inscription> findByConcoursId(Long id) {
		return inscriptionDao.findByConcoursId(id);

	}

	@Override
	public List<Inscription> findByConcoursDescription(String description) {
		return inscriptionDao.findByConcoursDescription(description);

	}

	@Override
	public Inscription findByReference(String reference) {
		return inscriptionDao.findByReference(reference);
	}

	@Override
	public List<Inscription> findByConcoursReference(String reference) {
		return inscriptionDao.findByConcoursReference(reference);
	}

	@Override
	public int save(Inscription inscription) {
		Inscription loadedInscription = findByReference(inscription.getReference());
		Etudiant loadedEtudiant = etudiantService.findByCne(inscription.getEtudiant().getCne());
		Concours loadedConcours = concoursService.findByReference(inscription.getConcours().getReference());
		if (loadedEtudiant == null) {
			return -1;
		} else if (loadedConcours == null) {
			return -2;
		} else if (loadedInscription != null) {
			return -3;
		}

		else {
			inscription.setDateInscription(new Date());
			inscription.setConcours(loadedConcours);
			inscription.setEtudiant(loadedEtudiant);
			inscriptionDao.save(inscription);
			return 1;

		}

	}

	@Override
	public int save(Concours concours, List<Inscription> inscriptions) {

		for (Inscription inscription : inscriptions) {
			inscription.setConcours(concours);
			inscriptionDao.save(inscription);

		}
		return 1;
	}

	@Override
	public int save(Etudiant etudiant, List<Inscription> inscriptions) {
		if(inscriptions==null) {
			return -1;
		}
		for (Inscription inscription : inscriptions) {
			if (inscription.getConcours() != null) {
				Concours concours = concoursService.findByReference(inscription.getConcours().getReference());
				if (concours != null) {
					inscription.setConcours(concours);
					inscription.setEtudiant(etudiant);
					inscriptionDao.save(inscription);
				}
			}
		}
		return 1;
	}

	@Override
	public List<Inscription> findAll() {
		return inscriptionDao.findAll();
	}

	@Override
	public Inscription findByEtudiantCneAndConcoursReference(String cne, String reference) {
		return inscriptionDao.findByEtudiantCneAndConcoursReference(cne, reference);
	}

	@Override
	@Transactional
	public int deleteByConcoursReference(String reference) {
		return inscriptionDao.deleteByConcoursReference(reference);
	}
	
	@Override
	@Transactional
	public int deleteByEtudiantCne(String cne) {
		return inscriptionDao.deleteByEtudiantCne(cne);
	}
}
