package fr.formation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.daoSpring.IDAOCompte;
import fr.formation.daoSpring.IDAOEquipe;
import fr.formation.model.Compte;
import fr.formation.model.Equipe;

@Controller
public class InscriptionController {

	@Autowired
	private IDAOCompte daoCompte;
	@Autowired
	private IDAOEquipe daoEquipe;
	
	@GetMapping("/inscription")
	public String accueilInscription(Model model) {
		return "inscription";
	}
	
	@PostMapping("/inscription")
	public String inscription(@ModelAttribute Compte compte, @RequestParam(required=false, value="nom_equipe") String nom_equipe, @RequestParam(required=false, value="budget") Double budget, @RequestParam(value="choix") String choix, @RequestParam(value="type") String type, HttpSession session, Model model) {
		
		Compte c=this.daoCompte.findByLogin(compte.getLogin());
		boolean okEquipe = false;
		
		model.addAttribute("login",compte.getLogin());
		model.addAttribute("type",type);
		model.addAttribute("choix",choix);
		model.addAttribute("nom_equipe",nom_equipe);
		model.addAttribute("budget",budget);
		
		if (c!=null)
		{
			model.addAttribute("errorLogin","Ce login existe déjà");
			return "inscription";
		}
		
		if ( (!compte.getType().equals("joueur")) && (!compte.getType().equals("manager")) )
		{
			model.addAttribute("errorType","Choisissez un type de compte VALIDE !");
			return "inscription";
		}
		
		if (compte.getType().equals("manager") && choix.equals("oui"))
		{
			if (nom_equipe==null || nom_equipe.equals(""))
			{
				model.addAttribute("errorEquipe","Veuillez rentrer un nom d'équipe !");
				return "inscription";
			}
			
			Equipe eq = this.daoEquipe.findByNomEquipe(nom_equipe);
			
			if (eq!=null)
			{
				model.addAttribute("errorEquipe","Le nom d'équipe est déjà pris !");
				return "inscription";
			}
			
			Equipe eq2 = new Equipe(nom_equipe,compte.getId(),budget);
			
			this.daoEquipe.save(eq2);
			okEquipe = true;
		}
		
		this.daoCompte.save(compte);
		
		session.setAttribute("message", okEquipe ? "Votre compte et votre équipe ont bien été créés" : "Votre compte a bien été créé" );
		return "redirect:/accueil";
	}
	
	@GetMapping("/reset_password")
	public String accueilReset(Model model) {
		return "reset";
	}	
	
	@PostMapping("/reset_password")
	public String resetPassword(@RequestParam(value="login") String login, @RequestParam(value="password") String password, HttpSession session, Model model) {
		
		Compte c = this.daoCompte.findByLogin(login);
		
		if (c==null)
		{
			model.addAttribute("errorLogin", "Ce login n'est associé à aucun compte");
			return "reset";
		}
		
		c.setPassword(password);
		this.daoCompte.save(c);
		
		session.setAttribute("message","Votre mot de passe a bien été changé");
		return "redirect:/accueil";
	}
	
	
}
