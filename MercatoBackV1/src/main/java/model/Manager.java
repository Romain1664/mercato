package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 
@DiscriminatorValue("manager")
public class Manager extends Compte {
	
	@Column (name ="budget", nullable = false)
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
		List<Joueur> listeJoueurs = Context.getInstance().getDaoJ().selectByEquipe(id_equipe);
		
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

		List<Joueur> listeJoueurs = Context.getInstance().getDaoJ().selectByEquipeByBudget(id_equipe, budget);
		
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
