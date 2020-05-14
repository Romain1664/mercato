package fr.formation.daoSpring;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.model.Joueur;

public interface IDAOJoueur extends JpaRepository<Joueur, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO joueur ( id, nom, prenom, age, poste, tir, précision, acceleration, puissance, tacle, marquage, id_equipe, prix) VALUES ( :#{#j.id} ,:#{#j.nom},:#{#j.prenom},:#{#j.age},:#{#j.poste},:#{#j.tir},:#{#j.precision},:#{#j.acceleration},:#{#j.puissance},:#{#j.tacle},:#{#j.marquage},:#{#j.id_equipe},:#{#j.prix})", nativeQuery = true)
	public Integer insert(@Param("j") Joueur j);
	
	@Modifying
	@Query(value = "DELETE FROM Joueur WHERE id=?1", nativeQuery = true)
	public void deleteById(Integer id);
	
	@Query(value ="SELECT j FROM Joueur j WHERE j.id_equipe=?1", nativeQuery = false)
	public List<Joueur> findByEquipe(int id_equipe);
	
	@Query(value ="SELECT j FROM Joueur j WHERE j.id_equipe=1 AND j.prix<?1", nativeQuery = false)
	public List<Joueur> findLibreByBudget(double budget);
	
}
