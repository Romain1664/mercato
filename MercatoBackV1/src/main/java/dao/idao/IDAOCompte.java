package dao.idao;

import dao.IDAO;
import model.Compte;

public interface IDAOCompte extends IDAO<Compte, Integer> {

	public Compte selectByLogin(String login);
	
	public Compte checkConnect(String login,String password);
	
}
