package fr.formation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.daoSpring.IDAOJoueur;
import fr.formation.model.Compte;
import fr.formation.model.Joueur;


@Controller
public class JoueurControlleur {

	@Autowired
	private IDAOJoueur daoJoueur;
	
	@GetMapping("/Menu_Joueur")
	public String accueilJoueur()
	{
		return "joueur";
	}
	
	
	@GetMapping("/joueur/afficherStats")
	public String afficherStat(HttpSession session,Model model) 
	{
		Compte c = (Compte) session.getAttribute("compte");
		Joueur j = daoJoueur.findById(c.getId()).get();

		model.addAttribute("joueur",j);
		
		return "statAfficher";
	}
	
	@GetMapping("/joueur/modifierStats")
	public String modifierStat(HttpSession session,Model model) 
	{
		Compte c = (Compte) session.getAttribute("compte");
		Joueur j = daoJoueur.findById(c.getId()).get();
		
		model.addAttribute("joueur",j);
		
		return "statModifier";
	}
	
	@GetMapping("/joueur/retraite")
	public String deleteById(HttpSession session)
	{
		Compte c = (Compte) session.getAttribute("compte");
		Joueur j = daoJoueur.findById(c.getId()).get();
		
		this.daoJoueur.deleteById(j.getId());
		session.setAttribute("joueurInscrit", "N");
		
		return "redirect:/joueur";
	}

	
}
	
