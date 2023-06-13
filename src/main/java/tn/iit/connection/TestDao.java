package tn.iit.connection;

import java.util.List;

import tn.iit.dao.EnseignantDaoImpl;
import tn.iit.model.Enseignant;

public class TestDao {

	public static void main(String[] args) {
		
		
		EnseignantDaoImpl pdao1= new EnseignantDaoImpl();
		Enseignant prod1= pdao1.saveen(new Enseignant ("NOUR","AMMAR",4));
		System.out.println(prod1);
		List<Enseignant> prods1=pdao1.enseignantsParMC("");
		for (Enseignant e : prods1)
		System.out.println(e);
		
		
		
		
		
	}

}