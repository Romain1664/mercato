package fr.formation.daObsolete.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.formation.daObsolete.idao.IDAOJoueur;
import fr.formation.model.Joueur;

public class DAOJoueurJdbc extends DaoJdbc implements IDAOJoueur {
	
	
	@Override
	public void insert(Joueur j) {
		try 
		(
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
			List<Joueur> liste = new ArrayList<>();
			Joueur j = null;
			
			try
			(
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
	
	public List<Joueur> selectByEquipeByBudget(double budget) {
		
		List<Joueur> liste = new ArrayList<>();
		Joueur j = null;
		
		try
		(
			PreparedStatement ps=connect.prepareStatement("SELECT * from joueurs JOIN equipes ON joueurs.id_equipe=equipes.id WHERE id_equipe=0 AND prix<?"); 
		)
		{
			ps.setDouble(1, budget);
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
			List<Joueur> liste = new ArrayList<>();
			Joueur j = null;
			
			try
			(
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
	

	@Override
	public void delete(Integer id) {
		try 
		(
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
