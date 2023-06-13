package tn.iit.dao;

import java.util.List;

import tn.iit.model.Autorisation;

public interface IAutorisationDAO {
	
	public Autorisation saveenn(Autorisation aut);
	public List<Autorisation> autorisationParMC(String autme);
	public Autorisation getAutorisation(Long id);
	public Autorisation updateAutorisation(Autorisation aut);
	public void deleteAutorisation(Long id);
	Autorisation updateAut(Autorisation aut);
}
