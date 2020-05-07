package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.daoSpring.IDAOJoueur;
import fr.formation.model.Joueur;

@Controller
public class ListeJoueursController {

	@Autowired
	private IDAOJoueur daoJoueur;
	
	@GetMapping("/Liste_Joueurs")
	public String listeJoueurs() {
		
		List<Joueur> joueurs = daoJoueur.findAll();
		
		return "joueurs";
	}
	
}
