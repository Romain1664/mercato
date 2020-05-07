package fr.formation.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.daoSpring.IDAOEquipe;
import fr.formation.daoSpring.IDAOJoueur;
import fr.formation.model.Compte;
import fr.formation.model.Equipe;
import fr.formation.model.Joueur;

@Controller
public class ManagerController {

	@Autowired
	private IDAOEquipe daoEquipe;
	@Autowired
	private IDAOJoueur daoJoueur;
	
	@GetMapping("/Menu_Manager")
	public String accueilJoueur(HttpSession session,Model model)
	{
		model.addAttribute("message",session.getAttribute("message"));
		session.removeAttribute("message");
		return "manager";
	}
	
	
	@PostMapping("/Menu_Manager/gestionBudget")
	public String gesttionBudget(HttpSession session,Model model) 
	{
		Compte c = (Compte) session.getAttribute("compte");
		Equipe eq = this.daoEquipe.findById(c.getId()).get();

		model.addAttribute("equipe",eq);
		
		return "gestionBudget";
	}
	
	
	@PostMapping("/Achat_Joueur")
	public String achat(@RequestParam(value="id") Integer id ,HttpSession session,Model model) {
		
		Compte c = (Compte) session.getAttribute("compte");
		Equipe eq = this.daoEquipe.findByManager(c.getId());
		Joueur j = this.daoJoueur.findById(id).get();
		
		eq.setBudget(eq.getBudget()-j.getPrix());
		j.setId_equipe(eq.getId());
		
		this.daoJoueur.save(j);
		this.daoEquipe.save(eq);
		
		session.setAttribute("message","Votre achat fut un succès");
		
		return "redirect:/Menu_Manager";
	}
	
	@PostMapping("/Vente_Joueur")
	public String vente(@RequestParam(value="id") Integer id ,HttpSession session,Model model) {

		Compte c = (Compte) session.getAttribute("compte");
		Equipe eq = this.daoEquipe.findByManager(c.getId());
		Joueur j = this.daoJoueur.findById(id).get();
		
		eq.setBudget(eq.getBudget()+j.getPrix());
		j.setId_equipe(1);
		
		this.daoJoueur.save(j);
		this.daoEquipe.save(eq);
		
		session.setAttribute("message","Votre vente fut un succès");
		
		return "redirect:/Menu_Manager";
	}
	
	@GetMapping("/Menu_Manager/gestionBudget")
	public String choixBudget() {
		
		return "gestionBudget";
	}
	
	
	@PostMapping("/budget")
	public String budget(@RequestParam(value="budget") Double budget, HttpSession session,Model model) {

		Compte c = (Compte) session.getAttribute("compte");
		Equipe eq = this.daoEquipe.findByManager(c.getId());

		eq.setBudget(budget);
		
		this.daoEquipe.save(eq);
		
		session.setAttribute("message","Le budget a été changé !");
		
		return "redirect:/Menu_Manager";
	}
	
	@GetMapping("/Menu_Manager/Creation_Equipe")
	public String equipe() {
		
		return "creationEquipe";
	}
	
	
	@PostMapping("/Menu_Manager/Creation_Equipe")
	public String creationEequipe(@Valid @RequestParam(value="nom_equipe") String nom_equipe,@Valid @RequestParam(value="budget") Double budget, Model model, HttpSession session) {
		
		Equipe eq = this.daoEquipe.findByNomEquipe(nom_equipe);
		
		if (eq!=null)
		{
			model.addAttribute("errorEquipe","Le nom d'équipe est déjà pris !");
			model.addAttribute("nom_equipe",nom_equipe);
			model.addAttribute("budget",budget);
			
			return "creationEquipe";
		}
		
		else
		{
			Compte c = (Compte) session.getAttribute("compte");
			Equipe eq2 = new Equipe(nom_equipe, c.getId(),budget);
			
			this.daoEquipe.save(eq2);
			model.addAttribute("message","L'équipe a été créé avec succès !");
			session.setAttribute("managerEquipe", "Y");
			
			return "manager";
		}
	}
	
	
}
	
