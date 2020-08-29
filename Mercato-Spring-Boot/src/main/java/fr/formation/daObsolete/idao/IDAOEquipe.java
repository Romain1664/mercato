package fr.formation.daObsolete.idao;

import fr.formation.daObsolete.IDAO;
import fr.formation.model.Equipe;

public interface IDAOEquipe extends IDAO<Equipe, Integer> {

	public Equipe selectByNomEquipe(String nom);
	
}
