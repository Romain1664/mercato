package dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DaoJpa {
	
	private static EntityManagerFactory emf;
	protected EntityManager em;
	
	public DaoJpa() {
		try
		{
			if (emf==null)
			{
				Class.forName("com.mysql.jdbc.Driver");
				emf = Persistence.createEntityManagerFactory("MercatoUnit");
			}
			em=emf.createEntityManager();
		}
		catch (Exception e) {}
	}
	
	public static void close() {
		emf.close();
	}
}