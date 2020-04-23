package dao.jpa;

import java.util.List;

import dao.IDAOJoueur;
import model.Joueur;
import model.Equipe;


public class DAOJoueurJpa extends DaoJpa implements IDAOJoueur {

	@Override
	public void insert(Joueur entity) 
	{
		this.em.getTransaction().begin();
		
		try 
		{
			this.em.persist(entity);
			this.em.getTransaction().commit(); 
		}
		
		catch (Exception e) 
		{ 
			this.em.getTransaction().rollback(); 
		}
		
	}

	@Override
	public Joueur selectById(Integer id) 
	{
		return this.em.find(Joueur.class, id);
	}

	@Override
	public List<Joueur> selectAll() 
	{
		return this.em
				.createQuery("select j from Joueur j", Joueur.class)
				.getResultList();
	}

	@Override
	public void update(Joueur entity)
	{
		try {
			this.em.getTransaction().begin(); 
			this.em.merge(entity);
			this.em.getTransaction().commit(); 
		}
		
		catch (Exception e) 
		{ 
			this.em.getTransaction().rollback();
		}
	}
	

	@Override
	public void delete(Integer id) 
	{
		try 
		{
			Joueur joueurToRemove = new Joueur();
			joueurToRemove.setId(id); //vérifier si c'est bien l'ID qu'on choisis)
			
			this.em.getTransaction().begin(); 
			this.em.remove(this.em.merge(joueurToRemove));
			
			this.em.getTransaction().commit(); 
		}
		
		catch (Exception e) 
		{ 
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}
	}

	
	@Override
	public List<Joueur> selectByEquipe(int id_equipe)
	{
		return this.em.find();
	}

	@Override
	public List<Joueur> selectByEquipeByBudget(int id_equipe, double budget) {
		// A FAIRE 
		return null;
	}

	@Override
	public void updateStatut(Integer id, String statut) {
		// A FAIRE 
		
	}


}