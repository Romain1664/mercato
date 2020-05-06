package fr.formation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
		System.out.println("test");
		return "inscription";
	}
	
	@PostMapping("/inscription")
	public String inscription(@Valid @ModelAttribute Compte compte, BindingResult result,@Valid @ModelAttribute Equipe equipe, BindingResult resultEquipe, Model model) {
		
		if (result.hasErrors()||result.hasErrors())
		{
			return "inscription";
		}
		
		Compte c=daoCompte.findByLogin(compte.getLogin());
		
		if (c!=null)
		{
			return "inscription";
		}
		
		if ( (!compte.getType().equals("manager")) & (!compte.getType().equals("manager")) )
		{
			model.addAttribute("login",compte.getLogin());
			model.addAttribute("errorType","Choisissez un type de compte VALIDE !");
			return "inscription";
		}
		
		if (compte.getType().equals("manager"))
		{
			Equipe eq = daoEquipe.findByNomEquipe(equipe.getNom_equipe());
			return "accueil";
		}
		
		
		daoCompte.save(compte);
		return "Blabla";
	}
	
	
}
