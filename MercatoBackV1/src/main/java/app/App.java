package app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.idao.IDAOCompte;
import dao.jdbc.DAOCompteJdbc;
import model.Compte;
import model.Context;
import model.Equipe;
import model.Joueur;
import model.Manager;


public class App {

	static Compte c= null;
	
	public static String demandeStringListe (ArrayList<String> liste_choix, String Question) {
		String Choix="";
		
		do {Choix=saisieString(Question);}
		while (!(liste_choix.contains(Choix)));
		
		return Choix;
	}
	
	public static String saisieString(String msg) {

		Scanner sc = new Scanner(System.in);
		System.out.println(msg);

		return sc.nextLine();
	}

	public static int saisieInt(String msg) {

		Scanner sc = new Scanner(System.in);
		System.out.println(msg);

		return sc.nextInt();
	}

	public static double saisieDouble(String msg) {

		Scanner sc = new Scanner(System.in);
		System.out.println(msg);

		return sc.nextDouble();
	}
	
	public static boolean reessayer(String Question) {
	String reessayer = "";
	
	do {reessayer=saisieString(Question +" (y n)");}
	while (!reessayer.equals("y") && !reessayer.equals("n"));
	
	return (reessayer.equals("y")) ? true : false;
	}
	
	
	
	public static void accueil() {
		
		System.out.println("Bienvenue sur l'appli Mercato" + "\n");
		System.out.println("1 - Se connecter");
		System.out.println("2 - S'inscrire");
		System.out.println("3 - Mot de passe perdu ?");
		System.out.println("4 - Quitter");
		System.out.print(System.lineSeparator());
		
		int Choix = 0 ;
		
		while (Choix<1 || Choix>4) 
		{
			try
			{
				Choix=saisieInt("Indiquez votre choix.");
			}
			catch(InputMismatchException i) 
			{
				System.out.println("Je n'ai pas compris votre demande.");
				System.out.println("Veuillez rentrer un entier." + "\n");
			}
		}
		
		System.out.print("\n");
		
		
		switch (Choix)
		{
			case 1 : {menuconnect();accueil();break;}
			case 2 : {menuinscription();accueil();break;}
			case 3 : {passwordPerdu();accueil();break;}
			case 4 : {System.out.println("Merci et à bientôt !");System.exit(0);break;}
		}
		
	}
		
	public static void menuinscription() {
		
		Compte c = new Compte();

		String login = saisieString("Choississez votre login : ");
		System.out.print(System.lineSeparator());
		
		while (c.checkLogin(login)!=null)
		{
			System.out.println("Ce login existe déjà. Veuillez en choisir un autre.");
			login = saisieString("Choississez votre login : ");
			System.out.print(System.lineSeparator());
		}
		
		String password = saisieString("Choississez votre password : ");
		System.out.print(System.lineSeparator());
		
		ArrayList<String> listeChoix = new ArrayList<String>();
		listeChoix.add("joueur");
		listeChoix.add("manager");
		
		String type = demandeStringListe(listeChoix, "Etes vous un \"joueur\" ou un \"manager\" ?");
		System.out.print(System.lineSeparator());

		if (type.equals("manager")) 
		{
			String equipe=saisieString("De quelle équipe êtes-vous le manager ?");
			System.out.print(System.lineSeparator());
			
			Equipe eq = new Equipe();
			eq=Context.getDaoEquipe().selectByNomEquipe(equipe);
			
			if (eq!=null) 
			{
				System.out.println("Cette équipe existe déjà. Demandez à l'actuel manager de vous donner les accès.");
				System.out.print(System.lineSeparator());
				c=new Compte(login, password, type);	 
				Context.getDaoCompte().insert(c);
			}
			else
			{
				Double budget = saisieDouble("Quel budget avez-vous pour l'équipe ?");
				System.out.print(System.lineSeparator());
				
				c=new Compte(login, password, type);	 
				Context.getDaoCompte().insert(c);
				
				Compte c2 = Context.getDaoCompte().selectByLogin(c.getLogin());
				
				Equipe eq2= new Equipe (equipe,c2.getId(),budget);
				Context.getDaoEquipe().insert(eq2);
				
				System.out.println("L'équipe a été ajouté à la base de donnée.");
			}
			
		}
		else
		{
			c=new Compte(login, password, type);	 
			Context.getDaoCompte().insert(c);
		}

		
		System.out.println("Votre inscription a été un succès !");
		System.out.print(System.lineSeparator());
		
	}
	
	public static void menuconnect() {
		String login=saisieString("Saisir votre login : ");
		System.out.print(System.lineSeparator());
		String password=saisieString("Saisir votre password : ");
		System.out.print(System.lineSeparator());
		
		c = Context.getDaoCompte().checkConnect(login, password);
		
		if(c==null) 
		{
			System.out.println("Identifiants invalides.");
			System.out.println("Si vous avez oubliez votre mot de passe, se référer à \"3 - Mot de passe perdu ?\"");
			System.out.print(System.lineSeparator());
			accueil();
		}
		else {
			switch(c.getType()) 
			{
			case "joueur" : menuJoueur();break;
			case "manager" : menuManager();break;
			}
		}
	}
	
	public static void passwordPerdu() {

		c=new Compte();
		
		String login = saisieString("Choississez votre login : ");
		System.out.print(System.lineSeparator());
		
		c=c.selectByLogin(login);	
		
		if (c==null) {System.out.println("Ce compte n'existe pas.");System.out.print(System.lineSeparator());}
		else
		{
			String password=saisieString("Quel est votre nouveau password ?");
			c.setPassword(password);
			System.out.print(System.lineSeparator());
		}
	}
		
	
	
	public static void menuManager() {
				
		Equipe eq = Context.getDaoEquipe().selectById(c.getId());
		
		if (eq==null)
		{
			System.out.println("Menu Manager : que voulez-vous faire ?" + "\n");
			System.out.println("1 - Regarder la liste des joueurs");
			System.out.println("2 - Regarder vos joueurs");
			System.out.println("3 - Changer le budget");
			System.out.println("4 - Acheter un joueur");
			System.out.println("5 - Vendre un joueur");
			System.out.println("6 - Leguer la gestion du club");
			System.out.println("7 - Se déconnecter");
			System.out.print(System.lineSeparator());
			
			int choix = 0 ;
			
			while (choix<1 || choix>7) 
			{
				try
				{
					choix=saisieInt("Indiquez votre choix.");
				}
				catch(InputMismatchException i) {System.out.println("Veuillez rentrer un entier" + "\n");}
			}
			
			switch (choix)
			{
				case 1 : {c.listeJoueur();menuManager();break;}
				case 2 : {listeJoueurEquipe();menuManager();break;}
				case 3 : {updateBudget();menuManager();break;}
				case 4 : {acheterJoueur();menuManager();break;}
				case 5 : {vendreJoueur();menuManager();break;}
				case 6 : {leguer();menuManager();break;}
				case 7 : {System.out.println("Vous êtes déconnecté.");accueil();break;}
			}
		}
		
		else
		{
			System.out.println("Menu Manager : que voulez-vous faire ?" + "\n");
			System.out.println("1 - Regarder la liste des joueurs");
			System.out.println("2 - Regarder vos joueurs");
			System.out.println("3 - Changer le budget");
			System.out.println("4 - Acheter un joueur");
			System.out.println("5 - Vendre un joueur");
			System.out.println("6 - Leguer la gestion du club");
			System.out.println("7 - Se déconnecter");
			System.out.print(System.lineSeparator());
			
			int choix = 0 ;
			
			while (choix<1 || choix>7) 
			{
				try
				{
					choix=saisieInt("Indiquez votre choix.");
				}
				catch(InputMismatchException i) {System.out.println("Veuillez rentrer un entier" + "\n");}
			}
			
			switch (choix)
			{
				case 1 : {c.listeJoueur();menuManager();break;}
				case 2 : {listeJoueurEquipe();menuManager();break;}
				case 3 : {updateBudget();menuManager();break;}
				case 4 : {acheterJoueur();menuManager();break;}
				case 5 : {vendreJoueur();menuManager();break;}
				case 6 : {leguer();menuManager();break;}
				case 7 : {System.out.println("Vous êtes déconnecté.");accueil();break;}
			}
		}

	}

	public static void listeJoueurEquipe() {
		
		Equipe eq = Context.getDaoEquipe().selectById(c.getId());
		
		if (eq==null)
		{
			System.out.println("Vous n'avez pas d'équipe à gérer");
			System.out.print(System.lineSeparator());
		}
		else
		{
			((Manager) c).listeJoueurEquipe(eq.getId());
		}
		
	}
	
	public static void updateBudget() {
		
		Equipe eq = Context.getDaoEquipe().selectById(c.getId());

		if (eq==null)
		{
			System.out.println("Vous n'avez pas d'équipe à gérer");
			System.out.print(System.lineSeparator());
			
		}
		else
		{
			Double budget =saisieDouble("Quel est votre nouveau budget ?");
			System.out.print(System.lineSeparator());
			eq.setBudget(budget);
			Context.getDaoEquipe().update(eq);
			
			System.out.println("Le budget a été actualisé.");
			System.out.print(System.lineSeparator());
		}

	}
	
	public static void acheterJoueur() {
		
		Equipe eq = Context.getDaoEquipe().selectById(c.getId());

		if (eq==null)
		{
			System.out.println("Vous n'avez pas d'équipe à gérer");
			System.out.print(System.lineSeparator());
			
		}
		else
		{
			int choix=0;
			
			System.out.println("Votre budget est de " + eq.getBudget() + "€");
			System.out.print(System.lineSeparator());
			
			System.out.println("Voici la liste des joueurs disponible");
			
			((Manager) c).listeJoueurEquipeByBudget(1,eq.getBudget());
			
			choix=saisieInt("Indiquez votre choix de joueur ? (0 pour ne rien acheter)");
			
			if (choix!=0)
			{
				try
				{
					Joueur j = Context.getDaoJoueur().selectById(choix);
					System.out.print(System.lineSeparator());
					
					if (j.getId_equipe()!=1) {System.out.println("Ce joueur n'est pas disponible");acheterJoueur();}
					else 
					{
						j.setId_equipe(eq.getId());
						Context.getDaoJoueur().update(j);
						
						eq.setBudget(eq.getBudget()-j.getPrix());
						Context.getDaoEquipe().update(eq);
						
						System.out.println("Félicitation pour votre achat de " + j.getPrenom() + " " + j.getNom());
						System.out.print(System.lineSeparator());
					}
				}
				catch (Exception e) {System.out.println("Votre choix n'est pas valide");System.out.print(System.lineSeparator());}
			}
		}
		if (saisieString("Voulez-vous acheter un autre joueur ? (y pour oui)").equals("y")) {System.out.print(System.lineSeparator());acheterJoueur();}
		else {menuManager();}
	}
	
	public static void vendreJoueur() {
		Equipe eq = Context.getDaoEquipe().selectById(c.getId());

		if (eq==null)
		{
			System.out.println("Vous n'avez pas d'équipe à gérer");
			System.out.print(System.lineSeparator());
			
		}
		else
		{
			int choix=0;
			
			System.out.println("Votre budget est de " + eq.getBudget() + "€");
			System.out.print(System.lineSeparator());
			
			System.out.println("Voici la liste de vos joueurs");
			
			((Manager) c).listeJoueurEquipeByBudget(eq.getId(),eq.getBudget());
			
			choix=saisieInt("Indiquez votre choix de joueur ? (0 pour ne rien vendre)");
			
			if (choix!=0)
			{
				try
				{
					Joueur j = Context.getDaoJoueur().selectById(choix);
					
					if (j.getId_equipe()!=eq.getId()) {System.out.println("Ce joueur n'est pas à vendre");acheterJoueur();}
					else 
					{
						j.setId_equipe(1);
						Context.getDaoJoueur().update(j);
						
						eq.setBudget(eq.getBudget()+j.getPrix());
						Context.getDaoEquipe().update(eq);
						
						System.out.println("Félicitation pour la vente de " + j.getPrenom() + " " + j.getNom());
					}
				}
				catch (Exception e) {System.out.println("Votre choix n'est pas valide");System.out.print(System.lineSeparator());}
			}
		}
		if (saisieString("Voulez-vous vendre un autre joueur ? (y pour oui)").equals("y")) {System.out.print(System.lineSeparator());vendreJoueur();}
		else {menuManager();}
	}

	public static void leguer() {
		
		Equipe eq = Context.getDaoEquipe().selectById(c.getId());

		if (eq==null)
		{
			System.out.println("Vous n'avez pas d'équipe à gérer");
			System.out.print(System.lineSeparator());
			
		}
		else
		{
			String nouveauManager = saisieString("Quel est le login du nouveau manager ?");
			
			Compte c2=Context.getDaoCompte().selectByLogin(nouveauManager);
			
			if (c2==null) 
			{
				System.out.println("Ce compte n'existe pas.");
				System.out.print(System.lineSeparator());
			}
			else if (c2.getType().equals("joueur"))
			{
				System.out.println("Vous ne pouvez pas léguer le club à un joueur.");
				System.out.print(System.lineSeparator());
			}
			else if (c2.getType().equals("manager"))
			{
				eq.setId_new_compte(c2.getId());
				Context.getDaoEquipe().update(eq);
			}
		}
	}

	
	
	public static void menuJoueur() {
		System.out.println("Menu Joueur : que voulez-vous faire ?" + "\n");
		System.out.println("1 - Regarder la liste des joueurs");
		System.out.println("2 - S'ajouter dans la base de données des joueurs");
		System.out.println("3 - Se retirer de la base de donnée");
		System.out.println("4 - Regarder ses stats");
		System.out.println("5 - Changer ses stats");
		System.out.println("6 - Changer son prix");
		System.out.println("7 - Se déconnecter");
		System.out.print(System.lineSeparator());
		
		int choix = 0 ;
		
		while (choix<1 || choix>7) 
		{
			try
			{
				choix=saisieInt("Indiquez votre choix.");
			}
			catch(InputMismatchException i) {System.out.println("Veuillez rentrer un entier" + "\n");}
		}
		
		switch (choix)
		{
			case 1 : {c.listeJoueur();menuJoueur();break;}
			case 2 : {addBdd();menuJoueur();break;}
			case 3 : {deleteBdd();menuJoueur();break;}
			case 4 : {regarderStat();;menuJoueur();break;}
			case 5 : {changerStat();;menuJoueur();break;}
			case 6 : {changerPrix();;menuJoueur();break;}
			case 7 : {System.out.println("Vous êtes déconnecté.");accueil();break;}
		}
	}
	
	public static void addBdd() {

		try
		{
			int id_compte = c.getId();
			
			String nom=saisieString("Saisir votre nom");
			String prenom=saisieString("Saisir votre nom");
			
			int age=saisieInt("Saisir votre age");
			
			int tir=saisieInt("Saisir votre statistique de tir");
			int precision=saisieInt("Saisir votre statistique de précision");
			int acceleration=saisieInt("Saisir votre statistique d'accélération");
			int puissance=saisieInt("Saisir votre statistique de puissance");
			int tacle=saisieInt("Saisir votre statistique de tacle");
			int marquage=saisieInt("Saisir votre statistique de marquage");
			
			String poste = saisieString("Saisir votre poste");
			
			Double prix = saisieDouble("Saisir votre prix");
			
			c = new Joueur(id_compte, nom, prenom, age, poste, tir, precision, acceleration, puissance, tacle, marquage, 0, prix);
			
		}
		catch (Exception e) {System.out.println("Veuillez rentrer des informations au format valide");addBdd();}
		
		try
		{
			Context.getDaoJoueur().insert((Joueur) c);
			System.out.println("Vous avez été ajouté à la base de donnée");
		}
		catch (Exception e) {e.printStackTrace();}
		
	}

	public static void deleteBdd() {
		
		String Choix="";
		
		do {Choix=saisieString("Etes vous sûr de vous ? (y n)");}
		while (!(Choix.equals("y")) && !(Choix.equals("n")));
		
		if (Choix.equals("y")) 
		{
			try
			{
				Context.getDaoJoueur().delete(c.getId());
			}
			catch (Exception e) {e.printStackTrace();}
			}
		
		else {System.out.println("Vous avez annulé votre demande");}
		
	}
	
	public static void regarderStat() {
		
		((Joueur) c).regarderStat(c.getId());
		
	}
	
	public static void changerStat() {
		
		Joueur j = new Joueur();
		
		j = Context.getDaoJoueur().selectById(c.getId());
		
		if (j==null)
		{
			System.out.println("Vous n'êtes pas dans la base de donnée joueur, veuillez vous inscire d'abord.");
			System.out.print(System.lineSeparator());
		}
		else 
		{	
			System.out.println("Rapel de vos anciennes stats : ");
			
			regarderStat();
			
			try
			{
				int tir=saisieInt("Saisir votre statistique de tir");
				int precision=saisieInt("Saisir votre statistique de précision");
				int acceleration=saisieInt("Saisir votre statistique d'accélération");
				int puissance=saisieInt("Saisir votre statistique de puissance");
				int tacle=saisieInt("Saisir votre statistique de tacle");
				int marquage=saisieInt("Saisir votre statistique de marquage");
				
				j=new Joueur(j.getId(), j.getNom(), j.getPrenom(), j.getAge(), j.getPoste(), tir, precision, acceleration, puissance, tacle, marquage, j.getId_equipe(), j.getPrix());
				
				Context.getDaoJoueur().update(j);
			}
			catch (Exception e) {System.out.println("Veuillez rentrer des informations au format valide");addBdd();}
		}
	}
	
	public static void changerPrix() {
		
		Joueur j = new Joueur();
		
		j = Context.getDaoJoueur().selectById(c.getId());
		
		if (j==null)
		{
			System.out.println("Vous n'êtes pas dans la base de donnée joueur, veuillez vous inscire d'abord.");
			System.out.print(System.lineSeparator());
		}
		else 
		{	
			
			try
			{
				System.out.println("Votre ancien prix était de " + j.getPrix() + "€");
				int prix=saisieInt("Saisir votre nouveau prix :");
				
				j=new Joueur(j.getId(), j.getNom(), j.getPrenom(), j.getAge(), j.getPoste(), j.getTir(), j.getPrecision(), j.getAcceleration(), j.getPuissance(), j.getTacle(), j.getMarquage(), j.getId_equipe(), prix);
				
				Context.getDaoJoueur().update(j);
			}
			catch (Exception e) {System.out.println("Veuillez rentrer des informations au format valide");addBdd();}
		}
	}
	
	


	public static void main(String[] args) {
		
		List<Joueur> liste = Context.getDaoJoueur().selectAll();
				
		System.out.println(liste);
		
		//accueil();
		
	}

}
