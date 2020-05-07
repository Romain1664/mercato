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
	
	@GetMapping("/Liste_Joueurs")
	public String listeJoueurs(Model model) {
		
		List<Joueur> joueurs = daoJoueur.findAll();
		model.addAttribute("joueurs",joueurs);
		
		return "joueurs";
	}
	
	@GetMapping("/Liste_Joueurs_Equipe")
	public String afficherEquipe(HttpSession session, Model model) 
	{
		Compte c = (Compte) session.getAttribute("compte");
		Equipe eq = this.daoEquipe.findByManager(c.getId());
		
		List<Joueur> joueurs =daoJoueur.findByEquipe(eq.getId());
		model.addAttribute("joueurs", joueurs);
		
		return "joueursEquipe";
	}
	
	
	
	
	
	
	
	
}
