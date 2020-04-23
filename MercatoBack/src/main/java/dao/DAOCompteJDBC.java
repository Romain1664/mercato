package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Compte;
import model.Context;
import model.Joueur;
import model.Manager;

public class DAOCompteJDBC implements DAOCompte {

	@Override
	public void insert(Compte c) {
		try 
		(
				Connection connect=Context.getInstance().getConnection();
				PreparedStatement ps=connect.prepareStatement("INSERT INTO comptes (login, password, type) VALUES (?,?,?) ") 
		)
		{
			ps.setString(1,c.getLogin());
			ps.setString(2,c.getPassword());
			ps.setString(3,c.getType());
			
			ps.executeUpdate();

		}catch (Exception e) {e.printStackTrace();}
	}
	
	@Override
	public Compte selectById(Integer id) {
		Compte c=null;
		try
		(
				Connection connect=Context.getInstance().getConnection();
				PreparedStatement ps=connect.prepareStatement("SELECT * from comptes where id=?"); 
				)
		{
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) 
			{
				if(rs.getString("typeCompte").equals("Joueur")) 
				{
					//c=new Joueur();
				}
				else if(rs.getString("typeCompte").equals("Manager")) 
				{
					//c=new Manager();
				}
			}
		}catch (Exception e) {e.printStackTrace();}

		return c;
	}
	
	
	public Compte selectByLogin(String login) {
		Compte c=null;
		
		try
		(
				Connection connect=Context.getInstance().getConnection();
				PreparedStatement ps=connect.prepareStatement("SELECT * from comptes where login=?"); 
				)
		{
			ps.setString(1, login);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) 
			{
				c=new Compte(rs.getInt("id"), rs.getString("login"), rs.getString("password"),rs.getString("type"));
				
			}
		}catch (Exception e) {e.printStackTrace();}
		
		
		return c;
	}
	
	public Compte SelectByIdentite(String nom,String prenom) 
	{
		Compte c=null;
		
		try
		(
				Connection connect=Context.getInstance().getConnection();
				PreparedStatement ps=connect.prepareStatement("SELECT * from comptes where nom=? AND prenom=?"); 
		)
		{
			ps.setString(1, nom);
			ps.setString(2, prenom);
			
			ResultSet rs= ps.executeQuery();
			
			rs.next();
			
			if (rs.getRow()>0) {c = new Compte(rs.getInt("id"), rs.getString("login"), rs.getString("password"),rs.getString("type"));}
			
		}catch (Exception e) {e.printStackTrace();}
		
		return c;
	}

	public Compte checkConnect(String login,String password) 
	{
		Compte c=null;
		
		try
		(
				Connection connect=Context.getInstance().getConnection();
				PreparedStatement ps=connect.prepareStatement("SELECT * from comptes where login=? and password=?"); 
				)
		{
			ps.setString(1, login);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) 
			{
				if(rs.getString("type").equals("joueur")) 
				{
					c=new Joueur(rs.getInt("id"),rs.getString("login"), rs.getString("password"),rs.getString("type"));
				}
				else if(rs.getString("type").equals("manager")) 
				{
					c=new Manager(rs.getInt("id"),rs.getString("login"), rs.getString("password"),rs.getString("type"));
				}

			}
		}catch (Exception e) {e.printStackTrace();}
		
		return c;
	}

	
	
	@Override
	public List<Compte> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public void update(Compte c) {
		try 
		(
				Connection connect=Context.getInstance().getConnection();
				PreparedStatement ps=connect.prepareStatement("UPDATE comptes Set login=?, password=?, type=? WHERE id=?") 
		)
		{
			ps.setString(1,c.getLogin());
			ps.setString(2,c.getPassword());
			ps.setString(3,c.getType());
			ps.setInt(4,c.getId());
			
			ps.executeUpdate();

		}catch (Exception e) {e.printStackTrace();}	

	}

	
	
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

}
