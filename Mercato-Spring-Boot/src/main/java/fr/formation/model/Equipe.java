package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "equipe")
public class Equipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nom_equipe", length=50,  nullable = false)
	@NotNull
	@NotEmpty
	private String nom_equipe;

	@Column(name = "id_compte", nullable = false)
	private int id_compte;
	
	@Column(name = "budget", nullable = false)
	@Min(0)
	private double budget;
	
	@Transient
	private int id_new_compte;
	

	public Equipe(int id, String nom_equipe, int id_compte, double budget) {
		this.id=id;
		this.nom_equipe = nom_equipe;
		this.id_compte = id_compte;
		this.budget = budget;
		this.id_new_compte=id_compte;
	}
	
	public Equipe(String nom_equipe, int id_compte, double budget) {
		this.nom_equipe = nom_equipe;
		this.id_compte = id_compte;
		this.budget = budget;
		this.id_new_compte=id_compte;
	}

	public Equipe(String nom_equipe, int id_compte, double budget, int id_new_compte) {
		this.nom_equipe = nom_equipe;
		this.id_compte = id_compte;
		this.budget = budget;
		this.id_new_compte=id_new_compte;
	}
	
	public Equipe() {
	}
	
	
	
	public String getNom_equipe() {
		return nom_equipe;
	}

	public void setNom_equipe(String nom_equipe) {
		this.nom_equipe = nom_equipe;
	}

	public int getId_compte() {
		return id_compte;
	}

	public void setId_compte(int id_compte) {
		this.id_compte = id_compte;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getId_new_compte() {
		return id_new_compte;
	}

	public void setId_new_compte(int id_new_compte) {
		this.id_new_compte = id_new_compte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
}
