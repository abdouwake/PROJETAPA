package membres.indiv.belkhiri;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import membres.commun.beans.Utilisateur;

/**
 * Servlet implementation class PoserQuestion
 */
@WebServlet("/PoserQuestion")
public class PoserQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/faq.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PoserQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Boolean aucunprob =false;
		Question q = new Question();
		
        HttpSession session = request.getSession();
        Utilisateur u = new Utilisateur();
		u=(Utilisateur) session.getAttribute("USER");	
		
		if (q!=null) {
		q.setUsername(u.getUsername());
		}
		
		String titre = request.getParameter("titre");
		String contenu = request.getParameter("contenu");
		q.setTitre(titre);
		q.setContenu(contenu);
		
		if(u !=null) {
		q.setIDUtilisateur(u.getId());
		}
		
		q.Poster(q);
		aucunprob=true;

		request.setAttribute("aucunprob",  aucunprob);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}

}
