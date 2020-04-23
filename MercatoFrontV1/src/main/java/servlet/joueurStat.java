package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Compte;
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
		
		Joueur j1 = (Joueur) request.getSession().getAttribute("Compte");
		
		if(action.equals("entreeStat")) 
		{
			int id_compte = (int) request.getSession().getAttribute("id_compte");
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
			
			int id_equipe = Integer.parseInt(request.getParameter("id_equipe"));
			Double prix = Double.parseDouble(request.getParameter("prix"));
			
			
			Joueur j= new Joueur(id_compte,nom,prenom,age,poste,tir,precision,acceleration,puissance,tacle,marquage,id_equipe,prix);

			Compte.getDaoJoueur().insert(j);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
		}
		 
		 if(action.equals("modifStat")) 
			{
				int tir = Integer.parseInt(request.getParameter("tir"));
				int precision = Integer.parseInt(request.getParameter("precision"));
				int acceleration = Integer.parseInt(request.getParameter("acceleration"));
				int puissance = Integer.parseInt(request.getParameter("puissance"));
				int tacle = Integer.parseInt(request.getParameter("tacle"));
				int marquage = Integer.parseInt(request.getParameter("marquage"));
				
				Joueur j= new Joueur(j1.getId(),j1.getNom(),j1.getPrenom(),j1.getAge(),j1.getPoste(),tir,precision,acceleration,puissance,tacle,marquage,j1.getId_equipe(),j1.getPrix());
				
				Compte.getDaoJoueur().update(j);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
			}
		
	}

}
