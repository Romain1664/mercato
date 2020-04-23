package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import dao.idao.IDAOCompte;
import dao.idao.IDAOJoueur;

@Entity 
@Table(name = "compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte extends Context{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	protected int id;
	
	@Column(name="login", length=25, nullable =false ) 
	protected String login;
	
	@Column(name="password", length=25, nullable =false ) 
	protected String password;
	
	@Column(name="type", length=10, nullable =false, insertable=false, updatable=false) 
	protected String type;
	
	
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
		Context.getDaoCompte().update(this);
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
		IDAOCompte daoC= Context.getDaoCompte();
		
		Compte c=daoC.selectByLogin(login);

        return c;
    }
	
	public Compte checkConnect(String login,String password)
	{
		IDAOCompte daoC= Context.getDaoCompte();
		
		Compte c=daoC.checkConnect(login, password);

        return c;
    }
	
	
	public void listeJoueur()
	{

		IDAOJoueur daoJ=Context.getDaoJoueur();
		
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
				
		c=Context.getDaoCompte().selectByLogin(login);

		return c;
	}
	
	public void updatePassword() {
		
		Context.getDaoCompte().update(this);
		System.out.println("Votre mot de passe a été modifié !");
		
	}
	
	
}