package fr.formation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConnectionControlleur {
	
	@GetMapping({"/","/accueil","/connection"})
	public String accueilInscription(HttpSession session, Model model) {
		
		model.addAttribute("message",session.getAttribute("message"));
		session.removeAttribute("message");
		return "accueil";
	}
	
	@GetMapping("/deconnection")
	public String deconnection(HttpSession session) {
		
		session.removeAttribute("id");
		session.removeAttribute("login");
		session.removeAttribute("typeAccount");
		if (session.getAttribute("message")!=null) {session.removeAttribute("message");}
		if (session.getAttribute("error")!=null) {session.removeAttribute("error");}
		if (session.getAttribute("valid")!=null) {session.removeAttribute("valid");}
		if (session.getAttribute("joueurInscrit")!=null) {session.removeAttribute("joueurInscrit");}
		if (session.getAttribute("managerEquipe")!=null) {session.removeAttribute("managerEquipe");}
		
		return "/deconnection";
	}
}