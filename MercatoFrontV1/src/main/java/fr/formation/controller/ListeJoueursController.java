package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.formation.daoSpring.IDAOJoueur;

@Controller
public class ListeJoueursController {

	@Autowired
	private IDAOJoueur daoJoueur;
	
	

	
}
