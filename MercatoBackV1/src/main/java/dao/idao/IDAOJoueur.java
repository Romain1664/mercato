package dao.idao;

import java.util.List;

import dao.IDAO;
import model.Joueur;

public interface IDAOJoueur extends IDAO<Joueur, Integer> {

	public List<Joueur> selectByEquipe(int id_equipe);
	
	public List<Joueur> selectByEquipeByBudget(double budget);
	
}
