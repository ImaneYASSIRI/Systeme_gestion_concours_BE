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

import com.fstg.bean.Etudiant;
import com.fstg.bean.Inscription;
import com.fstg.bean.TypeDiplome;
import com.fstg.bean.User;
import com.fstg.service.facade.EtudiantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cet Endpoint permet de gérer les demandes du document")
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("pfe-concours-v3-api/etudiant")
public class EtudiantRest {

	@Autowired
	private EtudiantService etudiantService;

	@ApiOperation("Cette méthode permet de retouner un Etudiant à partir de son CNE")
	@GetMapping("cne/{cne}")
	public Etudiant findByCne(@PathVariable String cne) {
		return etudiantService.findByCne(cne);
	}

	/*
	 * @ApiOperation("Cette méthode permet de sauvegarder un Etudiant")
	 * 
	 * @PostMapping("/") public int save(@RequestBody Etudiant etudiant) { return
	 * etudiantService.save(etudiant); }
	 */

	@ApiOperation("Cette méthode permet de sauvegarder un Etudiant")
	@PostMapping("/")
	public int saveEtudiant(@RequestBody Etudiant etudiant) {
		return etudiantService.saveEtudiant(etudiant);
	}

	@ApiOperation("Cette méthode permet de lister tous les Etudiants")
	@GetMapping("/")
	public List<Etudiant> findAll() {
		return etudiantService.findAll();
	}

	@ApiOperation("Cette méthode permet de retourner une liste d'Etudiants à partir de la référence d'un Concours d'une Inscription")
	@GetMapping("reference/{reference}")
	public List<Etudiant> findByInscriptionsConcoursReference(@PathVariable String reference) {
		return etudiantService.findByInscriptionsConcoursReference(reference);
	}

	@ApiOperation("Cette méthode permet de supprimer des Etudiants à partir du libellé d'un TypeDiplome")
	@DeleteMapping("/type-diplome/libelle/{libelle}")
	public int deleteByTypeDiplomeLibelle(@PathVariable String libelle) {
		return etudiantService.deleteByTypeDiplomeLibelle(libelle);
	}

	@ApiOperation("Cette méthode permet à l'Etudiant de se connecter")
	@PutMapping("/seconnecter")
	public int seConnecter(@RequestBody Etudiant etudiant) {
		return etudiantService.seConnecter(etudiant);
	}

	@ApiOperation("Cette méthode permet de sauvegarder un Etudiant")
	@PostMapping("/registrer")
	public int register(@RequestBody Etudiant etudiant) {
		return etudiantService.register(etudiant);
	}

	@ApiOperation("Cette méthode permet de modifier un Etudiant")
	@PutMapping("/id/{id}/cne/{cne}/nom/{nom}/prenom/{prenom}/email/{email}")
	public Etudiant update(@PathVariable Long id, @PathVariable String cne, @PathVariable String nom,
			@PathVariable String prenom, @PathVariable String email) {
		return etudiantService.update(id, cne, nom, prenom, email);
	}

	@PutMapping("/id/{id}/cin/{cin}/cne/{cne}/nom/{nom}/prenom/{prenom}/email/{email}")
	public Etudiant updateEtudiant(@PathVariable Long id, @PathVariable String cin, @PathVariable String cne,
			@PathVariable String nom, @PathVariable String prenom, @PathVariable String email,
			@RequestBody TypeDiplome typeDiplome) {
		return etudiantService.updateEtudiant(id, cin, cne, nom, prenom, email, typeDiplome, etudiantService.findByCne(cne).getInscriptions());
	}

	@PutMapping("/cne/{cne}")
	public Etudiant updateNew(@PathVariable String cne,@RequestBody Etudiant etudiant2) {
		return etudiantService.updateNew(cne, etudiant2);
	}

	@GetMapping("/seuil/{seuil}")
	public List<Etudiant> findByMoyenne(@PathVariable double seuil) {
		return etudiantService.findByMoyenne(seuil);
	}

	@GetMapping("/type-diplome/libelle/{libelle}")
	public List<Etudiant> findByTypeDiplomeLibelle(@PathVariable String libelle) {
		return etudiantService.findByTypeDiplomeLibelle(libelle);
	}

	
}