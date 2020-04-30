package fr.formation.dao.idao;

import fr.formation.dao.IDAO;
import fr.formation.model.Compte;

public interface IDAOCompte extends IDAO<Compte, Integer> {

	public Compte selectByLogin(String login);
	
	public Compte checkConnect(String login,String password);
	
}
