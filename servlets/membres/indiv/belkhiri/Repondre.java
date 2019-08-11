package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import membres.commun.beans.Utilisateur;

/**
 * Servlet implementation class Repondre
 */
@WebServlet("/Repondre")
public class Repondre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/faq.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Repondre() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int		 idquestion =  Integer.parseInt(request.getParameter("idquestion"));
		String   contenu = request.getParameter("contenu");
		Reponse r = new Reponse();
		r.setContenu(contenu);
		
		HttpSession session = request.getSession();
        Utilisateur u = new Utilisateur();
		u=(Utilisateur) session.getAttribute("USER");	
		
		if (u!=null) {
			r.setUsername(u.getUsername());
			r.setIdutilisateur(u.getId());
		}
		
		r.setIdquestion(idquestion);
		r.repondre(r);
		
		
		Question q= new Question();
		ArrayList affichage = q.afficher(true);
		
		request.setAttribute("affichage", affichage);
		request.setAttribute("resultat", "Votre réponse a été envoyée ! ");	
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
