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
    public void doFilter(ServletRequest request, ServletResponse response,    FilterChain chain) throws IOException, ServletException {
       
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if(!req.getServletPath().equals("/connexion") && !req.getServletPath().equals("/index.jsp")){
            testIfUtilisateurConnecte(req,resp,chain);
        }else{
            chain.doFilter(request, response);
        }
    }
   
   
    private void testIfUtilisateurConnecte(HttpServletRequest req,    HttpServletResponse resp,FilterChain chain) throws IOException, ServletException {
        Etudiant utilisateurConnecte = getUtilisateurConnecte(req);
        if(utilisateurConnecte==null){
            resp.sendRedirect(req.getServletContext().getContextPath()+"/");
        }else{
            chain.doFilter(req, resp);
        }
    }
    private Etudiant getUtilisateurConnecte(HttpServletRequest req) {
        return (Etudiant) req.getSession().getAttribute("identifiantEtudiant");
    }
    public void destroy() {    }
}

