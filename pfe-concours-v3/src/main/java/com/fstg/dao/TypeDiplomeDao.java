package com.fstg.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.bean.TypeDiplome;

@Repository
public interface TypeDiplomeDao extends JpaRepository<TypeDiplome, Long> {

	public TypeDiplome findByLibelle(String libelle);

	public int deleteByLibelle(String libelle);

}
