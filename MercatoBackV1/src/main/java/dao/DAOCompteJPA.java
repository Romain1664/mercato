package dao;

import java.util.List;

import model.Compte;

public class DAOCompteJPA extends DaoJpa implements IDAOCompte {

	
	public void insert(Compte c) {
		this.em.getTransaction().begin();

		try {
			this.em.persist(c);
			this.em.getTransaction().commit();
		}
		catch (Exception e) {
			this.em.getTransaction().rollback();
		}
	}

	
	public Compte selectById(Integer id) {
		
		return this.em.createQuery("SELECT c FROM Compte c WHERE c.id = ?1" , Compte.class)
				.setParameter(1, id).getSingleResult();
	}

	
	public List<Compte> selectAll() {
		
		return this.em.createQuery("SELECT c FROM Compte c", Compte.class).getResultList();
	}

	
	public void update(Compte c) {
		this.em.getTransaction().begin();
		
		try {
			this.em.merge(c);
			this.em.getTransaction().commit();
		}
		catch (Exception e) {
			this.em.getTransaction().rollback();
		}

	}

	
	public void delete(Integer id) {
		this.em.createQuery("DELETE FROM Compte c where c.id = ?1")
				.setParameter(1, id).executeUpdate();


	}

	@Override
	public Compte selectByLogin(String login) {
		
		return this.em.createQuery("SELECT c FROM Compte c WHERE c.login = ?1" , Compte.class)
				.setParameter(1, login).getSingleResult();
	}

	@Override
	public Compte SelectByIdentite(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte checkConnect(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
