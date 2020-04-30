package fr.formation.dao.jpa;

import java.util.List;

import fr.formation.dao.idao.IDAOEquipe;
import fr.formation.model.Equipe;



public class DAOEquipeJpa extends DaoJpa implements IDAOEquipe {


	public void insert(Equipe eq) {
		this.em.getTransaction().begin();

		try {
			this.em.persist(eq);
			this.em.getTransaction().commit();
		}
		catch (Exception e) 
		{
			this.em.getTransaction().rollback();
		}
	}

	
	public Equipe selectById(Integer id) {
		return this.em.find(Equipe.class, id);
	}

	
	public List<Equipe> selectAll() {
		return this.em
				.createQuery("SELECT eq FROM Equipe eq", Equipe.class)
				.getResultList();
	}

	
	public void update(Equipe eq) {
		this.em.getTransaction().begin();
		
		try {
			this.em.merge(eq);
			this.em.getTransaction().commit();
		}
		catch (Exception e) 
		{
			this.em.getTransaction().rollback();
		}

	}

	
	public void delete(Integer id) {
		try 
		{
			this.em.getTransaction().begin();

			Equipe equipeToRemove = new Equipe();
			equipeToRemove.setId(id);

			this.em.remove(this.em.merge(equipeToRemove));
			this.em.getTransaction().commit();
		}
		catch (Exception e) 
		{
			this.em.getTransaction().rollback();
		}
	}

	@Override
	public Equipe selectByNomEquipe(String nom) {
		return this.em.createQuery("SELECT eq FROM Equipe eq WHERE eq.nom = ?1" , Equipe.class)
				.setParameter(1, nom).getSingleResult();
	}





}
