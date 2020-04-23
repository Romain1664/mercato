package dao;

import java.util.List;

import model.Joueur;

public interface DAOJoueur extends DAO<Joueur, Integer> {

	public List<Joueur> selectByEquipe(int id_equipe);
	
	public List<Joueur> selectByEquipeByBudget(int id_equipe, double budget);
	
	public void updateStatut(Integer id,String statut);
	
}
