package hei.controllers;

import hei.metier.Manager;
import hei.model.Etudiant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConnexionServlet extends HttpServlet {

	private static final long serialVersionUID = -4501231509110259062L;

	
	public ConnexionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        if(request.getParameter("logout") != null){
        	 HttpSession session = request.getSession(true); 
        	 session.invalidate();
        	 redirectConnexion(response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail = request.getParameter("mail");
		String password = request.getParameter("pass");
		
		Etudiant etudiant = Manager.getInstance().getEtudiantMail(mail);
		
		if (password.equals(etudiant.getPassWord())) {
			HttpSession session = request.getSession(true);
			session.setAttribute("identifiantEtudiant", etudiant.getIdetudiant() );
			redirectCal(response);
		}
		else
		{
			request.setAttribute("loginError", "Votre login n'est pas bon. Veuillez rentrer un utilisateur et un mot de passe valide.");
		    ServletContext context = getServletContext();
		    RequestDispatcher dispatcher =context.getRequestDispatcher("/connexion");
		    dispatcher.forward(request, response);
		}
	}

	private void redirectCal(HttpServletResponse resp) throws IOException {
	    resp.sendRedirect(getServletContext().getContextPath()+"/monCalendrier1");
	}
	
	private void redirectConnexion(HttpServletResponse resp) throws IOException {
	    resp.sendRedirect(getServletContext().getContextPath()+"/connexion");
	}
}
