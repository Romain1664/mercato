package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Compte;
import model.Context;
import model.Joueur;

/**
 * Servlet implementation class joueur
 */
@WebServlet("/joueur")
public class joueur extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if(action==null)
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
		}
		else if(action.equals("inscription")) 
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/entreeStat.jsp").forward(request, response);
		}
		
		else if(action.equals("desinscription")) 
		{
			Joueur c = (Joueur) request.getSession().getAttribute("Compte");
			c.deleteBdd(c.getId());
			this.getServletContext().getRequestDispatcher("/WEB-INF/desinscription.jsp").forward(request, response);
		}
		else if(action.equals("stats")) 
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/stats.jsp").forward(request, response);
		}
		else if(action.equals("joueurs")) 
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/joueurs.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		if(action.equals("achatJoueur")) 
		{
			
		}
		else if(action.equals("venteJoueur")) 
		{
			
		}
		
	}

}