package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Context;
import model.Joueur;

public class DAOJoueurJDBC implements DAOJoueur{
	
	
	@Override
	public void insert(Joueur j) {
		try 
		(
				Connection connect=Context.getInstance().getConnection();
				PreparedStatement ps=connect.prepareStatement("INSERT INTO `joueurs` ( `id_compte`, `nom`, `prenom`, `age`, `poste`, `tir`, `precision`, `acceleration`, `puissance`, `tacle`, `marquage`, `id_equipe`, `prix`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");                      
		)
		{
			ps.setInt(1,j.getId());
			ps.setString(2, j.getNom());
			ps.setString(3,j.getPrenom());
			ps.setInt(4,j.getAge());
			ps.setString(5 ,j.getPoste());
			ps.setInt(6, j.getTir());
			ps.setInt(7,j.getPrecision());
			ps.setInt(8,j.getAcceleration());
			ps.setInt(9 ,j.getPuissance());
			ps.setInt(10,j.getTacle());
			ps.setInt(11 ,j.getMarquage());
			ps.setInt(12, j.getId_equipe());
			ps.setDouble(13 ,j.getPrix());
			
			ps.executeUpdate();

		}catch (Exception e) {e.printStackTrace();}
	}
	
	
	public Joueur selectById(Integer id_compte) {
		
		Joueur j=null;
		try
		(
				Connection connect=Context.getInstance().getConnection();
				PreparedStatement ps=connect.prepareStatement("SELECT * from joueurs WHERE id_compte=?"); 
		)
		{
			ps.setInt(1, id_compte);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) 
			{
				j = new Joueur(rs.getInt("id_compte"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("age"),rs.getString("poste"),rs.getInt("tir"),rs.getInt("precision"),rs.getInt("acceleration"),rs.getInt("puissance"),rs.getInt("tacle"),rs.getInt("marquage"),rs.getInt("id_equipe"),rs.getDouble("prix"));
			}

		}catch (Exception e) {e.printStackTrace();}

		return j;
	}

	public List<Joueur> selectByEquipe(int id_equipe) {
			List<Joueur> liste = new ArrayList();
			Joueur j = null;
			
			try
			(
				Connection connect=Context.getInstance().getConnection();
				PreparedStatement ps=connect.prepareStatement("SELECT * from joueurs JOIN equipes ON joueurs.id_equipe=equipes.id WHERE id_equipe=?"); 
			)
			{
				ps.setInt(1, id_equipe);
				ResultSet rs= ps.executeQuery();
				while(rs.next())
				{
					j = new Joueur(rs.getInt("id_compte"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("age"),rs.getString("poste"),rs.getInt("tir"),rs.getInt("precision"),rs.getInt("acceleration"),rs.getInt("puissance"),rs.getInt("tacle"),rs.getInt("marquage"),rs.getString("nom_equipe"),rs.getDouble("prix"));
					liste.add(j);
				}
			}catch (Exception e) {e.printStackTrace();}
			
			return liste;
		
		}
	
	public List<Joueur> selectByEquipeByBudget(int id_equipe, double budget) {
		
		List<Joueur> liste = new ArrayList();
		Joueur j = null;
		
		try
		(
			Connection connect=Context.getInstance().getConnection();
			PreparedStatement ps=connect.prepareStatement("SELECT * from joueurs JOIN equipes ON joueurs.id_equipe=equipes.id WHERE id_equipe=? AND prix<?"); 
		)
		{
			ps.setInt(1, id_equipe);
			ps.setDouble(2, budget);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				j = new Joueur(rs.getInt("id_compte"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("age"),rs.getString("poste"),rs.getInt("tir"),rs.getInt("precision"),rs.getInt("acceleration"),rs.getInt("puissance"),rs.getInt("tacle"),rs.getInt("marquage"),rs.getString("nom_equipe"),rs.getDouble("prix"));
				liste.add(j);
			}
		}catch (Exception e) {e.printStackTrace();}
		
		return liste;
	}
	
	
	
	
	@Override
	public List<Joueur> selectAll() {
			List<Joueur> liste = new ArrayList();
			Joueur j = null;
			
			try
			(
				Connection connect=Context.getInstance().getConnection();
				PreparedStatement ps=connect.prepareStatement("SELECT * from joueurs JOIN equipes ON joueurs.id_equipe=equipes.id"); 
			)
			{
				ResultSet rs= ps.executeQuery();
				while(rs.next()) 
				{
					j = new Joueur(rs.getInt("id_compte"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("age"),rs.getString("poste"),rs.getInt("tir"),rs.getInt("precision"),rs.getInt("acceleration"),rs.getInt("puissance"),rs.getInt("tacle"),rs.getInt("marquage"),rs.getString("nom_equipe"),rs.getDouble("prix"));
					liste.add(j);
				}
			}catch (Exception e) {e.printStackTrace();}
			
			return liste;
		
		}
	

	
	public void updateStatut(Integer id,String statut) {
		
		try
		(
			Connection connect=Context.getInstance().getConnection();
			PreparedStatement ps=connect.prepareStatement("UPDATE joueurs SET statut= ? WHERE id_compte=?"); 
		)
		
		{
			ps.setString(1,statut);
			ps.setInt(2, id);
			ResultSet rs= ps.executeQuery();
		}
		catch (Exception e) {e.printStackTrace();}
	}



	@Override
	public void delete(Integer id) {
		try 
		(
			Connection connect=Context.getInstance().getConnection();
			PreparedStatement ps=connect.prepareStatement("DELETE FROM joueurs WHERE id_compte=?");                      
		)
		{
			ps.setInt(1,id);
			ps.executeUpdate();
		}
		catch (Exception e) {e.printStackTrace();}
	}


	@Override
	public void update(Joueur j) {
	
		try 
		(
				Connection connect=Context.getInstance().getConnection();
				PreparedStatement ps=connect.prepareStatement("UPDATE joueurs SET nom = ?, prenom = ?, age = ?, poste = ?, tir = ?, `precision` = ?, acceleration = ?, puissance = ?, tacle = ?, marquage = ?, id_equipe = ?, prix = ? WHERE id_compte = ?") 
		)
		{
			ps.setString(1, j.getNom());
			ps.setString(2,j.getPrenom());
			ps.setInt(3,j.getAge());
			ps.setString(4 ,j.getPoste());
			ps.setInt(5, j.getTir());
			ps.setInt(6,j.getPrecision());
			ps.setInt(7,j.getAcceleration());
			ps.setInt(8 ,j.getPuissance());
			ps.setInt(9,j.getTacle());
			ps.setInt(10 ,j.getMarquage());
			ps.setInt(11, j.getId_equipe());
			ps.setDouble(12 ,j.getPrix());
			ps.setInt(13,j.getId());
			
			
			ps.executeUpdate();
	
		}catch (Exception e) {e.printStackTrace();}	
	}
}
