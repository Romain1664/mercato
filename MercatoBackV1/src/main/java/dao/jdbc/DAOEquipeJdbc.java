package dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.idao.IDAOEquipe;
import model.Equipe;

public class DAOEquipeJdbc extends DaoJdbc implements IDAOEquipe {

	@Override
	public void insert(Equipe eq) {
		try 
		(
				PreparedStatement ps=connect.prepareStatement("INSERT INTO equipes (nom_equipe, id_manager, budget) VALUES (?,?,?) ") 
		)
		{
			ps.setString(1,eq.getNom_equipe());
			ps.setInt(2,eq.getId_compte());
			ps.setDouble(3,eq.getBudget());
			
			ps.executeUpdate();

		}catch (Exception e) {e.printStackTrace();}
		
	}

	
	@Override
	public List<Equipe> selectAll() {
		List<Equipe> liste = new ArrayList<>();
		Equipe eq = null;
		
		try
		(
			PreparedStatement ps=connect.prepareStatement("SELECT * from equipes"); 
		)
		{
			ResultSet rs= ps.executeQuery();
			while(rs.next()) 
			{
				eq = new Equipe(rs.getInt("id"),rs.getString("nom_equipe"), rs.getInt("id_manager"), rs.getDouble("budget"));
				liste.add(eq);
			}
		}catch (Exception e) {e.printStackTrace();}
		
		return liste;
	}
	
	@Override
	public Equipe selectById(Integer id) {
		// Par id du manager actuel
		Equipe eq = null;
		try
		(
				PreparedStatement ps=connect.prepareStatement("SELECT * from equipes WHERE id_manager=?"); 
		)
		{
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) 
			{
				eq = new Equipe(rs.getInt("id"),rs.getString("nom_equipe"), rs.getInt("id_manager"), rs.getDouble("budget"));
			}

		}catch (Exception e) {e.printStackTrace();}
		
		return eq;
	}

	public Equipe selectByNomEquipe(String nom) {
		// Par nom d'équipe
		Equipe eq = null;
		try
		(
				PreparedStatement ps=connect.prepareStatement("SELECT * from equipes WHERE nom_equipe=?"); 
		)
		{
			ps.setString(1, nom);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) 
			{
				eq = new Equipe(rs.getInt("id"),rs.getString("nom_equipe"), rs.getInt("id_manager"), rs.getDouble("budget"));
			}

		}catch (Exception e) {e.printStackTrace();}

		return eq;
	}
	
	
	@Override
	public void update(Equipe eq) {
		try 
		(
				PreparedStatement ps=connect.prepareStatement("UPDATE equipes SET id_manager=?, nom_equipe=?, budget=? WHERE id_manager=? ") 
		)
		{
			ps.setInt(1,eq.getId_new_compte());
			ps.setString(2,eq.getNom_equipe());
			ps.setDouble(3,eq.getBudget());
			ps.setInt(4,eq.getId_compte());
			
			ps.executeUpdate();

		}catch (Exception e) {e.printStackTrace();}
		
	}

	
	@Override
	public void delete(Integer id) {
		try 
		(
				PreparedStatement ps=connect.prepareStatement("DELETE FROM equipes WHERE id_manager = ? ") 
		)
		{
			ps.setInt(1,id);
			ps.executeUpdate();

		}catch (Exception e) {e.printStackTrace();}
		
	}


}
