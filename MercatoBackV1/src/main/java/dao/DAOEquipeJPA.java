package dao;

import java.util.List;

import model.Equipe;

public class DAOEquipeJPA extends DaoJpa implements DAOEquipe {

	public void insert(Equipe eq) {
		this.em.getTransaction().begin();

		try {
			this.em.persist(eq);
			this.em.getTransaction().commit();
		}
		catch (Exception e) {
			this.em.getTransaction().rollback();
		}
	}

	
	public Equipe selectById(Integer id) {
		
		return this.em.createQuery("SELECT e FROM Equipe e WHERE e.id = ?1" , Equipe.class)
				.setParameter(1, id).getSingleResult();
	}

	
	public List<Equipe> selectAll() {
		
		return this.em.createQuery("SELECT e FROM Equipe e", Equipe.class).getResultList();
	}

	
	public void update(Equipe eq) {
		this.em.getTransaction().begin();
		
		try {
			this.em.merge(eq);
			this.em.getTransaction().commit();
		}
		catch (Exception e) {
			this.em.getTransaction().rollback();
		}

	}

	
	public void delete(Integer id) {
		this.em.createQuery("DELETE FROM Equipe e where e.id = ?1",Equipe.class)
				.setParameter(1, id).executeUpdate();


	}

	@Override
	public Equipe selectByNomEquipe(String nom) {
		return this.em.createQuery("SELECT e FROM Equipe e WHERE e.nom = ?1" , Equipe.class)
				.setParameter(1, nom).getSingleResult();
	}





}
