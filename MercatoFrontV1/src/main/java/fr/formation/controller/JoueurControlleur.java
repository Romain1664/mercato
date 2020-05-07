package fr.formation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.daoSpring.IDAOJoueur;
import fr.formation.model.Compte;
import fr.formation.model.Joueur;


@Controller
public class JoueurControlleur {

	@Autowired
	private IDAOJoueur daoJoueur;
	
	
	@GetMapping("/Menu_Joueur")
	public String accueilJoueur(HttpSession session,Model model)
	{
		model.addAttribute("message",session.getAttribute("message"));
		session.removeAttribute("message");
		return "joueur";
	}
	
	
	@GetMapping("/Menu_Joueur/afficherStats")
	public String afficherStat(HttpSession session,Model model) 
	{
		Compte c = (Compte) session.getAttribute("compte");
		Joueur j = daoJoueur.findById(c.getId()).get();

		model.addAttribute("joueur",j);
		
		return "statsAfficher";
	}
	
	@GetMapping("/Menu_Joueur/modifierStats")
	public String modifierStat(HttpSession session,Model model) 
	{
		Compte c = (Compte) session.getAttribute("compte");
		Joueur j = daoJoueur.findById(c.getId()).get();
		
		model.addAttribute("joueur",j);
		
		return "statsModifier";
	}
	
	@PostMapping("/Menu_Joueur/ModificationStat")
	public String modificationStat(
			@RequestParam(value="tir") Integer tir,
			@RequestParam(value="precision") Integer precision,
			@RequestParam(value="acceleration") Integer acceleration,
			@RequestParam(value="puissance") Integer puissance,
			@RequestParam(value="tacle") Integer tacle,
			@RequestParam(value="marquage") Integer marquage,
			HttpSession session,Model model) 
	{
		Compte c = (Compte) session.getAttribute("compte");
		Joueur j = daoJoueur.findById(c.getId()).get();
		
		j.setTir(tir);
		j.setPrecision(precision);
		j.setAcceleration(acceleration);
		j.setPuissance(puissance);
		j.setTacle(tacle);
		j.setMarquage(marquage);
		
		daoJoueur.save(j);
		session.setAttribute("message", "Vos stats ont �t� modifi�es");
		
		return "redirect:/Menu_Joueur";
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
	
