package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Joueur;

/**
 * Servlet implementation class manager
 */
@WebServlet("/manager")
public class manager extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		else if(action.equals("achatJoueur1")) 
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/achatJoueur1.jsp").forward(request, response);
		}
		
		else if(action.equals("venteJoueur1")) 
		{
				this.getServletContext().getRequestDispatcher("/WEB-INF/venteJoueur1.jsp").forward(request, response);
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