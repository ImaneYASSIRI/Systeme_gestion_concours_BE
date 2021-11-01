package com.fstg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.bean.Departement;

@Repository
public interface DepartementDao extends JpaRepository<Departement, Long> {
	public Departement findByReference(String reference);

	public int deleteByReference(String reference);

}