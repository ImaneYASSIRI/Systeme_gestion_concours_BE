package com.fstg.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.bean.Etudiant;
import com.fstg.bean.Filiere;
import com.fstg.bean.TypeDiplome;
import com.fstg.bean.User;
import com.fstg.service.facade.TypeDiplomeService;
import com.fstg.service.facade.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cet Endpoint permet de gérer les demandes du document")
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("pfe-concours-v3-api/user")
public class UserRest {

	@Autowired
	private UserService userService;

	@ApiOperation("Cette méthode permet au User de se connecter")
	@PutMapping("/seconnecter")
	public int seConnecter(@RequestBody User user) {
		return userService.seConnecter(user);
	}

	@ApiOperation("Cette méthode permet de lister tous les Users")
	@GetMapping("/")
	public List<User> findAll() {
		return userService.findAll();
	}

	@PostMapping("/registrer")
	public int register(@RequestBody User user) {
		return userService.register(user);
	}
	
	@ApiOperation("Cette méthode permet de modifier un User")
	@PutMapping("/id/{id}/login/{login}/nom/{nom}/prenom/{prenom}/email/{email}")
	public User update(@PathVariable Long id, @PathVariable String login, @PathVariable String nom,
			@PathVariable String prenom, @PathVariable String email) {
		return userService.update(id, login, nom, prenom, email);
	}

}