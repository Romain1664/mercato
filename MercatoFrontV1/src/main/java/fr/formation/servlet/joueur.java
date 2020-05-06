package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.configSpring.AppConfig;
import fr.formation.daoSpring.IDAOJoueur;
import fr.formation.model.Compte;
import fr.formation.model.Joueur;

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
			AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
			IDAOJoueur daoJoueur = myContext.getBean(IDAOJoueur.class);
			
			Compte c = (Compte) request.getSession().getAttribute("compte");
			Joueur j = daoJoueur.findById(c.getId()).get();
			
			System.out.println(j.getId());
			
			daoJoueur.deleteById(j.getId());
			request.getSession().setAttribute("joueurInscrit", "N");
			request.getSession().removeAttribute("joueur");
			this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
		}
		
		else if(action.substring(0,5).equals("stats")) 
		{
			AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
			IDAOJoueur daoJoueur = myContext.getBean(IDAOJoueur.class);
			
			Compte c = (Compte) request.getSession().getAttribute("compte");
			Joueur j = daoJoueur.findById(c.getId()).get();
			
			request.getSession().setAttribute("tir", j.getTir());
			request.getSession().setAttribute("precision", j.getPrecision());
			request.getSession().setAttribute("acceleration", j.getAcceleration());
			request.getSession().setAttribute("puissance", j.getPuissance());
			request.getSession().setAttribute("tacle", j.getTacle());
			request.getSession().setAttribute("marquage", j.getMarquage());	

			
			if (action.substring(5).equals("Afficher")) 
			{
				this.getServletContext().getRequestDispatcher("/WEB-INF/statsAfficher.jsp").forward(request, response);
			}
			else if (action.substring(5).equals("Modifier")) 
			{
				this.getServletContext().getRequestDispatcher("/WEB-INF/statsModifier.jsp").forward(request, response);
			}
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