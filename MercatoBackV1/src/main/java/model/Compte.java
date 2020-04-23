package model;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import dao.DAOCompte;
import dao.DAOCompteJDBC;
import dao.DAOJoueur;
import dao.DAOJoueurJDBC;

public class Compte extends Context{
	
	protected String login,password,type;
	protected int id;
	
	public Compte(int id, String login, String password, String type)
	{
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.type=type;
	}
	
	public Compte(String login, String password, String type)
	{
		
		this.login = login;
		this.password = password;
		this.type=type;
	}
	
	public Compte(int id)
	{
		this.id=id;
	}
	
	public Compte() {}
	

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getLogin() 
	{
		return login;
	}

	public void setLogin(String login) 
	{
		this.login = login;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
		Context.getInstance().getDaoC().update(this);
	}
	
	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	
	public Compte checkLogin(String login)
	{
		DAOCompte daoC= Context.getInstance().getDaoC();
		
		Compte c=daoC.selectByLogin(login);

        return c;
    }
	
	public Compte checkConnect(String login,String password)
	{
		DAOCompte daoC= Context.getInstance().getDaoC();
		
		Compte c=daoC.checkConnect(login, password);

        return c;
    }
	
	
	public void listeJoueur()
	{

		DAOJoueur daoJ=Context.getInstance().getDaoJ();
		
		List<Joueur> listeJoueurs = daoJ.selectAll();
		
		
		if(listeJoueurs.isEmpty()) 
		{
			System.out.println("Bug");
		}
		else 
		{
			for(Joueur j : listeJoueurs) 
			{
				System.out.println(j);
			}
		}
	}

	
	public Compte selectByLogin(String login) {

		Compte c=null;
				
		c=Context.getInstance().getDaoC().selectByLogin(login);

		return c;
	}
	
	public void updatePassword() {
		
		Context.getInstance().getDaoC().update(this);
		System.out.println("Votre mot de passe a été modifié !");
		
	}
	
	
}