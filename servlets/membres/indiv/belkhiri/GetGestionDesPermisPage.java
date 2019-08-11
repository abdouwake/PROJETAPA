package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetGestionDesPermisPage
 */
@WebServlet("/GetGestionDesPermisPage")
public class GetGestionDesPermisPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/DashPermis/DashPermis.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetGestionDesPermisPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DemandePermi d = new DemandePermi();
		ArrayList<DemandePermi>  affichage= d.afficher_en_attente();
		request.setAttribute("affichage", affichage);
		Modele modele = new Modele();
		modele=modele.recupererModele();
 		request.setAttribute("modele", modele);
 		
 	
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}

	 

}
