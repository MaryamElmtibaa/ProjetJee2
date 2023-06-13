package tn.iit.model;
import java.io.Serializable;

import java.sql.Date;
public class Autorisation implements Serializable {
	private Long id_autorisation;
	private Long enseignant_id;
	
	private double nb_heure;
	private String date;
	
	public Autorisation() {
		super();
	}
	public Autorisation( Long enseignant_id, double nb_heure, String date) {
		super();

		this.enseignant_id = enseignant_id;
		
		this.nb_heure = nb_heure;
		this.date = date;
	}
	public Long getId_autorisation() {
		return id_autorisation;
	}
	public void setId_autorisation(Long id_autorisation) {
		this.id_autorisation = id_autorisation;
	}
	public Long getEnseignant_id() {
		return enseignant_id;
	}
	public void setEnseignant_id(Long enseignant_id) {
		this.enseignant_id = enseignant_id;
	}
	
	public double getNb_heure() {
		return nb_heure;
	}
	public void setNb_heure(double nb_heure) {
		this.nb_heure = nb_heure;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

}
