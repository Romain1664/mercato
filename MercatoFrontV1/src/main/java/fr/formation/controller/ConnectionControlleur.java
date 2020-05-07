package fr.formation.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.daoSpring.IDAOCompte;
import fr.formation.daoSpring.IDAOEquipe;
import fr.formation.daoSpring.IDAOJoueur;
import fr.formation.model.Compte;
import fr.formation.model.Equipe;
import fr.formation.model.Joueur;

@Controller
public class ConnectionControlleur {

	@Autowired
	private IDAOCompte daoCompte;
	@Autowired
	private IDAOJoueur daoJoueur;
	@Autowired
	private IDAOEquipe daoEquipe;	
	
	@GetMapping({"/","/accueil","/connection"})
	public String accueilInscription(HttpSession session, Model model) {
		
		model.addAttribute("message",session.getAttribute("message"));
		session.removeAttribute("message");
		return "accueil";
	}
	
	
	@PostMapping("/connection")
	public String connection(@RequestParam(value="login") String login, @RequestParam(value="password") String password, Model model) {
	
		Compte c = daoCompte.checkConnect(login, password);
		model.addAttribute("login", login);
		
		if (c==null) 
		{
			model.addAttribute("error", "Le login/password est incorrect");
			System.out.println("Mauvaise connection");
			return "accueil";
		}
		
		else if(c.getType().equals("joueur"))
		{
			model.addAttribute("compte", c);
			model.addAttribute("typeAccount", "Joueur");
			
			Optional<Joueur> j = daoJoueur.findById(c.getId());
			
			if (!j.isPresent()) 
			{
				model.addAttribute("joueurInscrit", "N");
			}
			else 
			{
				model.addAttribute("joueurInscrit", "Y");
			}

			System.out.println("Connection Joueur");
			return "redirect:/Menu_Joueur";
		}
		else if (c.getType().equals("manager"))
		{
			model.addAttribute("compte", c);
			model.addAttribute("typeAccount", "Manager");

			Equipe eq = daoEquipe.findByManager(c.getId());
			
			if (eq == null) 
			{
				model.addAttribute("managerEquipe", "N");
			}
			else 
			{
				model.addAttribute("managerEquipe", "Y");
			}

			System.out.println("Connection Manager");
			return "redirect:/Menu_Manager";
		}
		
		return null;
	}
	
	
}
