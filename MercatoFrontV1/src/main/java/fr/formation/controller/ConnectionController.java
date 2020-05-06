package fr.formation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.daoSpring.IDAOCompte;


@Controller
public class ConnectionController 
{
	
	@Autowired
	private IDAOCompte daoCompte;
	
	@PostMapping("/spring-connect")
	public String connection
	(
			@RequestParam(value="login",defaultValue="Nom") String username,
			@RequestParam String password,
			HttpSession session, Model model)
	{
		
		if(username.isEmpty()) 
		{
			model.addAttribute("error","Login vide");
		}
		return "redirect:/connection-redirect";
	}
	
	//@RequestMapping(value="/test", method = RequestMethod.GET)
	@GetMapping("/connection")
	public String connection(Model model) 
	{
		
		//return "connect";
		return "redirect:/connection-redirect";
	}
	
	
	@GetMapping("/connection-redirect")
	public String connectionRedirect(Model model) 
	{
		model.addAttribute("Welcome","Message de bienvenue");
		
		return "connection";
	}
	
//	@DeleteMapping("/deconnection")
//	public String déconnection(Model model) 
//	{
//		model.addAttribute("Vous êtes déconnecté de l'application Mercato, merci de votre visite");
//		
//		return "connection";
//	}
}
