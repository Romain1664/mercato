package fr.formation.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.configSpring.AppConfig;
import fr.formation.daoSpring.IDAOCompte;
import fr.formation.daoSpring.IDAOEquipe;
import fr.formation.model.Compte;
import fr.formation.model.Context;
import fr.formation.model.Equipe;

/**
 * Servlet implementation class désinscription
 */
@WebServlet("/inscription")
public class inscription extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOCompte daoCompte = myContext.getBean(IDAOCompte.class);
		IDAOEquipe daoEquipe = myContext.getBean(IDAOEquipe.class);
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String type = request.getParameter("type");

		Compte c = new Compte(login,password,type);

		daoCompte.save(c);
		
		if (request.getParameter("choix").equals("oui"))
			{
			String nom_equipe = request.getParameter("nom_equipe");
			Double budget = Double.parseDouble(request.getParameter("budget"));
			
			Equipe eq = new Equipe(nom_equipe, c.getId(), budget);
			
			daoEquipe.save(eq);
			}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);

		
	}

}