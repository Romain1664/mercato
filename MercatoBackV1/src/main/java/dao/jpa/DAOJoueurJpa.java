package dao.jpa;

import java.util.List;

import org.hibernate.engine.spi.ExecuteUpdateResultCheckStyle;

import dao.idao.IDAOJoueur;
import model.Joueur;


public class DAOJoueurJpa extends DaoJpa implements IDAOJoueur {

	@Override
	public void insert(Joueur j) {
		this.em.getTransaction().begin();
		
		try 
		{
			this.em.persist(j);
			this.em.getTransaction().commit(); 
		}
		catch (Exception e) 
		{ 
			this.em.getTransaction().rollback(); 
		}
	}

	@Override
	public Joueur selectById(Integer id) {
		return this.em.find(Joueur.class, id);
	}

	@Override
	public List<Joueur> selectAll() {
		return this.em
				.createQuery("select j from Joueur j", Joueur.class)
				.getResultList();
	}

	@Override
	public void update(Joueur j) {
		
		this.em.getTransaction().begin(); 
		
		try 
		{
			this.em.merge(j);
			this.em.getTransaction().commit(); 
		}
		catch (Exception e) 
		{ 
			this.em.getTransaction().rollback();
		}
	}
	

/*
	@Override
	public void delete(Integer id) {
		try 
		{
			this.em.getTransaction().begin(); 
			
			Joueur joueurToRemove = new Joueur();
			joueurToRemove.setId(id);
			
			this.em.remove(this.em.merge(joueurToRemove));
			this.em.getTransaction().commit(); 
		}
		
		catch (Exception e) 
		{ 
			this.em.getTransaction().rollback();
		}
	}
*/
	
	@Override
	public void delete(Integer id) {
		try 
		{
			this.em.getTransaction().begin(); 

			em
			.createNativeQuery("DELETE FROM Joueur WHERE id=?1")
			.setParameter(1, id)
			.executeUpdate();
			
			this.em.getTransaction().commit(); 
		}
		
		catch (Exception e) 
		{ 
			this.em.getTransaction().rollback();
		}
	}

	
	@Override
	public List<Joueur> selectByEquipe(int id_equipe) {
		return this.em
				.createQuery("SELECT j FROM Joueur j WHERE j.id_equipe=?1" , Joueur.class)
				.setParameter(1, id_equipe)
				.getResultList();
	}
	
	@Override
	public List<Joueur> selectByEquipeByBudget(double budget) {
		return this.em
				.createQuery("SELECT j FROM Joueur j WHERE j.id_equipe=0 AND j.prix<?1" , Joueur.class)
				.setParameter(1, budget)
				.getResultList();
	}

}