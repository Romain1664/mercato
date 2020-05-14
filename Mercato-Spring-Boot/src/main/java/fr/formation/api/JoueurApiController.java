package fr.formation.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.daoSpring.IDAOJoueur;
import fr.formation.exception.JoueurValidationException;
import fr.formation.model.Joueur;

@RestController
public class JoueurApiController {

	@Autowired
	private IDAOJoueur daoJoueur;

	@GetMapping
	public List <Joueur> findAll() {
		return this.daoJoueur.findAll();

	}

	@GetMapping("/{id}")
	public Joueur findById(@PathVariable int id) {
		return this.daoJoueur.findById(id).orElse(new Joueur());

	}

	@PostMapping
	public Joueur add(@Valid @RequestBody Joueur joueur, BindingResult result) {
		if (result.hasErrors()) {
			throw new JoueurValidationException();
		}

		this.daoJoueur.save(joueur)	;
		return joueur;
	}

	@PutMapping("/{id}")
	public Joueur update(@PathVariable  int id, @RequestBody Joueur joueur) {
		joueur.setId(id);
		this.daoJoueur.save(joueur);
		return joueur;
	}

	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) {
		try {
			this.daoJoueur.deleteById(id);
			return true;
		}
		catch(Exception e) {
			return false;
		}







	}
}