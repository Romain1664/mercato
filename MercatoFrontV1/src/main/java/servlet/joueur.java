package servlet;

import java.io.IOException;

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
		System.out.println(action);
		
		
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
			Joueur j = (Joueur) request.getSession().getAttribute("joueur");
			Context.getDaoJoueur().delete(j.getId());
			request.getSession().setAttribute("joueurInscrit", "N");
			request.getSession().removeAttribute("joueur");
			this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
		}
		
		else if(action.substring(0,5).equals("stats")) 
		{
			Joueur j = (Joueur) request.getSession().getAttribute("joueur");
			request.getSession().setAttribute("tir", j.getTir());
			request.getSession().setAttribute("precision", j.getPrecision());
			request.getSession().setAttribute("acceleration", j.getAcceleration());
			request.getSession().setAttribute("puissance", j.getPuissance());
			request.getSession().setAttribute("tacle", j.getTacle());
			request.getSession().setAttribute("marquage", j.getMarquage());	
			
			System.out.println(action.substring(5));
			
			if (action.substring(5).equals("Afficher")) {this.getServletContext().getRequestDispatcher("/WEB-INF/statsAfficher.jsp").forward(request, response);}
			else if (action.substring(5).equals("Modifier")) {this.getServletContext().getRequestDispatcher("/WEB-INF/statsModifier.jsp").forward(request, response);}
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