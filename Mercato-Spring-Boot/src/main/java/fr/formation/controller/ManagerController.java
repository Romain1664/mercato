package fr.formation.controller;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.daoSpring.IDAOCompte;
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
	@Autowired
	private IDAOCompte daoCompte;
	
	@GetMapping("/menu_manager")
	public String accueilManger(HttpSession session,Model model, Authentication auth)
	{
		model.addAttribute("message",session.getAttribute("message"));
		session.removeAttribute("message");
		
		Compte compte = daoCompte.findByLogin(auth.getName());

		if (compte!=null)
		{
			session.setAttribute("id", compte.getId());
			session.setAttribute("login", compte.getLogin());
			session.setAttribute("typeAccount", "Manager");
			session.setAttribute("managerEquipe", daoEquipe.findByManager(compte.getId())== null ? "N" : "Y");
			
			return "menuManager";
		}
		else
		{
			return "accueil";
		}
	}
	
	
	
	@GetMapping("/menu_manager/liste_joueurs_equipe")
	public String afficherEquipe(HttpSession session, Model model) 
	{
		
		model.addAttribute("message",session.getAttribute("message"));
		session.removeAttribute("message");		
		
		Equipe eq = this.daoEquipe.findByManager((Integer)session.getAttribute("id"));
		
		List<Joueur> joueurs = this.daoJoueur.findByEquipe(eq.getId());
		model.addAttribute("joueurs", joueurs);
		
		return "joueursEquipe";
	}
	
	@GetMapping("/menu_manager/changer_prix/{id}/{prix}")
	public String changerPrix(@PathVariable int id, @PathVariable Double prix, HttpSession session) {
		
		Joueur j = daoJoueur.findById(id).get();
		
		j.setPrix(prix);
		
		daoJoueur.save(j);
		
		session.setAttribute("message","Le joueur a bien vu son prix changer !");
		
		return "redirect:/menu_manager/liste_joueurs_equipe";
	}
	
	
	
	@GetMapping("/menu_manager/acheter_joueurs")
	public String achatEquipe(HttpSession session, Model model) {

		Equipe eq = this.daoEquipe.findByManager((Integer)session.getAttribute("id"));
		double budget= eq.getBudget();
		
		List<Joueur> joueurs =this.daoJoueur.findByEquipe(1);
		model.addAttribute("joueurs", joueurs);
		model.addAttribute("budget", budget);
				
		model.addAttribute("error",session.getAttribute("error"));
		session.removeAttribute("error");
		
		model.addAttribute("valid",session.getAttribute("valid"));
		session.removeAttribute("valid");
		
		
		return "joueurAchat";
	}	
	
	
	@PostMapping("/menu_manager/achat_joueur")
	public String achat(@RequestParam(value="id") Integer id ,HttpSession session,Model model) {
		
		Equipe eq = this.daoEquipe.findByManager((Integer)session.getAttribute("id"));
		Joueur j = this.daoJoueur.findById(id).get();
		
		if (eq.getBudget()<j.getPrix())
		{
			session.setAttribute("error","Vous n'avez pas les bases... le budget pardon");
		}
			
		else
		{
			eq.setBudget(eq.getBudget()-j.getPrix());
			j.setId_equipe(eq.getId());
			
			this.daoJoueur.save(j);
			this.daoEquipe.save(eq);
			
			session.setAttribute("valid","Félicitation pour votre achat de votre nouveau champion : " + j.getNom() + " "+ j.getPrenom());
		}
		
		return "redirect:/menu_manager/acheter_joueurs";
	}
	
	
	
	@GetMapping("/menu_manager/vendre_joueurs")
	public String venteEquipe(HttpSession session, Model model) 
	{
		Equipe eq = this.daoEquipe.findByManager((Integer)session.getAttribute("id"));
		double budget= eq.getBudget();
		
		List<Joueur> joueurs =this.daoJoueur.findByEquipe(eq.getId());
		model.addAttribute("joueurs", joueurs);
		model.addAttribute("budget", budget);
		
		return "joueurVente";
	}
	
	@PostMapping("/menu_manager/vente_joueur")
	public String vente(@RequestParam(value="id") Integer id ,HttpSession session,Model model) {

		Equipe eq = this.daoEquipe.findByManager((Integer)session.getAttribute("id"));
		Joueur j = this.daoJoueur.findById(id).get();
		
		eq.setBudget(eq.getBudget()+j.getPrix());
		j.setId_equipe(1);
		double budget= eq.getBudget();
		
		this.daoJoueur.save(j);
		this.daoEquipe.save(eq);
		
		List<Joueur> joueurs =this.daoJoueur.findByEquipe(eq.getId());
		
		model.addAttribute("joueurs",joueurs);
		model.addAttribute("budget", budget);
		
		return "joueur-part";
	}
	
	
	
	@GetMapping("/menu_manager/gestion_budget")
	public String choixBudget(HttpSession session, Model model) {
		
		Equipe eq = this.daoEquipe.findByManager((Integer)session.getAttribute("id"));
		
		model.addAttribute("budget",eq.getBudget());
		
		return "gestionBudget";
	}
	
	@PostMapping("/menu_manager/gestion_budget")
	public String budget(@RequestParam(value="budget") Double budget, HttpSession session, Model model) {

		Equipe eq = this.daoEquipe.findByManager((Integer)session.getAttribute("id"));

		eq.setBudget(budget);
		
		this.daoEquipe.save(eq);
		
		session.setAttribute("message","Le budget a bien été changé !");
		
		return "redirect:/menu_manager";
	}
	
	
	
	@GetMapping("/menu_manager/creation_equipe")
	public String equipe() {
		
		return "creationEquipe";
	}
	
	@PostMapping("/menu_manager/creation_equipe")
	public String creationEequipe(@Valid @RequestParam(value="nom_equipe") String nom_equipe,@Valid @RequestParam(value="budget") Double budget, Model model, HttpSession session) {
		
		Equipe eq = this.daoEquipe.findByNomEquipe(nom_equipe);
		
		if (eq!=null)
		{
			model.addAttribute("errorEquipe","Ce nom d'équipe est déjà pris !");
			model.addAttribute("nom_equipe",nom_equipe);
			model.addAttribute("budget",budget);
			
			return "creationEquipe";
		}
		
		else
		{
			Equipe eq2 = new Equipe(nom_equipe, (Integer)session.getAttribute("id"),budget);
			
			this.daoEquipe.save(eq2);
			model.addAttribute("message","L'équipe a été créé avec succès !");
			session.setAttribute("managerEquipe", "Y");
			
			return "menu_manager";
		}
	}

	
}
	
