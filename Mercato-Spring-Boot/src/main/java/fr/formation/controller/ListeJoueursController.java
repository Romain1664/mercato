package fr.formation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.daoSpring.IDAOEquipe;
import fr.formation.daoSpring.IDAOJoueur;
import fr.formation.model.Compte;
import fr.formation.model.Equipe;
import fr.formation.model.Joueur;

@Controller
public class ListeJoueursController {

	@Autowired
	private IDAOJoueur daoJoueur;
	@Autowired
	private IDAOEquipe daoEquipe;
	
	@GetMapping("/liste_joueurs")
	public String listeJoueurs(Model model) {
		
		List<Joueur> joueurs = this.daoJoueur.findAll();
		
		for (Joueur j : joueurs)
		{
			Equipe eq= this.daoEquipe.findById(j.getId_equipe()).get();
			j.setNom_equipe(eq.getNom_equipe());
		}
		
		model.addAttribute("joueurs",joueurs);
		
		return "joueursListe";
	}


}
