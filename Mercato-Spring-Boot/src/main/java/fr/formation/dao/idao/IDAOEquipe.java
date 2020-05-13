package fr.formation.dao.idao;

import fr.formation.dao.IDAO;
import fr.formation.model.Equipe;

public interface IDAOEquipe extends IDAO<Equipe, Integer> {

	public Equipe selectByNomEquipe(String nom);
	
}
