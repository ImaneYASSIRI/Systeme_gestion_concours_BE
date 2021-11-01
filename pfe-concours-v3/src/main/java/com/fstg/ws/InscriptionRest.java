package com.fstg.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.bean.Concours;
import com.fstg.bean.Etudiant;
import com.fstg.bean.Inscription;
import com.fstg.service.facade.InscriptionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cet Endpoint permet de gérer les demandes du document")
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("pfe-concours-v3-api/inscription")
public class InscriptionRest {

	@Autowired
	private InscriptionService inscriptionService;

	@ApiOperation("Cette méthode permet de retourner une Inscription à partir de sa référence")
	@GetMapping("reference/{reference}")
	public Inscription findByReference(@PathVariable String reference) {
		return inscriptionService.findByReference(reference);
	}

	@ApiOperation("Cette méthode permet lister toutes les Inscriptions")
	@GetMapping("/")
	public List<Inscription> findAll() {
		return inscriptionService.findAll();
	}

	@ApiOperation("Cette méthode permet de retourner une liste d'Inscriptions à partir de la référence d'un Concours")
	@GetMapping("concours/reference/{reference}")
	public List<Inscription> findByConcoursReference(@PathVariable String reference) {
		return inscriptionService.findByConcoursReference(reference);
	}

	@ApiOperation("Cette méthode permet de retourner une liste d'Inscriptions à partir de la description d'un Concours")
	@GetMapping("concours/description/{description}")
	public List<Inscription> findByConcoursDescription(@PathVariable String description) {
		return inscriptionService.findByConcoursDescription(description);
	}

	@ApiOperation("Cette méthode permet de retourner une liste d'Inscriptions à partir de l'id d'un Concours")
	@GetMapping("concours/{id}")
	public List<Inscription> findByConcoursId(@PathVariable Long id) {
		return inscriptionService.findByConcoursId(id);
	}

	@ApiOperation("Cette méthode permet de sauvegarder une Inscription")
	@PostMapping("/")
	public int save(@RequestBody Inscription inscription) {
		return inscriptionService.save(inscription);
	}

	@ApiOperation("Cette méthode permet de sauvegarder un Concours avec ses Inscriptions")
	public int save(Concours concours, List<Inscription> inscriptions) {
		return inscriptionService.save(concours, inscriptions);
	}

	@ApiOperation("Cette méthode permet de sauvegarder un Etudiant avec ses Inscriptions")
	public int save(@RequestBody Etudiant etudiant) {
		return inscriptionService.save(etudiant, etudiant.getInscriptions());
	}

}
