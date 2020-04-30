package fr.formation.daoSpring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte, Integer> {

	@Query(value = "SELECT c from Compte c WHERE c.login =?1", nativeQuery = false)
	public Compte findByLogin(String login);
	
	@Query(value = "SELECT c from Compte c WHERE c.login =?1 AND password=?2", nativeQuery = false)
	public Compte checkConnect(String login, String password);
	
}
