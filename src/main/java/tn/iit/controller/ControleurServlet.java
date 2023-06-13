package tn.iit.controller;
import java.io.IOException;




import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.jasper.tagplugins.jstl.core.Out;

import tn.iit.connection.SingletonConnection;
import tn.iit.dao.EnseignantDaoImpl;
import tn.iit.dao.IAutorisationDAO;
import tn.iit.dao.IAutorisationDaoImpl;
import tn.iit.dao.IEnseignantDao;
import tn.iit.model.Autorisation;
import tn.iit.model.Enseignant;
import tn.iit.model.EnseignantModele;

@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
	
	 
	 IEnseignantDao metier1;
	 IAutorisationDAO  metier2;
	 @Override
	public void init() throws ServletException {
		
		metier1 = new EnseignantDaoImpl();
		metier2 = new IAutorisationDaoImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request,
			             HttpServletResponse response) 
			            throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/index.do"))
		{	
			   Calendar cal = Calendar.getInstance();
			   int semaine = cal.get(Calendar.WEEK_OF_YEAR);
			   request.setAttribute("semaine", semaine);
			request.getRequestDispatcher("enseignant.jsp").forward(request,response);
		}
		
		else if (path.equals("/chercherensgn.do"))
		{
			String motCle1=request.getParameter("motCle1");
			EnseignantModele model1= new EnseignantModele();
			model1.setMotCle1(motCle1);
			List<Enseignant> prods1 = metier1.enseignantsParMC(motCle1);
			model1.setEnseignants(prods1);
			request.setAttribute("model1", model1);
			request.getRequestDispatcher("enseignant.jsp").forward(request,response);
		}
		else if (path.equals("/autorisation.do"))
		{
			Long enseignant_id=Long.parseLong(request.getParameter("enseignant_id"));
			  
			   double nb_heure= Double.parseDouble(request.getParameter("heurre"))  + Double.parseDouble(request.getParameter("nb_heure"));
			   String date=request.getParameter("date");    
			   Autorisation A = metier2.saveenn(new Autorisation(enseignant_id,nb_heure, date));
			request.setAttribute("Autorisation", A);
			  Enseignant enseignant = metier1.getEnseignant(enseignant_id);
			 System.out.println(enseignant);
			  request.setAttribute("enseignant", enseignant);     
			Connection connection = null;
			       try {
			           connection = SingletonConnection.getConnection();
			           String updateQuery = "UPDATE enseignant SET heur = ? WHERE id_enseignant = ?";
			           PreparedStatement statement = connection.prepareStatement(updateQuery);
			           statement.setDouble(1, nb_heure);
			           statement.setLong(2, enseignant_id);
			           System.out.println(enseignant_id);
			           statement.executeUpdate();
			           System.out.println(statement.executeUpdate());

			           request.getRequestDispatcher("confirmationautorisation.jsp").forward(request, response);
			       } catch (SQLException e) {
			           e.printStackTrace();
			       } finally {
			           try {
			               if (connection != null && !connection.isClosed()) {
			           System.out.println("success");
			               }
			           } catch (SQLException e) {
			               e.printStackTrace();
			           }
			       }
			request.getRequestDispatcher("autorisation.jsp").forward(request,response);
		}
		else if (path.equals("/saisie.do")  )
		{
			request.getRequestDispatcher("saisieProduit.jsp").forward(request,response);
		}
		else if (path.equals("/save.do")  && request.getMethod().equals("POST"))
		{
			 String Nom=request.getParameter("Nom");
			    String Prenom=request.getParameter("Prenom");
			    
			    double heur  = 4;

			    Enseignant E = metier1.saveen(new Enseignant(Nom,Prenom,1));
				request.setAttribute("Enseignant", E);
				request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		
		else if (path.equals("/supprimerEnseignant.do"))
		{
		    Long id= Long.parseLong(request.getParameter("id"));
		    metier1.deleteEnseignant(id);
		    response.sendRedirect("chercherensgn.do?motCle1=");
					
			//request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		
		else if (path.equals("/editerEnseignant.do")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
			Enseignant en = metier1.getEnseignant(id);
		    request.setAttribute("enseignant", en);
			request.getRequestDispatcher("editerEnseignat.jsp").forward(request,response);
		}
		else if (path.equals("/voirEnseignant.do")  )
		{	
			Long id= Long.parseLong(request.getParameter("id"));
			Enseignant en = metier1.getEnseignant(id);
		    request.setAttribute("enseignant", en);
		    request.getRequestDispatcher("voirEnseignant.jsp").forward(request,response);
		}
		else if (path.equals("/autEnse.do")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
			Enseignant en = metier1.getEnseignant(id);
		    request.setAttribute("enseignant", en);
		    System.out.println(en);
			request.getRequestDispatcher("autorisation.jsp").forward(request,response);
		}
		
		else if (path.equals("/recupens.do")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
			Enseignant en = metier1.getEnseignant(id);
		    request.setAttribute("enseignant", en);
		    System.out.println(en);
			request.getRequestDispatcher("confirmationautorisation.jsp").forward(request,response);
		}
		
		else if (path.equals("/updateEnseignant.do")  )
		{
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			 String prenom=request.getParameter("prenom");
			 
			 double heur = Double.parseDouble(request.getParameter("heur"));
			 Enseignant en = new Enseignant();
			 en.setId_enseignant(id);			
			 en.setNom(nom);
			 en.setPrenom(prenom);
			 
			 en.setHeur(heur);
			 metier1.updateEnseignant(en);
			 request.setAttribute("enseignant", en);
				request.getRequestDispatcher("enseignant.jsp").forward(request,response);
		}
		else if (path.equals("/updateEnse.do")  )
		{
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			 String prenom=request.getParameter("prenom");
			 
			 double heur = Double.parseDouble(request.getParameter("heur"));
			
			 Enseignant en = new Enseignant();
			 en.setId_enseignant(id);			
			 en.setNom(nom);
			 en.setPrenom(prenom);
			 
			 en.setHeur(heur);

			

			 metier1.updateEnse(en);
			 request.setAttribute("enseignant", en);
			 String input = request.getParameter("heur");
			 
				request.getRequestDispatcher("enseignant.jsp").forward(request,response);
		}
		
		/*else
		{
			response.sendError(Response.SC_NOT_FOUND);		
		}*/	
	}
	

	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}