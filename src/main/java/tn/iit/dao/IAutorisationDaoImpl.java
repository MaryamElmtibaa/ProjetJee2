package tn.iit.dao;

import java.util.List;

import tn.iit.connection.SingletonConnection;
import tn.iit.model.Autorisation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IAutorisationDaoImpl implements IAutorisationDAO {

	@Override
	public Autorisation saveenn(Autorisation aut) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO Autorisation (Enseignant_id, Nb_heure,Date) VALUES(?,?,?)");
			
			
			ps.setLong  (1, aut.getEnseignant_id());
			
			ps.setDouble(5, aut.getNb_heure());
			ps.setString(6, aut.getDate());




			ps.executeUpdate();
			
			
			PreparedStatement ps2= conn.prepareStatement
					("SELECT MAX(ID_Enseignant) as MAX_ID FROM Enseignant");
			ResultSet rs =ps2.executeQuery();
			if (rs.next()) {
				//aut.setId_enseignant(rs.getLong("MAX_ID"));
			}
			ps.close();
			ps2.close();
				 
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return aut;
	}
	@Override

	public List<Autorisation> autorisationParMC(String autme) {
		List<Autorisation> prods2= new ArrayList<Autorisation>();
		      Connection conn=SingletonConnection.getConnection();
		      try {
		      PreparedStatement ps= conn.prepareStatement("SELECT * FROM Autorisation WHERE matiere LIKE ?");
		ps.setString(1, "%"+autme+"%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		Autorisation aut = new Autorisation();
		aut.setId_autorisation(rs.getLong("id"));
		aut.setEnseignant_id(rs.getLong("enseignant_id"));
		
		aut.setNb_heure(rs.getInt("nb_heure"));
		aut.setDate(rs.getString("date"));
		prods2.add(aut);
		}
		} catch (SQLException e) {

		e.printStackTrace();
		}
		return prods2;

		}

	@Override
	public Autorisation getAutorisation(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autorisation updateAutorisation(Autorisation aut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAutorisation(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Autorisation updateAut(Autorisation aut) {
		// TODO Auto-generated method stub
		return null;
	}

}
