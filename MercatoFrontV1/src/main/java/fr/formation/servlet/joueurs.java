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
import fr.formation.model.Context;
import fr.formation.model.Equipe;
import fr.formation.model.Joueur;


@WebServlet("/joueurs")
public class joueurs extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOJoueur daoJoueur = myContext.getBean(IDAOJoueur.class);
		
		String action=request.getParameter("action");
				
		
		if(action.equals("Tous"))
		{
			System.out.println("OK TOUS");
			List<Joueur> liste = daoJoueur.findAll();		
			request.getSession().setAttribute("joueurs",liste);
			this.getServletContext().getRequestDispatcher("/WEB-INF/joueurs.jsp").forward(request, response);
			
		}
		else if(action.equals("Equipe"))
		{
			System.out.println("OK EQUIPE");
			IDAOEquipe daoEquipe = myContext.getBean(IDAOEquipe.class);
			
			Compte c = (Compte) request.getSession().getAttribute("compte");
			int id_compte=c.getId();
			
			Equipe eq = daoEquipe.findByManager(id_compte);
			int id_equipe = eq.getId();
			
			List<Joueur> liste = daoJoueur.findByEquipe(id_equipe);
			
			request.getSession().setAttribute("joueurs",liste);
			this.getServletContext().getRequestDispatcher("/WEB-INF/joueursEquipe.jsp").forward(request, response);
		}
		
//		else if(action.equals("Achat"))
//		{
//			System.out.println("OK Achat");
//			IDAOEquipe daoEquipe = myContext.getBean(IDAOEquipe.class);
//			
//			
//			int id_compte=0;
//			
//			Equipe eq = daoEquipe.findByManager(id_compte);
//			int id_equipe = eq.getId();
//			
//			List<Joueur> liste = daoJoueur.findByEquipe(id_equipe);
//			
//			request.getSession().setAttribute("joueursAchat",liste);
//			this.getServletContext().getRequestDispatcher("/WEB-INF/achatJoueur1.jsp").forward(request, response);
//		}
//		
//		else if(action.equals("Vente"))
//		{
//			System.out.println("OK Vente");
//			IDAOEquipe daoEquipe = myContext.getBean(IDAOEquipe.class);
//			
//			Compte c = (Compte) request.getSession().getAttribute("compte");
//			int id_compte=c.getId();
//			
//			Equipe eq = daoEquipe.findByManager(id_compte);
//			int id_equipe = eq.getId();
//			
//			List<Joueur> liste = daoJoueur.findByEquipe(id_equipe);
//			
//			request.getSession().setAttribute("joueursEquipe",liste);
//			this.getServletContext().getRequestDispatcher("/WEB-INF/VenteJoueur1.jsp").forward(request, response);
//		}
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/joueurs.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOJoueur daoJoueur = myContext.getBean(IDAOJoueur.class);
		
		int idEquipe = Integer.parseInt(request.getParameter("id_equipe"));
		List<Joueur> equipe = daoJoueur.findByEquipe(idEquipe);
		
		request.setAttribute("joueurs", equipe);		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/joueursEquipe.jsp").forward(request, response);
	}

}
