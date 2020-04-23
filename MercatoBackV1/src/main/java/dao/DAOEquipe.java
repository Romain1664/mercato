package dao;

import model.Equipe;

public interface DAOEquipe extends DAO<Equipe, Integer> {

	public Equipe selectByNomEquipe(String nom);
	
}
