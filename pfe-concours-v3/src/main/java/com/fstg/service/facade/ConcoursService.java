package com.fstg.service.facade;

import java.util.List;

import com.fstg.bean.Concours;
import com.fstg.bean.Departement;
import java.util.Date;

public interface ConcoursService {
	public Concours findByReference(String reference);

	public List<Concours> findAll();

	public int save(Concours concours);

	public List<Concours> findByAnnee(int annee);

	public int deleteByReference(String reference);

	public Concours update(Long id, String reference, int annee, Date dateOrale, Date dateEcrit,
			int nbreEtudiantAdmisOrale, int nbreEtudiantAdmisEcrit, int nbreEtudiantAdmis, String description);

	public Concours findConcoursByConfigConcourssNoteMin(double noteMin);

}
