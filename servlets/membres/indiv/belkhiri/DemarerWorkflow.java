package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemarerWorkflow
 */
@WebServlet("/DemarerWorkflow")
public class DemarerWorkflow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/DashPermis/DashPermis.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemarerWorkflow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Modele m = new Modele();
		int iddemande = Integer.valueOf(request.getParameter("idDemande"));
		String[] acteurs = request.getParameterValues("input");
		int idmodele = m.recupererModele().getIdmodele();
		
		Workflow w = new Workflow();
		w.creer(request, idmodele, iddemande, acteurs);		
		DemandePermi d = new DemandePermi();
		d.MAJ_demande(iddemande);
		ArrayList<DemandePermi>  affichage= d.afficher_en_attente();
		request.setAttribute("affichage", affichage);
		Modele modele = new Modele();
		modele=modele.recupererModele();
 		request.setAttribute("modele", modele);
 		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
  

}
