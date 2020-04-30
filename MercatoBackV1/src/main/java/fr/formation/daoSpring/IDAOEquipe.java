package fr.formation.daoSpring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Equipe;

public interface IDAOEquipe extends JpaRepository<Equipe, Integer> {

	@Query(value = "SELECT eq FROM Equipe eq WHERE eq.nom_equipe = ?1", nativeQuery = false)
	public Equipe findByNomEquipe(String nom);
	
}
