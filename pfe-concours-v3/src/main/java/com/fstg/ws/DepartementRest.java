package com.fstg.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.bean.Departement;
import com.fstg.service.facade.DepartementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cet Endpoint permet de gérer les demandes du document")
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("pfe-concours-v3-api/departement")
public class DepartementRest {
	@Autowired
	private DepartementService departementService;

	@ApiOperation("Cette méthode permet de retouner un Département à partir de sa référence ")
	@GetMapping("/reference/{reference}")
	public Departement findByReference(@PathVariable String reference) {
		return departementService.findByReference(reference);
	}

	@ApiOperation("Cette méthode permet de lister tous les Départements")
	@GetMapping("/")
	public List<Departement> findAll() {
		return departementService.findAll();
	}
	
	@ApiOperation("Cette méthode permet de supprimer un Département à partir de sa référence")
	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return departementService.deleteByReference(reference);
	}

	@ApiOperation("Cette méthode permet de sauvegarder un Département")
	@PostMapping("/")
	public int save(@RequestBody Departement departement) {
		return departementService.save(departement);
	}

	@ApiOperation("Cette méthode permet de modifier un Département")
	@PutMapping("/id/{id}/nom/{nom}/reference/{reference}/description/{description}/chef/{chef}")
	public Departement update(@PathVariable Long id, @PathVariable String nom, @PathVariable String reference,
			@PathVariable String description, @PathVariable String chef) {
		return departementService.update(id, nom, reference, description, chef);
	}

}
