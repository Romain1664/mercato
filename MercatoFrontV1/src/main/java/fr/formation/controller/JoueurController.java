package fr.formation.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import fr.formation.daoSpring.IDAOJoueur;
import fr.formation.model.Joueur;



@Controller
//@RequestMapping("/home") // Ajoute /home devant tous les mappings
public class JoueurController 
{

	@Autowired
	private IDAOJoueur daoJoueur;
	
	@GetMapping("/Menu_Joueur")
	public String findAll()
	{
		return "joueur";
	}
	

	
	@PostMapping("/joueur")
	public String add(Joueur joueur) 
	{
		this.daoJoueur.save(joueur);
		
		return "redirect:/joueur";
	}
	
	@GetMapping("/joueur/{id}")
	public String findById(@PathVariable int id, Model model) 
	{
		model.addAttribute("joueur", this.daoJoueur.findById(id).orElse(new Joueur()));
		
		return "joueur";
	}
	
	@GetMapping("/joueur/{id}/supprimer")
	public String deleteById(@PathVariable int id)
	{
		try 
		{
			this.daoJoueur.deleteById(id);
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return "redirect:/joueur";
	}
	
	@GetMapping("/joueurs")
	public String findAll(Model model) 
	{
		model.addAttribute("joueurs", this.daoJoueur.findAll());
		
		return "joueurs";
	}
	
	@ModelAttribute("joueurs")
	public List<Joueur> joueurs() {
		return this.daoJoueur.findAll();
	}
}
	
