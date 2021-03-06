package fr.formation.daObsolete.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoJdbc {
	
	protected static Connection connect=null;
	
	public DaoJdbc() {
		try
		{
			if (connect==null)
			{
				Class.forName("com.mysql.jdbc.Driver");
				connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_mercato","root","");
			}
		}
		catch (Exception e) {}
	}
	
	public static void close() throws SQLException {
		connect.close();
	}
}