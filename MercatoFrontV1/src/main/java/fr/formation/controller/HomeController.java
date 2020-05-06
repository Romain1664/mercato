package fr.formation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.daoSpring.IDAOCompte;

@Controller
//@RequestMapping("/home") // Ajoute /home devant tous les mappings
public class HomeController {
	
	@Autowired
	private IDAOCompte daoCompte;
	
	@PostMapping("/spring-connect")
	public String connexion
	(
			@RequestParam(value="login",defaultValue="Nom") String username,
			@RequestParam String password,
			HttpSession session, Model model)
	{
		
		if(username.isEmpty()) 
		{
			model.addAttribute("error","Login vide");
		}
		return "redirect:/test-redirect";
	}
	
	//@RequestMapping(value="/test", method = RequestMethod.GET)
	@GetMapping("/conection")
	public String conection(Model model) 
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
	
}
