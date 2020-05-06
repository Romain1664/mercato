package fr.formation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.configSpring.AppConfig;
import fr.formation.daoSpring.IDAOEquipe;
import fr.formation.daoSpring.IDAOJoueur;
import fr.formation.model.Compte;
import fr.formation.model.Equipe;
import fr.formation.model.Joueur;

/**
 * Servlet implementation class manager
 */
@WebServlet("/manager")
public class manager extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOJoueur daoJoueur = myContext.getBean(IDAOJoueur.class);
		String action=request.getParameter("action");
		
		if(action==null)
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/manager.jsp").forward(request, response);
		}
		else if(action.equals("gestionBudget")) 
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/gestionBudget.jsp").forward(request, response);
		}
		
		else if(action.equals("joueurs")) 
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/joueurs.jsp").forward(request, response);
		}
		
		else if(action.equals("achatJoueur")) 
		{
			System.out.println("OK Achat");
			IDAOEquipe daoEquipe = myContext.getBean(IDAOEquipe.class);

			Compte c = (Compte) request.getSession().getAttribute("compte");
			int id_compte=c.getId();
			
			Equipe eq = daoEquipe.findByManager(id_compte);
			double budget = eq.getBudget();
			
			System.out.println(budget);
			
			List<Joueur> liste = daoJoueur.findLibreByBudget(budget);
			
			request.getSession().setAttribute("joueurs",liste);

			this.getServletContext().getRequestDispatcher("/WEB-INF/joueurAchat.jsp").forward(request, response);
		}
		
		else if(action.equals("venteJoueur")) 
		{
			System.out.println("OK Vente");
			IDAOEquipe daoEquipe = myContext.getBean(IDAOEquipe.class);
			
			Compte c = (Compte) request.getSession().getAttribute("compte");
			int id_compte=c.getId();
			
			Equipe eq = daoEquipe.findByManager(id_compte);
			int id_equipe = eq.getId();
			
			List<Joueur> liste = daoJoueur.findByEquipe(id_equipe);
			
			request.getSession().setAttribute("joueurs",liste);
			this.getServletContext().getRequestDispatcher("/WEB-INF/joueurVente.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		 if(action.equals("achatJoueur2")) 
		{
				this.getServletContext().getRequestDispatcher("/WEB-INF/achatJoueur2.jsp").forward(request, response);
		}
			
		else if(action.equals("achatJoueur3")) 
		{
				this.getServletContext().getRequestDispatcher("/WEB-INF/achatJoueur3.jsp").forward(request, response);
		}
				
	
			
		else if(action.equals("venteJoueur2")) 
		{	
				this.getServletContext().getRequestDispatcher("/WEB-INF/venteJoueur2.jsp").forward(request, response);
		}
			
		else if(action.equals("venteJoueur3")) 
		{	
				this.getServletContext().getRequestDispatcher("/WEB-INF/venteJoueur3.jsp").forward(request, response);
		}
		
		
	}

}