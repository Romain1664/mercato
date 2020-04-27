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
@WebServlet("/joueurStat")
public class joueurStat extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Doit envoyer vers stats.jsp
		this.getServletContext().getRequestDispatcher("/WEB-INF/stats.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		if(action.equals("entreeStat")) 
		{
			Compte c = (Compte) request.getSession().getAttribute("compte");
			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			int age = Integer.parseInt(request.getParameter("age"));
			String poste = request.getParameter("poste");
			int tir = Integer.parseInt(request.getParameter("tir"));
			int precision = Integer.parseInt(request.getParameter("precision"));
			int acceleration = Integer.parseInt(request.getParameter("acceleration"));
			int puissance = Integer.parseInt(request.getParameter("puissance"));
			int tacle = Integer.parseInt(request.getParameter("tacle"));
			int marquage = Integer.parseInt(request.getParameter("marquage"));
			Double prix = Double.parseDouble(request.getParameter("prix"));
			
			Joueur j2= new Joueur(c.getId(),nom,prenom,age,poste,tir,precision,acceleration,puissance,tacle,marquage,1,prix);
			
			Context.getDaoJoueur().insert(j2);
			request.getSession().setAttribute("joueurInscrit", "Y");
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
		}
		 
		 if(action.equals("modifStat")) 
			{
			 	Compte c = (Compte) request.getSession().getAttribute("compte");
			 	Joueur j1 = (Joueur) Context.getDaoJoueur().selectById(c.getId());
			 	
				int tir = Integer.parseInt(request.getParameter("tir"));
				int precision = Integer.parseInt(request.getParameter("precision"));
				int acceleration = Integer.parseInt(request.getParameter("acceleration"));
				int puissance = Integer.parseInt(request.getParameter("puissance"));
				int tacle = Integer.parseInt(request.getParameter("tacle"));
				int marquage = Integer.parseInt(request.getParameter("marquage"));
				
				j1.setTir(tir);
				j1.setPrecision(precision);
				j1.setAcceleration(acceleration);
				j1.setPuissance(puissance);
				j1.setTacle(tacle);
				j1.setMarquage(marquage);
				
				Context.getDaoJoueur().update(j1);
				
				request.getSession().removeAttribute("tir");
				request.getSession().removeAttribute("precision");
				request.getSession().removeAttribute("acceleration");
				request.getSession().removeAttribute("puissance");
				request.getSession().removeAttribute("tacle");
				request.getSession().removeAttribute("marquage");
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
			}
		
	}

}
