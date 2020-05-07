package fr.formation.controller;


import java.util.Optional;

import javax.servlet.http.HttpSession;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.daoSpring.IDAOCompte;
import fr.formation.daoSpring.IDAOEquipe;
import fr.formation.daoSpring.IDAOJoueur;
import fr.formation.model.Compte;
import fr.formation.model.Equipe;
import fr.formation.model.Joueur;
import fr.formation.model.Manager;




@Controller
public class ManagerController 
{

	@Autowired
	private IDAOEquipe daoEquipe; // A CREER UNE IDAO MANAGER
	
	@GetMapping("/Menu_Manager")
	public String accueilJoueur(HttpSession session,Model model)
	{
		model.addAttribute("mess",session.getAttribute("mess"));
		session.removeAttribute("mess");
		return "manager";
	}
	
	
	
	@PostMapping("/Menu_Manager/gestionBudget")
	public String gesttionBudget(HttpSession session,Model model) 
	{
		Compte c = (Compte) session.getAttribute("compte");
		Equipe e = daoEquipe.findById(c.getId()).get();

		model.addAttribute("equipe",e);
		
		return "gestionBudget";
	}
	
	@GetMapping("/Menu_Manager/equipe")
	public String afficherEquipe(HttpSession session, Model model) 
	{
		Compte c = (Compte) session.getAttribute("compte");
		Equipe e = daoEquipe.findById(c.getId()).get();

		model.addAttribute("equipe",e);
		return "joueurEquipe";
	}
	
//	@GetMapping("/equipe/{id}")
//	public String findById(@PathVariable int id, Model model) 
//	{
//		model.addAttribute("equipe", this.daoEquipe.
//				findById(id).orElse(new Manager()));
//		// Je ne suis pas sur de ce truc là!! 
//		return "manager";
//	}
		
//	@PostMapping("/achatJoueur")
//	public String add(@Valid @ModelAttribute Joueur joueur, BindingResult result, Model model)
//	{
//		if (result.hasErrors())
//		{
//			return "joueurs";
//		}
//		
//		this.daoJoueur.save(joueur);
//		
//		return "redirect:/achatJoueur";
//	}
//	
//	@GetMapping("/venteJouer/{id}/supprimer")
//	public String deleteById(@PathVariable int id) 
//	{
//		try 
//		{
//			this.daoJoueur.deleteById(id);
//		}
//		
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		
//		return "redirect:/venteJoueur";
//	}
}
	
