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

import fr.formation.daoSpring.IDAOCompte;
import fr.formation.exception.CompteValidationException;
import fr.formation.model.Compte;

//@RestController
public class CompteApiController {

	@Autowired
	private IDAOCompte daoCompte;

	@GetMapping
	public List <Compte> findAll() {
		return this.daoCompte.findAll();

	}

	@GetMapping("/{id}")
	public Compte findById(@PathVariable int id) {
		return this.daoCompte.findById(id).orElse(new Compte());

	}

	@PostMapping
	public Compte add(@Valid @RequestBody Compte compte, BindingResult result) {
		if (result.hasErrors()) {
			throw new CompteValidationException();
		}

		this.daoCompte.save(compte)	;
		return compte;
	}

	@PutMapping("/{id}")
	public Compte update(@PathVariable  int id, @RequestBody Compte compte) {
		compte.setId(id);
		this.daoCompte.save(compte);
		return compte;
	}

	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) {
		try {
			this.daoCompte.deleteById(id);
			return true;
		}
		catch(Exception e) {
			return false;
		}







	}
}