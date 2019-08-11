package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RechercheArchiveTab
 */
@WebServlet("/RechercheArchiveTab")
public class RechercheArchiveTab extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/DashLoi/Archive.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheArchiveTab() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FichierLoi fichier = new FichierLoi();

  		String search= request.getParameter("search");
 		String du =request.getParameter("du");
		String au =request.getParameter("au");
		String contient= request.getParameter("contient");
		 
		
		if ( search.isEmpty() && du.isEmpty() && au.isEmpty() && contient.isEmpty()){			
			ArrayList<FichierLoi>  affichage= fichier.afficher(true);
			request.setAttribute("affichage", affichage);			
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

		} else {
			
		
		
		ArrayList<FichierLoi>  affichage= fichier.Chercher(true, request);
		request.setAttribute("affichage", affichage);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
		
	}


}
