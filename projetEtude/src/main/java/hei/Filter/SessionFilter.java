package hei.Filter;

import hei.model.Etudiant;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionFilter implements Filter {
	
	//initiation du filtre
	public void init(FilterConfig filterConfig) throws ServletException {}
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        //accès autorisé aux pages connexion et creationProfil si non connecté
        //Si l'utilisateur est sur une autre page, vérifier qu'il est connecté sinon empecher son accès aux autres pages
        if(!req.getServletPath().equals("/connexion") && !req.getServletPath().equals("/creationProfil")){
            testIfEtudiantConnecte(req,resp,chain);
        }else{
            chain.doFilter(request, response);
        }
    }
   
   //Vérifie que l'utilisateur est connecté
    private void testIfEtudiantConnecte(HttpServletRequest req,    HttpServletResponse resp,FilterChain chain) throws IOException, ServletException {
        Etudiant utilisateurConnecte = getEtudiantConnecte(req);
        //si non connecté, renvoi sur la page de connexion
        if(utilisateurConnecte==null){
            resp.sendRedirect(req.getServletContext().getContextPath()+"/connexion");
        }else{
            chain.doFilter(req, resp);
        }
    }
    //Récupération des informations de l'utilisateur connecté
    private Etudiant getEtudiantConnecte(HttpServletRequest req) {
        return (Etudiant) req.getSession().getAttribute("etudiantConnecte");
    }
    //Rupture du filtre
    public void destroy() {    }
}

