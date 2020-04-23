package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.DAOCompte;
import dao.DAOCompteJDBC;
import dao.DAOEquipe;
import dao.DAOEquipeJDBC;
import dao.DAOJoueur;
import dao.DAOJoueurJDBC;

public class Context {
	
	private Connection connection=null;
	private static Context _instance=null;
	
	//Changer le new DAO...en dao JPA pour passer en JPA
	private DAOCompte daoC= new DAOCompteJDBC();
	private DAOJoueur daoJ= new DAOJoueurJDBC();
	private DAOEquipe daoE= new DAOEquipeJDBC();
		
	public Context() {}
	
	public DAOCompte getDaoC() {
		return daoC;
	}

	public DAOJoueur getDaoJ() {
		return daoJ;
	}
	
	public DAOEquipe getDaoE() {
		return daoE;
	}
	
	
    public Connection getConnection() throws ClassNotFoundException, SQLException 
    {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_mercato","root","");
    
        return connection;
    }
    
	public static Context getInstance()
	{
		if(_instance==null)
		{
			_instance=new Context();
		}
		return _instance;
	}
		
	

	
}