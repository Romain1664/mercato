package fr.formation.controller;


import java.lang.module.FindException;

import javax.servlet.http.HttpSession;

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
public class ManagerController 
{

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
		Equipe eq = daoEquipe.findById(c.getId()).get();

		model.addAttribute("equipe",eq);
		
		return "gestionBudget";
	}
	
	
	@PostMapping("/Achat_Joueur")
	public String achat(@RequestParam(value="id") Integer id ,HttpSession session,Model model) {
		
		Compte c = (Compte) session.getAttribute("compte");
		Equipe eq = daoEquipe.findByManager(c.getId());
		Joueur j = daoJoueur.findById(id).get();
		
		eq.setBudget(eq.getBudget()-j.getPrix());
		j.setId_equipe(eq.getId());
		
		daoJoueur.save(j);
		daoEquipe.save(eq);
		
		session.setAttribute("message","Votre achat fut un succès");
		
		return "redirect:/Menu_Manager";
	}
	
	@PostMapping("/Vente_Joueur")
	public String vente(@RequestParam(value="id") Integer id ,HttpSession session,Model model) {

		Compte c = (Compte) session.getAttribute("compte");
		Equipe eq = daoEquipe.findByManager(c.getId());
		Joueur j = daoJoueur.findById(id).get();
		
		eq.setBudget(eq.getBudget()+j.getPrix());
		j.setId_equipe(1);
		
		daoJoueur.save(j);
		daoEquipe.save(eq);
		
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
		Equipe eq = daoEquipe.findByManager(c.getId());

		eq.setBudget(budget);
		
		daoEquipe.save(eq);
		
		session.setAttribute("message","Le budget a été changé !");
		
		return "redirect:/Menu_Manager";
	}
	
	@GetMapping("/Menu_Manager/Creation_Equipe")
	public String equipe(Model model, HttpSession session) {
		
		model.addAttribute("message",session.getAttribute("message"));
		session.removeAttribute("message");
		return "";
	}
	
}
	
