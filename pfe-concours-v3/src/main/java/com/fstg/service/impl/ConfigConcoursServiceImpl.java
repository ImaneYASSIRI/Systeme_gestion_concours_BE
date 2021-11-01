package com.fstg.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.bean.Concours;
import com.fstg.bean.ConfigConcours;
import com.fstg.bean.Filiere;
import com.fstg.bean.TypeDiplome;
import com.fstg.dao.ConfigConcoursDao;
import com.fstg.service.facade.ConcoursService;
import com.fstg.service.facade.ConfigConcoursService;
import com.fstg.service.facade.TypeDiplomeService;

@Service
public class ConfigConcoursServiceImpl implements ConfigConcoursService {
	@Autowired
	private ConfigConcoursDao configConcoursDao;
	@Autowired
	private ConcoursService concoursService;
	@Autowired
	private TypeDiplomeService typeDiplomeService;

	@Override
	public List<ConfigConcours> findByConcoursReference(String reference) {
		return configConcoursDao.findByConcoursReference(reference);
	}

	@Override
	public List<ConfigConcours> findAll() {
		return configConcoursDao.findAll();
	}

	@Override
	public List<ConfigConcours> findByTypeDiplomeLibelle(String libelle) {
		return configConcoursDao.findByTypeDiplomeLibelle(libelle);
	}

	@Override
	public ConfigConcours findByConcoursReferenceAndTypeDiplomeLibelle(String reference, String libelle) {
		return configConcoursDao.findByConcoursReferenceAndTypeDiplomeLibelle(reference, libelle);
	}

	@Override
	@Transactional
	public int deleteByTypeDiplomeLibelle(String libelle) {
		return configConcoursDao.deleteByTypeDiplomeLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByConcoursReference(String reference) {
		return configConcoursDao.deleteByConcoursReference(reference);
	}

	@Override
	public int save(Concours concours, List<ConfigConcours> configConcourss) {
		/*
		 * if (configConcourss != null && !configConcourss.isEmpty()) { for
		 * (ConfigConcours c : configConcourss) { c.setConcours(concours);
		 * configConcoursDao.save(c); } }
		 */

		for (ConfigConcours configConcours : configConcourss) {
			TypeDiplome typeDiplome = typeDiplomeService.findByLibelle(configConcours.getTypeDiplome().getLibelle());
			if (typeDiplome != null) {
				configConcours.setTypeDiplome(typeDiplome);
				configConcours.setConcours(concours);
				configConcours.setAnneeBacMin(configConcours.getAnneeBacMax() -1);
				configConcoursDao.save(configConcours);
			}
		}
		return 1;
	}

	@Override
	public boolean validateConfigConcours(Concours concours, List<ConfigConcours> configConcourss) {
		List<ConfigConcours> valideConcours = configConcourss.stream()
				.filter(cc -> concoursService.findByReference(cc.getConcours().getReference()) != null)
				.collect(Collectors.toList());
		return valideConcours.size() == configConcourss.size();
	}

	@Override
	public int save(ConfigConcours configConcours) {
		TypeDiplome typeDiplome = typeDiplomeService.findByLibelle(configConcours.getTypeDiplome().getLibelle());
		Concours concours = concoursService.findByReference(configConcours.getConcours().getReference());
		if (typeDiplome == null) {
			return -1;
		} else if (concours != null) {
			return -2;
		} else {
			configConcours.setConcours(concours);
			configConcours.setTypeDiplome(typeDiplome);
			configConcoursDao.save(configConcours);
			return 1;
		}

	}

	@Override
	public int save(TypeDiplome typeDiplome, List<ConfigConcours> configConcourss) {
		for (ConfigConcours configConcours : configConcourss) {
			configConcours.setTypeDiplome(typeDiplome);
			configConcoursDao.save(configConcours);
		}
		return 1;

	}

	@Override
	public ConfigConcours update(Long id, double noteMin, int nbreMaxAdmis, int nbreMaxEcritAdmis,
			int nbreMaxOraleAdmis) {
		ConfigConcours foundedConfigConcours = findById(id);
		foundedConfigConcours.setNoteMin(noteMin);
		foundedConfigConcours.setNbreMaxAdmis(nbreMaxAdmis);
		foundedConfigConcours.setNbreMaxEcritAdmis(nbreMaxEcritAdmis);
		foundedConfigConcours.setNbreMaxOraleAdmis(nbreMaxOraleAdmis);
		ConfigConcours updatedConfigConcours = configConcoursDao.save(foundedConfigConcours);
		return updatedConfigConcours;
	}

	public ConfigConcours findById(Long id) {
		return configConcoursDao.getOne(id);
	}

	@Override
	public int deleteById(Long id) {
		configConcoursDao.deleteById(id);
		return 1;
	}

}
