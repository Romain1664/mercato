package fr.formation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.daoSpring.IDAOCompte;
import fr.formation.daoSpring.IDAOJoueur;
import fr.formation.model.Compte;
import fr.formation.model.Joueur;


@Controller
public class JoueurControlleur {

	@Autowired
	private IDAOJoueur daoJoueur;
	@Autowired
	private IDAOCompte daoCompte;
	
	@GetMapping("/menu_joueur")
	public String accueilJoueur(HttpSession session,Model model, Authentication auth)
	{
		model.addAttribute("message",session.getAttribute("message"));
		session.removeAttribute("message");
		
		Compte compte = daoCompte.findByLogin(auth.getName());

		if (compte!=null)
		{
			session.setAttribute("id", compte.getId());
			session.setAttribute("login", compte.getLogin());
			session.setAttribute("typeAccount", "Joueur");
			System.out.println(daoJoueur.findById(compte.getId()));
			session.setAttribute("joueurInscrit", daoJoueur.findById(compte.getId()).isEmpty() ? "N" : "Y");
			
			return "menuJoueur";
		}
		else
		{
			return "accueil";
		}
	}
	
	@GetMapping("/menu_joueur/retraite")
	public String retraite(HttpSession session)
	{
		Joueur j = this.daoJoueur.findById((Integer) session.getAttribute("id")).get();
		
		this.daoJoueur.deleteById(j.getId());
		session.setAttribute("joueurInscrit", "N");
		
		return "redirect:/menu_joueur";
	}
	
	
	
	
	@GetMapping("/menu_joueur/joueur_inscription")
	public String debutCarriere()
	{
		System.out.println("test");
		return "entreeStat";
	}
	
	@PostMapping("/menu_joueur/joueur_inscription")
	public String ajoutJoueur(@ModelAttribute Joueur joueur, HttpSession session, Model model) {
		
		joueur.setId((Integer) session.getAttribute("id"));
		joueur.setId_equipe(1);
		
		System.out.println(joueur);
		
		this.daoJoueur.insert(joueur);
		
		session.setAttribute("joueurInscrit", "Y");
		session.setAttribute("message", "Votre profil a été ajouté dans notre BDD");
		
		return "redirect:/menu_joueur";
	}
	
	
	
	@GetMapping("/menu_joueur/afficher_stats")
	public String afficherStat(HttpSession session,Model model) 
	{
		Joueur j = this.daoJoueur.findById((Integer) session.getAttribute("id")).get();

		model.addAttribute("joueur",j);
		
		return "statsAfficher";
	}
	
	
	
	@GetMapping("/menu_joueur/modifier_stats")
	public String modifierStat(HttpSession session,Model model) 
	{
		Joueur j = this.daoJoueur.findById((Integer) session.getAttribute("id")).get();
		
		model.addAttribute("joueur",j);
		
		return "statsModifier";
	}
	
	@PostMapping("/menu_joueur/modification_stat")
	public String modificationStat(
			@RequestParam(value="tir") Integer tir,
			@RequestParam(value="precision") Integer precision,
			@RequestParam(value="acceleration") Integer acceleration,
			@RequestParam(value="puissance") Integer puissance,
			@RequestParam(value="tacle") Integer tacle,
			@RequestParam(value="marquage") Integer marquage,
			HttpSession session,Model model) 
	{
		Joueur j = this.daoJoueur.findById((Integer) session.getAttribute("id")).get();
		
		j.setTir(tir);
		j.setPrecision(precision);
		j.setAcceleration(acceleration);
		j.setPuissance(puissance);
		j.setTacle(tacle);
		j.setMarquage(marquage);
		
		this.daoJoueur.save(j);
		session.setAttribute("message", "Vos stats ont été modifiées");
		
		return "redirect:/menu_joueur";
	}


	
}
	
