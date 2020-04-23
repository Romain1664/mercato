package model;

import dao.IDAOCompte;
import dao.IDAOEquipe;
import dao.IDAOJoueur;
import dao.jdbc.DAOCompteJdbc;
import dao.jdbc.DAOEquipeJdbc;
import dao.jdbc.DAOJoueurJdbc;
import dao.jpa.DAOCompteJpa;
import dao.jpa.DAOEquipeJpa;
import dao.jpa.DAOJoueurJpa;

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