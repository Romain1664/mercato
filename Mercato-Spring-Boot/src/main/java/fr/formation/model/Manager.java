package fr.formation.model;

import java.util.List;


public class Manager extends Compte {
	
	private double budget;
		
	
	public Manager(int id, String login, String password, String type) 
	{
		super(id, login, password, type);
	}
	
	public Manager() {}
	
	
	
	public double getBudget() 
	{
		return budget;
	}

	public void setBudget(double budget) 
	{
		this.budget = budget;
	}

	
	public void listeJoueurEquipe(int id_equipe)
	{
		List<Joueur> listeJoueurs = Context.getDaoJoueur().selectByEquipe(id_equipe);
		
		if(listeJoueurs.isEmpty()) 
		{
			System.out.println("Vous n'avez pas de joueur.");
		}
		else 
		{
			for(Joueur j : listeJoueurs) 
			{
				System.out.println(j);
			}
		}
		System.out.print(System.lineSeparator());
	}
	
	
	public void listeJoueurEquipeByBudget(int id_equipe, double budget)
	{

		List<Joueur> listeJoueurs = Context.getDaoJoueur().selectByEquipeByBudget(budget);
		
		if(listeJoueurs.isEmpty()) 
		{
			System.out.println("Aucun joueur n'est à votre budget.");
		}
		else 
		{
			for(Joueur j : listeJoueurs) 
			{
				System.out.println(j);
			}
			System.out.print(System.lineSeparator());
		}
	}

	
}
