package com.fstg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.bean.Concours;

@Repository
public interface ConcoursDao extends JpaRepository<Concours, Long> {

	public Concours findByReference(String reference);

	public List<Concours> findByAnnee(int annee);

	public int deleteByReference(String reference);
	
	public Concours findConcoursByConfigConcourssNoteMin(double noteMin);

}
