package fr.formation.daObsolete.idao;

import java.util.List;

import fr.formation.daObsolete.IDAO;
import fr.formation.model.Joueur;

public interface IDAOJoueur extends IDAO<Joueur, Integer> {

	public List<Joueur> selectByEquipe(int id_equipe);
	
	public List<Joueur> selectByEquipeByBudget(double budget);
	
}
