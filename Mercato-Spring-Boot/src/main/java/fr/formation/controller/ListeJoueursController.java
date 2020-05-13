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
		
		List<Joueur> joueurs = this.daoJoueur.findAll();
		
		for (Joueur j : joueurs)
		{
			Equipe eq= this.daoEquipe.findById(j.getId_equipe()).get();
			j.setNom_equipe(eq.getNom_equipe());
		}
		
		model.addAttribute("joueurs",joueurs);
		
		return "joueursListe";
	}
	
	@GetMapping("/Menu_Manager/Liste_Joueurs_Equipe")
	public String afficherEquipe(HttpSession session, Model model) 
	{
		Compte c = (Compte) session.getAttribute("compte");
		Equipe eq = this.daoEquipe.findByManager(c.getId());
		
		List<Joueur> joueurs = this.daoJoueur.findByEquipe(eq.getId());
		model.addAttribute("joueurs", joueurs);
		
		return "joueursEquipe";
	}
	
	@GetMapping("/Menu_Manager/Acheter_Joueurs")
	public String achatEquipe(HttpSession session, Model model) 
	{
		
		Compte c = (Compte) session.getAttribute("compte");
		Equipe eq = this.daoEquipe.findByManager(c.getId());
		double budget= eq.getBudget();
		
		List<Joueur> joueurs =this.daoJoueur.findByEquipe(1);
		model.addAttribute("joueurs", joueurs);
		model.addAttribute("budget", budget);
				
		model.addAttribute("error",session.getAttribute("error"));
		session.removeAttribute("error");
		
		return "joueurAchat";
	}	
	
	@GetMapping("/Menu_Manager/Vendre_Joueurs")
	public String venteEquipe(HttpSession session, Model model) 
	{
		Compte c = (Compte) session.getAttribute("compte");
		Equipe eq = this.daoEquipe.findByManager(c.getId());
		double budget= eq.getBudget();
		
		List<Joueur> joueurs =this.daoJoueur.findByEquipe(eq.getId());
		model.addAttribute("joueurs", joueurs);
		model.addAttribute("budget", budget);
		
		return "joueurVente";
	}	
	

}
