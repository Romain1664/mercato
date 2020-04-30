package servlet;


import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.configSpring.AppConfig;
import fr.formation.daoSpring.IDAOCompte;
import fr.formation.daoSpring.IDAOJoueur;
import fr.formation.model.Compte;
import fr.formation.model.Context;
import fr.formation.model.Joueur;
import fr.formation.model.Manager;


@WebServlet("/connection")
public class connection extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action");
		if(action==null) 
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
		}
		else if(action.equals("reset"))
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
		}
		else 
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action");

		if(action.equals("reset")) 
		{
			AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
			IDAOCompte daoCompte = myContext.getBean(IDAOCompte.class);
			
			String login = request.getParameter("login");
			String password = request.getParameter("nouveau password");

			Compte c = daoCompte.findByLogin(login);
			
			if (c!=null)
			{
				c.setPassword(password);
				daoCompte.save(c);
				this.getServletContext().getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
			}
			else
			{
				//Ajouter message erreur
				this.getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
			}
			

		}
		else if(action.equals("identification")) 
		{
			AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
			IDAOCompte daoCompte = myContext.getBean(IDAOCompte.class);
			IDAOJoueur daoJoueur = myContext.getBean(IDAOJoueur.class);
			
			String login = request.getParameter("login");
			String password = request.getParameter("password");

			Compte c = daoCompte.checkConnect(login, password);
			request.getSession().setAttribute("login", login);
			
			if (c==null) 
			{
				request.getSession().setAttribute("isConnect", "N");
				doGet(request, response);
			}
			else if(c.getType().equals("joueur"))
			{
				request.getSession().setAttribute("compte", c);
				request.getSession().setAttribute("typeAccount", "Joueur");
				request.getSession().setAttribute("isConnect", "Y");
				
				Optional<Joueur> j = daoJoueur.findById(c.getId());
				
				if (!j.isPresent()) {request.getSession().setAttribute("joueurInscrit", "N");}
				else {request.getSession().setAttribute("joueurInscrit", "Y");}

				this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
			}
			else if (c.getType().equals("manager"))
			{
				request.getSession().setAttribute("compte", c);
				request.getSession().setAttribute("typeAccount", "Manager");
				request.getSession().setAttribute("isConnect", "Y");

				this.getServletContext().getRequestDispatcher("/WEB-INF/manager.jsp").forward(request, response);
			}

		}
	}
}