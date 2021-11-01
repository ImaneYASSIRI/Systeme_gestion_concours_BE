package com.fstg.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.bean.Departement;
import com.fstg.bean.Filiere;
import com.fstg.service.facade.FiliereService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cet Endpoint permet de gérer les demandes du document")
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("pfe-concours-v3-api/filiere")
public class FiliereRest {
	@Autowired
	private FiliereService filiereService;

	@ApiOperation("Cette méthode permet de retourner une Filière à partir de son libellé")
	@GetMapping("/libelle/{libelle}")
	public Filiere findByLibelle(@PathVariable String reference) {
		return filiereService.findByLibelle(reference);
	}

	@ApiOperation("Cette méthode permet de retourner une liste de Filières à partir de la référence d'un Département")
	@GetMapping("/departement/reference/{reference}")
	public List<Filiere> findByDepartementRefrence(@PathVariable String reference) {
		return filiereService.findByDepartementRefrence(reference);
	}

	@ApiOperation("Cette méthode permet de supprimer des Filières à partir de la référence d'un Département")
	public int deleteByDepartementReference(@PathVariable String reference) {
		return filiereService.deleteByDepartementReference(reference);
	}

	@ApiOperation("Cette méthode permet de supprimer une Filière à partir de son libellé")
	public int deleteByLibelle(@PathVariable String libelle) {
		return filiereService.deleteByLibelle(libelle);
	}

	@ApiOperation("Cette méthode permet de lister toutes les Filières")
	@GetMapping("/")
	public List<Filiere> findAll() {
		return filiereService.findAll();
	}

	@ApiOperation("Cette méthode permet de sauvegarder un Département avec ses Filières")
	public int save(Departement departement, List<Filiere> filieres) {
		return filiereService.save(departement, filieres);
	}

	@ApiOperation("Cette méthode permet de supprimer une Filière à partir de son id")
	@DeleteMapping("/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return filiereService.deleteById(id);
	}

	@ApiOperation("Cette méthode permet de modifier une Filière")
	@PutMapping("/id/{id}/libelle/{libelle}/description/{description}/responsable/{responsable}")
	public Filiere update(@PathVariable Long id, @PathVariable String libelle, @PathVariable String description,
			@PathVariable String responsable) {
		return filiereService.update(id, libelle, description, responsable);
	}

}