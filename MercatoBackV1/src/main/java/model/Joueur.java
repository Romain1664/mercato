package model;

import dao.DAOJoueur;
import dao.DAOJoueurJDBC;

public class Joueur extends Compte {
	
	private String nom,prenom;
	private int age;
	private String poste;
	private int tir,precision,acceleration,puissance,tacle,marquage,id_equipe;
	private String nom_equipe;
	private double prix;

	
	public Joueur(int id_compte, String nom, String prenom, int age, String poste, int tir, int precision, int acceleration, int puissance, int tacle, int marquage, int id_equipe, double prix) {
		super(id_compte);
		this.nom=nom;
		this.prenom=prenom;
		this.age=age;
		this.tir = tir;
		this.precision = precision;
		this.acceleration = acceleration;
		this.puissance = puissance;
		this.tacle = tacle;
		this.marquage = marquage;
		this.poste = poste;
		this.id_equipe=id_equipe;
		this.prix = prix;
	}
	
	public Joueur(int id_compte, String nom, String prenom, int age, String poste, int tir, int precision, int acceleration, int puissance, int tacle, int marquage, String nom_equipe, double prix) {
		super(id_compte);
		this.nom=nom;
		this.prenom=prenom;
		this.age=age;
		this.tir = tir;
		this.precision = precision;
		this.acceleration = acceleration;
		this.puissance = puissance;
		this.tacle = tacle;
		this.marquage = marquage;
		this.poste = poste;
		this.nom_equipe=nom_equipe;
		this.prix = prix;
	}
	
	public Joueur(int id, String login, String password, String type) 
	{
		super(id, login, password, type);
	}
	
	public Joueur() 
	{
	}
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTir() {
		return tir;
	}

	public void setTir(int tir) {
		this.tir = tir;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public int getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public int getTacle() {
		return tacle;
	}

	public void setTacle(int tacle) {
		this.tacle = tacle;
	}

	public int getMarquage() {
		return marquage;
	}

	public void setMarquage(int marquage) {
		this.marquage = marquage;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getId_equipe() {
		return id_equipe;
	}

	public void setId_equipe(int id_equipe) {
		this.id_equipe = id_equipe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
	public void update()
	{
		DAOJoueur daoJ=Context.getInstance().getDaoJ();
		
		daoJ.update(this);
	}

	public void addBdd() 
	{
		DAOJoueur daoJ=Context.getInstance().getDaoJ();
		
		daoJ.insert(this);
		
	}		
	
	public void deleteBdd(Integer id)
	{
		DAOJoueur daoJ=Context.getInstance().getDaoJ();
		
		daoJ.delete(id);
	}

	public void regarderStat(Integer id)
	{
		DAOJoueur daoJ=Context.getInstance().getDaoJ();
		
		Joueur j = null;
		
		j = daoJ.selectById(id);

		if (j!=null)
		{
		System.out.println(j.getNom()+ " " + j.getPrenom() + " : [tir=" + j.getTir()
				+ ", precision=" + j.getPrecision() + ", acceleration=" + j.getAcceleration() + ", puissance=" + j.getPuissance()
				+ ", tacle=" + j.getTacle() + ", marquage=" + j.getMarquage() + "]" );
			System.out.print(System.lineSeparator());
		}
		else 
		{
			System.out.println("Vous n'êtes pas dans la base de donnée joueur, veuillez vous inscire d'abord.");
			System.out.print(System.lineSeparator());
		}
	}
	


	@Override
	public String toString() {
		return nom + " " + prenom + ", "+ age + " ans : " + poste + " (id : "+ id +") [tir=" + tir
				+ ", precision=" + precision + ", acceleration=" + acceleration + ", puissance=" + puissance
				+ ", tacle=" + tacle + ", marquage=" + marquage + "] équipe : "	+ nom_equipe + ", prix d'achat : " + prix + "€";
	}







	
}

