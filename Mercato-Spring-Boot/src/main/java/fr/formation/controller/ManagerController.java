package fr.formation.controller;


import java.util.List;

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
		return "menuManager";
	}
	
	
	@PostMapping("/Menu_Manager/gestionBudget")
	public String gesttionBudget(HttpSession session,Model model) 
	{
		Compte c = (Compte) session.getAttribute("compte");
		Equipe eq = this.daoEquipe.findById(c.getId()).get();

		model.addAttribute("equipe",eq);
		
		return "gestionBudget";
	}
	
	
	@PostMapping("/Menu_Manager/Achat_Joueur")
	public String achat(@RequestParam(value="id") Integer id ,HttpSession session,Model model) {
		
		Compte c = (Compte) session.getAttribute("compte");
		Equipe eq = this.daoEquipe.findByManager(c.getId());
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
		}
		
		return "redirect:/Acheter_Joueurs";
	}
	
	@PostMapping("/Menu_Manager/Vente_Joueur")
	public String vente(@RequestParam(value="id") Integer id ,HttpSession session,Model model) {

		Compte c = (Compte) session.getAttribute("compte");
		Equipe eq = this.daoEquipe.findByManager(c.getId());
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
	
	@GetMapping("/Menu_Manager/gestionBudget")
	public String choixBudget() {
		
		return "gestionBudget";
	}
	
	
	@PostMapping("/Menu_Manager/budget")
	public String budget(@RequestParam(value="budget") Double budget, HttpSession session,Model model) {

		Compte c = (Compte) session.getAttribute("compte");
		Equipe eq = this.daoEquipe.findByManager(c.getId());

		eq.setBudget(budget);
		
		this.daoEquipe.save(eq);
		
		session.setAttribute("message","Le budget a �t� chang� !");
		
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
			model.addAttribute("errorEquipe","Le nom d'�quipe est d�j� pris !");
			model.addAttribute("nom_equipe",nom_equipe);
			model.addAttribute("budget",budget);
			
			return "creationEquipe";
		}
		
		else
		{
			Compte c = (Compte) session.getAttribute("compte");
			Equipe eq2 = new Equipe(nom_equipe, c.getId(),budget);
			
			this.daoEquipe.save(eq2);
			model.addAttribute("message","L'�quipe a �t� cr�� avec succ�s !");
			session.setAttribute("managerEquipe", "Y");
			
			return "manager";
		}
	}
	
	
}
	
