package model;

public class Equipe {

	
	private String nom_equipe;
	private int id;
	private int id_compte;
	private double budget;
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
