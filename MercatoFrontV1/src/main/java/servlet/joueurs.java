package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Context;
import model.Joueur;


/**
 * Servlet implementation class joueur
 */
@WebServlet("/joueurs")
public class joueurs extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	/*	List<Joueur> liste = Context.getDaoJoueur().selectAll();
		System.out.println("Ok");
		System.out.println(liste);
		request.getSession().setAttribute("listeJoueurs",liste);
		*/
		String action=request.getParameter("action");
				
		if(action==null)
		{
			List<Joueur> liste = Context.getDaoJoueur().selectAll();		
			request.getSession().setAttribute("joueurs",liste);
			this.getServletContext().getRequestDispatcher("/WEB-INF/joueurs.jsp").forward(request, response);
		}
		
		else if(action.contentEquals("joueursEquipe"))
		{
		
			this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(request, response);
		}

	
		this.getServletContext().getRequestDispatcher("/WEB-INF/joueurs.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		int idEquipe = Integer.parseInt(request.getParameter("id_equipe"));
		List<Joueur> equipe = Context.getDaoJoueur().selectByEquipe(idEquipe);
		request.setAttribute("joueurs", equipe);		
		this.getServletContext().getRequestDispatcher("/WEB-INF/joueursEquipe.jsp").forward(request, response);
		
	}

}
