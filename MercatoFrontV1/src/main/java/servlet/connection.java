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
import model.Manager;


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
			String login = request.getParameter("login");
			String password = request.getParameter("nouveau password");

			Compte c = Context.getDaoCompte().selectByLogin(login);

			Compte c1 = new Compte (c.getId(),login,password,c.getType());

			Context.getDaoCompte().update(c1);

			this.getServletContext().getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);

		}
		else if(action.equals("identification")) 
		{
			String login = request.getParameter("login");
			String password = request.getParameter("password");

			Compte c = Context.getDaoCompte().checkConnect(login, password);
			request.getSession().setAttribute("Login", login);
			
			if(c instanceof Joueur)
			{
				request.getSession().setAttribute("compte", c);
				request.getSession().setAttribute("typeAccount", "Joueur");
				request.getSession().setAttribute("isConnect", "Y");
				
				Joueur j = Context.getDaoJoueur().selectById(c.getId());
				
				if (j==null) {request.getSession().setAttribute("joueurInscrit", "N");}
				else {request.getSession().setAttribute("joueurInscrit", "Y"); request.getSession().setAttribute("joueur", j);}

				this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
			}
			else if (c instanceof Manager)
			{
				request.getSession().setAttribute("compte", c);
				request.getSession().setAttribute("typeAccount", "Manager");
				request.getSession().setAttribute("isConnect", "Y");

				this.getServletContext().getRequestDispatcher("/WEB-INF/manager.jsp").forward(request, response);
			}
			else 
			{
				request.getSession().setAttribute("isConnect", "N");
				doGet(request, response);
			}

		}
	}
}