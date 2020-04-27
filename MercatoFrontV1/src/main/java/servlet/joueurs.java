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
import model.Manager;

/**
 * Servlet implementation class joueur
 */
@WebServlet("/joueurs")
public class joueurs extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		

		List<Joueur> liste = Context.getDaoJoueur().selectAll();		
		request.getSession().setAttribute("joueurs",liste);
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/joueurs.jsp").forward(request, response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
		
	}

}
