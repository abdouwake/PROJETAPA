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
 * Servlet implementation class GetMyWorkflowsPage
 */
@WebServlet("/GetMyWorkflowsPage")
public class GetMyWorkflowsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/myworkflows.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyWorkflowsPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//charger les workflows et les afficher mais seulement li we9thom dok i mean
		 HttpSession session = request.getSession();
	     Utilisateur user = new Utilisateur();
	     user=(Utilisateur) session.getAttribute("USER");	
		
		ArrayList<Etape> el = new ArrayList<Etape>();
 		Workflow w = new Workflow();	
 		el = w.trouver_Etape_User(user.getId());
 		
 		request.setAttribute("etapes", el);
		
 		
 		
 		
 		//chargement du modele de workflow actuel
 		Modele m = new Modele();
 		m = m.recupererModele();
 		request.setAttribute("modele", m);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	 

}
