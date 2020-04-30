package servlet;

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
import fr.formation.model.Context;
import fr.formation.model.Joueur;

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
			AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
			IDAOJoueur daoJoueur = myContext.getBean(IDAOJoueur.class);
			
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
			
			Joueur j= new Joueur(c.getId(),nom,prenom,age,poste,tir,precision,acceleration,puissance,tacle,marquage,1,prix);
			
			daoJoueur.insert(j);
			
			request.getSession().setAttribute("joueurInscrit", "Y");
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
		}
		 
		 if(action.equals("modifStat")) 
			{
			 	AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
				IDAOJoueur daoJoueur = myContext.getBean(IDAOJoueur.class);
			 
			 	Compte c = (Compte) request.getSession().getAttribute("compte");
			 	Joueur j = daoJoueur.findById(c.getId()).get();
			 	
				int tir = Integer.parseInt(request.getParameter("tir"));
				int precision = Integer.parseInt(request.getParameter("precision"));
				int acceleration = Integer.parseInt(request.getParameter("acceleration"));
				int puissance = Integer.parseInt(request.getParameter("puissance"));
				int tacle = Integer.parseInt(request.getParameter("tacle"));
				int marquage = Integer.parseInt(request.getParameter("marquage"));
				
				j.setTir(tir);
				j.setPrecision(precision);
				j.setAcceleration(acceleration);
				j.setPuissance(puissance);
				j.setTacle(tacle);
				j.setMarquage(marquage);
				
				daoJoueur.save(j);
				
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
