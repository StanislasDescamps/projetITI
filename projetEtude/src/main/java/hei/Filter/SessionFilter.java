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
        
                
        //acces autorise aux pages connexion et creationProfil si non connecte
        //Si l'utilisateur est sur une autre page, verifier qu'il est connecte sinon empecher son acces aux autres pages
        if(!req.getServletPath().equals("/connexion") && !req.getServletPath().equals("/creationProfil")){
            testIfEtudiantConnecte(req,resp,chain);
        }else{
            chain.doFilter(request, response);
        }
    }
   
   //Verifie que l'utilisateur est connecte
    private void testIfEtudiantConnecte(HttpServletRequest req,    HttpServletResponse resp,FilterChain chain) throws IOException, ServletException {
        Etudiant utilisateurConnecte = getEtudiantConnecte(req);
      
        String uri = ((HttpServletRequest)req).getRequestURI();

        //si non connecte, renvoi sur la page de connexion
        if(utilisateurConnecte==null){
        	if ( uri.indexOf("/css") > 0){
                chain.doFilter(req, resp);
            }
            else if( uri.indexOf("/img") > 0){
                chain.doFilter(req, resp);
            }else{
            	resp.sendRedirect(req.getServletContext().getContextPath()+"/connexion");}
        }else{
            chain.doFilter(req, resp);
        }
    }
    //Recuperation des informations de l'utilisateur connecte
    private Etudiant getEtudiantConnecte(HttpServletRequest req) {
        return (Etudiant) req.getSession().getAttribute("etudiantConnecte");
    }
    //Rupture du filtre
    public void destroy() {    }
}

