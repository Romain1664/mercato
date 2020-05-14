package fr.formation.daObsolete.idao;

import fr.formation.daObsolete.IDAO;
import fr.formation.model.Compte;

public interface IDAOCompte extends IDAO<Compte, Integer> {

	public Compte selectByLogin(String login);
	
	public Compte checkConnect(String login,String password);
	
}
