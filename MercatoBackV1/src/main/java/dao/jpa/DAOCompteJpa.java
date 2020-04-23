package dao.jpa;

import java.util.List;

import dao.IDAOCompte;
import model.Compte;

public class DAOCompteJpa extends DaoJpa implements IDAOCompte {

	@Override
	public void insert(Compte t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compte selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Compte t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compte selectByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte SelectByIdentite(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte checkConnect(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
