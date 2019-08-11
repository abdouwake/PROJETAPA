package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetFichiersDemandePage
 */
@WebServlet("/GetFichiersDemandePage")
public class GetFichiersDemandePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/fichiersdemande.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFichiersDemandePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("idDemande"));
		FichierDemande demande = new FichierDemande();
		ArrayList<FichierDemande> affichage = demande.afficher(id);
 		
		DemandePermi d = new DemandePermi();
		d = d.trouver(d, id);
		request.setAttribute("demande", d);
		
		request.setAttribute("affichage", affichage);
		request.setAttribute("numero", id);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	 

}
