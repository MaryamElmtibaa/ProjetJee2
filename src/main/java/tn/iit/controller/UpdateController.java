package tn.iit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.model.Enseignant;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String heurValue = request.getParameter("heur");

		double heurDouble = 0.0; // Valeur par défaut en cas d'erreur de conversion

		try {
		    heurDouble = Double.parseDouble(heurValue);
		} catch (NumberFormatException e) {
		    // Gérer l'erreur de conversion
		}
		Enseignant u = new Enseignant(nom, prenom, heurDouble);
		ServletContext application = getServletContext();
		List<Enseignant> listUser = (List<Enseignant>) application.getAttribute("tUser");
		int pos = Integer.parseInt(request.getParameter("pos"));
		listUser.set(pos,u);
		application.setAttribute("tUser", listUser);
		response.sendRedirect("enseignant.jsp");
	}

}
