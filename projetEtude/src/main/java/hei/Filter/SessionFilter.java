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
	public void init(FilterConfig filterConfig) throws ServletException {}
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if(!req.getServletPath().equals("/connexion") && !req.getServletPath().equals("/creationProfil")){
            testIfEtudiantConnecte(req,resp,chain);
        }else{
            chain.doFilter(request, response);
        }
    }
   
   
    private void testIfEtudiantConnecte(HttpServletRequest req,    HttpServletResponse resp,FilterChain chain) throws IOException, ServletException {
        Etudiant utilisateurConnecte = getEtudiantConnecte(req);
        if(utilisateurConnecte==null){
            resp.sendRedirect(req.getServletContext().getContextPath()+"/connexion");
        }else{
            chain.doFilter(req, resp);
        }
    }
    private Etudiant getEtudiantConnecte(HttpServletRequest req) {
        return (Etudiant) req.getSession().getAttribute("etudiantConnecte");
    }
    public void destroy() {    }
}

