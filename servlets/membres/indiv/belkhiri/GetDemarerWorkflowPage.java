package membres.indiv.belkhiri;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDemarerWorkflowPage
 */
@WebServlet("/GetDemarerWorkflowPage")
public class GetDemarerWorkflowPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/workflow/CreerWorkflow.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDemarerWorkflowPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Modele modele = new Modele();
		modele=modele.recupererModele();
		request.setAttribute("modele", modele);
		request.setAttribute("etapes", modele.getEtape());
		int iddemande = Integer.valueOf(request.getParameter("idDemande"));
		request.setAttribute("idDemande", iddemande);
 		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
