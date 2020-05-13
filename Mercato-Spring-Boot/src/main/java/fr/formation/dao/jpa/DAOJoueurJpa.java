package fr.formation.dao.jpa;

import java.util.List;

import org.hibernate.engine.spi.ExecuteUpdateResultCheckStyle;

import fr.formation.dao.idao.IDAOJoueur;
import fr.formation.model.Joueur;


public class DAOJoueurJpa extends DaoJpa implements IDAOJoueur {

	@Override
	public void insert(Joueur j) {
		this.em.getTransaction().begin();
		
		try 
		{
			em.
			createNativeQuery("INSERT INTO joueur ( id, nom, prenom, age, poste, tir, précision, acceleration, puissance, tacle, marquage, id_equipe, prix) VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13)")
			.setParameter(1, j.getId())
			.setParameter(2, j.getNom())
			.setParameter(3, j.getPrenom())
			.setParameter(4, j.getAge())
			.setParameter(5, j.getPoste())
			.setParameter(6, j.getTir())
			.setParameter(7, j.getPrecision())
			.setParameter(8, j.getAcceleration())
			.setParameter(9, j.getPuissance())
			.setParameter(10, j.getTacle())
			.setParameter(11, j.getMarquage())
			.setParameter(12, j.getId_equipe())
			.setParameter(13, j.getPrix())
			.executeUpdate();
			
			this.em.getTransaction().commit(); 
		}
		catch (Exception e)
		{ 
			e.printStackTrace();
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
			e.printStackTrace();
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