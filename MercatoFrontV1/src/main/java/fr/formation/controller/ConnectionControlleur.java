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
	
	@GetMapping("/deconnection")
	public String deconnection(HttpSession session) {
		
		session.removeAttribute("compte");
		session.removeAttribute("typeAccount");
		if (session.getAttribute("joueurInscrit")!=null) {session.removeAttribute("joueurInscrit");}
		if (session.getAttribute("managerEquipe")!=null) {session.removeAttribute("managerEquipe");}
		
		return "redirect:/accueil";
	}
	
	
	@PostMapping("/connection")
	public String connection(@RequestParam(value="login") String login, @RequestParam(value="password") String password, Model model, HttpSession session) {
	
		Compte c = daoCompte.checkConnect(login, password);

		if (c==null) 
		{
			model.addAttribute("login", login);
			model.addAttribute("error", "Le login/password est incorrect");
			System.out.println("Mauvaise connection");
			return "accueil";
		}
		
		else if(c.getType().equals("joueur"))
		{
			session.setAttribute("compte", c);
			session.setAttribute("typeAccount", "Joueur");
			
			Optional<Joueur> j = daoJoueur.findById(c.getId());
			
			if (!j.isPresent()) 
			{
				session.setAttribute("joueurInscrit", "N");
			}
			else 
			{
				session.setAttribute("joueurInscrit", "Y");
			}

			System.out.println("Connection Joueur");
			return "redirect:/Menu_Joueur";
		}
		else if (c.getType().equals("manager"))
		{
			session.setAttribute("compte", c);
			session.setAttribute("typeAccount", "Manager");

			Equipe eq = daoEquipe.findByManager(c.getId());
			
			if (eq == null) 
			{
				session.setAttribute("managerEquipe", "N");
			}
			else 
			{
				session.setAttribute("managerEquipe", "Y");
			}

			System.out.println("Connection Manager");
			return "redirect:/Menu_Manager";
		}
		
		return null;
	}
	
	
}
