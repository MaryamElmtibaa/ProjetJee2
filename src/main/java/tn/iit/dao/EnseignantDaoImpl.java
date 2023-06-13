package tn.iit.dao;

import java.util.List;

import tn.iit.connection.SingletonConnection;
import tn.iit.model.Enseignant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnseignantDaoImpl implements IEnseignantDao{
	

	@Override
	public Enseignant saveen(Enseignant en) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO Enseignant(Nom,Prenom) VALUES(?,?)");
			ps.setString(1, en.getNom());
			ps.setString(2, en.getPrenom());
			ps.executeUpdate();
			
			
			PreparedStatement ps2= conn.prepareStatement
					("SELECT MAX(ID_Enseignant) as MAX_ID FROM Enseignant");
			ResultSet rs =ps2.executeQuery();
			if (rs.next()) {
				en.setId_enseignant(rs.getLong("MAX_ID"));
			}
			ps.close();
			ps2.close();
				 
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return en;
	}

	@Override
	public List<Enseignant> enseignantsParMC(String me) {
		 List<Enseignant> prods1= new ArrayList<Enseignant>();
	       Connection conn=SingletonConnection.getConnection();
	       try {
	    	   PreparedStatement ps= conn.prepareStatement("SELECT * FROM Enseignant WHERE Nom LIKE ?");
			ps.setString(1, "%"+me+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Enseignant en = new Enseignant();
				en.setId_enseignant(rs.getLong("id_enseignant"));
				en.setNom(rs.getString("nom"));
				en.setPrenom(rs.getString("prenom"));
				
				en.setHeur(rs.getDouble("heur"));
				prods1.add(en);								
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

			return prods1;
		
	}

	@Override
	public Enseignant getEnseignant(Long id) {
		 Connection conn=SingletonConnection.getConnection();
		 Enseignant en = new Enseignant();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from Enseignant where ID_Enseignant = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				en.setId_enseignant(rs.getLong("id_enseignant"));
				en.setNom(rs.getString("nom"));
				en.setPrenom(rs.getString("prenom"));
				
				en.setHeur(rs.getDouble("heur"));
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return en;	}

	@Override
	public Enseignant updateEnseignant(Enseignant en) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("UPDATE Enseignant SET NOM=?,PRENOM=?,HEUR=? WHERE ID_Enseignant=?");
			ps.setString(1, en.getNom());
			ps.setString(2, en.getPrenom());
		
			ps.setDouble(5, en.getHeur());
			ps.setLong(6, en.getId_enseignant());
			ps.executeUpdate();
			ps.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return en;
	}


	@Override
	public Enseignant updateEnse(Enseignant en) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("UPDATE Enseignant SET NOM=?,PRENOM=?,HEUR=? WHERE ID_Enseignant=?");
			ps.setString(1, en.getNom());
			ps.setString(2, en.getPrenom());
			
			ps.setDouble(5, en.getHeur());
			ps.setLong(6, en.getId_enseignant());
			ps.executeUpdate();
			ps.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return en;
	}

	@Override
	public Enseignant getHeur(Enseignant en) {
	    Connection conn = SingletonConnection.getConnection();
	    try {
	        PreparedStatement ps = conn.prepareStatement("SELECT HEUR FROM Enseignant WHERE ID_Enseignant=?");
	        ps.setLong(1, en.getId_enseignant());

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            double heur = rs.getDouble("HEUR");
	            en.setHeur(heur);
	        }
	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return en;
	}

	@Override
	public void deleteEnseignant(Long id) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM Enseignant WHERE ID_Enseignant = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public List<Enseignant> getAll() {
		 List<Enseignant> prods1= new ArrayList<Enseignant>();
	       Connection conn=SingletonConnection.getConnection();
	       try {
	    	   PreparedStatement ps= conn.prepareStatement("SELECT * FROM Enseignant ");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Enseignant en = new Enseignant();
				en.setId_enseignant(rs.getLong("id_enseignant"));
				en.setNom(rs.getString("Nom"));
				en.setPrenom(rs.getString("Prenom"));
				
				en.setHeur(rs.getDouble("Heur"));
				prods1.add(en);								
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

			return prods1;
	}


	
	

}
