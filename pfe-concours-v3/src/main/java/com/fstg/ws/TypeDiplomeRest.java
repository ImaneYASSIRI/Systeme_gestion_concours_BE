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

import com.fstg.bean.TypeDiplome;
import com.fstg.service.facade.TypeDiplomeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cet Endpoint permet de gérer les demandes du document")
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("pfe-concours-v3-api/type-diplome")
public class TypeDiplomeRest {

	@Autowired
	private TypeDiplomeService typeDiplomeService;

	@ApiOperation("Cette méthode permet de retourner un TypeDiplome à partir de son libellé")
	@GetMapping("libelle/{libelle}")
	public TypeDiplome findByLibelle(@PathVariable String libelle) {
		return typeDiplomeService.findByLibelle(libelle);
	}

	@ApiOperation("Cette méthode permet de lister tous les TypeDiplomes")
	@GetMapping("/")
	public List<TypeDiplome> findAll() {
		return typeDiplomeService.findAll();
	}

	@ApiOperation("Cette méthode permet de sauvegarder un TypeDiplome")
	@PostMapping("/")
	public int save(@RequestBody TypeDiplome typeDiplome) {
		return typeDiplomeService.save(typeDiplome);
	}

	@ApiOperation("Cette méthode permet de supprimer un TypeDiplome à partir de son libellé")
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return typeDiplomeService.deleteByLibelle(libelle);
	}

	@ApiOperation("Cette méthode permet de modifier un TypeDiplome")
	@PutMapping("/id/{id}/libelle/{libelle}/description/{description}")
	public TypeDiplome update(@PathVariable Long id, @PathVariable String libelle, @PathVariable String description) {
		return typeDiplomeService.update(id, libelle, description);
	}

}