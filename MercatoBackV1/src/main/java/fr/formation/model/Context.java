package fr.formation.model;

import fr.formation.dao.idao.IDAOCompte;
import fr.formation.dao.idao.IDAOEquipe;
import fr.formation.dao.idao.IDAOJoueur;
import fr.formation.dao.jpa.DAOCompteJpa;
import fr.formation.dao.jpa.DAOEquipeJpa;
import fr.formation.dao.jpa.DAOJoueurJpa;

public class Context {
	
	private static IDAOCompte daoCompte;
	private static IDAOJoueur daoJoueur;
	private static IDAOEquipe daoEquipe;
		
	public Context() {}
	
	public static IDAOCompte getDaoCompte() {
		if(daoCompte == null) {
			daoCompte = new DAOCompteJpa();
//			daoCompte = new DAOCompteJdbc();
		}
		return daoCompte;
	}
	
	public static IDAOEquipe getDaoEquipe() {
		if(daoEquipe == null) {
			daoEquipe = new DAOEquipeJpa();
//			daoEquipe = new DAOEquipeJdbc();
		}
		return daoEquipe;
	}
	
	public static IDAOJoueur getDaoJoueur() {
		if(daoJoueur == null) {
			daoJoueur = new DAOJoueurJpa();
//			daoJoueur = new DAOJoueurJdbc();
		}
		return daoJoueur;
	}
	

	
}