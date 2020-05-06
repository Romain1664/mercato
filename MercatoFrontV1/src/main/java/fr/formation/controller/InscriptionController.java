package fr.formation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String inscription(@ModelAttribute Compte compte, Model model) {
		
		Compte c=daoCompte.findByLogin(compte.getLogin());
		
		if (c!=null)
		{
			model.addAttribute("errorLogin","Ce login existe déjà");
			return "inscription";
		}
		
		if ( (!compte.getType().equals("joueur")) && (!compte.getType().equals("manager")) )
		{
			model.addAttribute("login",compte.getLogin());
			model.addAttribute("errorType","Choisissez un type de compte VALIDE !");
			return "inscription";
		}
		
//		if (compte.getType().equals("manager"))
//		{
//			Equipe eq = daoEquipe.findByNomEquipe(equipe.getNom_equipe());
//			
//			if (eq!=null)
//			{
//				model.addAttribute("login",compte.getLogin());
//				model.addAttribute("errorEquipe","Le nom d'équipe est déjà pris!");
//				return "inscription";
//			}
//		}
		
		daoCompte.save(compte);
		
		return "accueil";
	}
	
	@GetMapping("/reset_password")
	public String accueilReset(Model model) {
		return "reset";
	}	
	
	@PostMapping("/reset_password")
	public String resetPassword(@RequestParam(value="login") String login, @RequestParam(value="password") String password, Model model) {
		
		Compte c = daoCompte.findByLogin(login);
		
		if (c==null)
		{
			model.addAttribute("errorLogin", "Ce login n'est associé à aucun compte");
			return "reset";
		}
		
		c.setPassword(password);
		daoCompte.save(c);
		
		model.addAttribute("message","Votre mot de passe à bien été changé");
		return "redirect:/accueil";
	}
	
	
}
