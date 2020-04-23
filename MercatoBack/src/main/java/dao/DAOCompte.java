package dao;

import model.Compte;

public interface DAOCompte extends DAO<Compte, Integer> {

	public Compte selectByLogin(String login);
	
	public Compte SelectByIdentite(String nom,String prenom);
	
	public Compte checkConnect(String login,String password);
	
}
