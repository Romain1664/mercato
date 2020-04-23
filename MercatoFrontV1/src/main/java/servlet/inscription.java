package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Compte;
import model.Context;

/**
 * Servlet implementation class désinscription
 */
@WebServlet("/inscription")
public class inscription extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String login = (String) request.getSession().getAttribute("login");
		String password = (String) request.getSession().getAttribute("password");
		String type = (String) request.getSession().getAttribute("type");

		Compte c = new Compte(login,password,type);


		Context.getDaoCompte().insert(c);
		this.getServletContext().getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);


		//Doit vérifier le type de compte et demander des infos supplémentaire

		doGet(request, response);
	}

}