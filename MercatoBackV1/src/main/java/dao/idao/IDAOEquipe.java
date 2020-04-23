package dao.idao;

import dao.IDAO;
import model.Equipe;

public interface IDAOEquipe extends IDAO<Equipe, Integer> {

	public Equipe selectByNomEquipe(String nom);
	
}
