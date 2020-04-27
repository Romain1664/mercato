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
		System.out.println(action);
		
		if(action.equals("entreeStat")) 
		{
			Compte c = (Compte) request.getSession().getAttribute("compte");
			System.out.println(c.getId());
			
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
			request.getSession().setAttribute("joueur", j2);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
		}
		 
		 if(action.equals("modifStat")) 
			{
			 	Joueur j1 = (Joueur) request.getSession().getAttribute("compte");
			 	
				int tir = Integer.parseInt(request.getParameter("tir"));
				int precision = Integer.parseInt(request.getParameter("precision"));
				int acceleration = Integer.parseInt(request.getParameter("acceleration"));
				int puissance = Integer.parseInt(request.getParameter("puissance"));
				int tacle = Integer.parseInt(request.getParameter("tacle"));
				int marquage = Integer.parseInt(request.getParameter("marquage"));
				
				Joueur j2= new Joueur(j1.getId(),j1.getNom(),j1.getPrenom(),j1.getAge(),j1.getPoste(),tir,precision,acceleration,puissance,tacle,marquage,j1.getId_equipe(),j1.getPrix());
				
				Context.getDaoJoueur().update(j2);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
			}
		
	}

}
