package dao.jpa;

import java.util.List;

import dao.idao.IDAOCompte;
import model.Compte;


public class DAOCompteJpa extends DaoJpa implements IDAOCompte {


	public void insert(Compte c) {
		this.em.getTransaction().begin();

		try {
			this.em.persist(c);
			this.em.getTransaction().commit();
		}
		catch (Exception e) 
		{
			this.em.getTransaction().rollback();
		}
	}

	
	public Compte selectById(Integer id) {
		return this.em.find(Compte.class, id);
	}

	
	public List<Compte> selectAll() {
		return this.em
				.createQuery("select c from Compte c", Compte.class)
				.getResultList();
	}

	
	public void update(Compte c) {
		
		this.em.getTransaction().begin();
		
		try 
		{
			this.em.merge(c);
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

			Compte compteToRemove = new Compte();
			compteToRemove.setId(id);

			this.em.remove(this.em.merge(compteToRemove));
			this.em.getTransaction().commit();
		}
		catch (Exception e) 
		{
			this.em.getTransaction().rollback();
		}
	}
	
	@Override
	public Compte selectByLogin(String login) {
		
		return this.em.createQuery("SELECT c FROM Compte c WHERE c.login = ?1" , Compte.class)
				.setParameter(1, login).getSingleResult();
	}

	@Override
	public Compte checkConnect(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
