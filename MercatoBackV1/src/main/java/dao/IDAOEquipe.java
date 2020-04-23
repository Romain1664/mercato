package dao;

import model.Equipe;

public interface IDAOEquipe extends IDAO<Equipe, Integer> {

	public Equipe selectByNomEquipe(String nom);
	
}
