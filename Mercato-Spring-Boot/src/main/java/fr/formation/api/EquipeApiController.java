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

import fr.formation.daoSpring.IDAOEquipe;
import fr.formation.exception.EquipeValidationException;
import fr.formation.model.Equipe;

//@RestController
public class EquipeApiController {

	@Autowired
	private IDAOEquipe daoEquipe;

	@GetMapping
	public List <Equipe> findAll() {
		return this.daoEquipe.findAll();

	}

	@GetMapping("/{id}")
	public Equipe findById(@PathVariable int id) {
		return this.daoEquipe.findById(id).orElse(new Equipe());

	}

	@PostMapping
	public Equipe add(@Valid @RequestBody Equipe equipe, BindingResult result) {
		if (result.hasErrors()) {
			throw new EquipeValidationException();
		}

		this.daoEquipe.save(equipe)	;
		return equipe;
	}

	@PutMapping("/{id}")
	public Equipe update(@PathVariable  int id, @RequestBody Equipe equipe) {
		equipe.setId(id);
		this.daoEquipe.save(equipe);
		return equipe;
	}

	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) {
		try {
			this.daoEquipe.deleteById(id);
			return true;
		}
		catch(Exception e) {
			return false;
		}







	}
}