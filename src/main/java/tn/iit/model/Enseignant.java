package tn.iit.model;
import java.io.Serializable;
import java.util.Calendar;

public class Enseignant implements Serializable {
	private Long id_enseignant;
	private String Nom;
	private String Prenom;
	
	private double heur;
	
	public Enseignant() {
		super();
	}
	public Enseignant(String Nom, String prenom, double heur) {
		super();
		this.Nom = Nom;
		this.Prenom = prenom;
		
		this.heur = heur;
	}
	public Enseignant(String Nom, String prenom) {
		super();
		this.Nom = Nom;
		this.Prenom = prenom;
		
		
	}
	public Long getId_enseignant() {
		return id_enseignant;
	}
	public void setId_enseignant(Long id_enseignant) {
		this.id_enseignant = id_enseignant;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String Nom) {
		this.Nom = Nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	
	
	
	public double getHeur() {
		return heur;
	}
	public void setHeur(double heur) {
		this.heur = heur;
	}
	@Override
	public String toString() {
		return "Enseignant [id_enseignant=" + id_enseignant + ", Nom=" + Nom + ", Prenom=" + Prenom + ",  heur=" + heur + "]";
	}
	
}
