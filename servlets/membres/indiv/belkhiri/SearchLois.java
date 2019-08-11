package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchLois
 */
@WebServlet("/SearchLois")
public class SearchLois extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/loiAlgerienne.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchLois() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FichierLoi fichier = new FichierLoi();

		boolean archiver;
		String search= request.getParameter("search");
 		String du =request.getParameter("du");
		String au =request.getParameter("au");
		String contient= request.getParameter("contient");
		
		String string_archiver = request.getParameter("archiver");
		if(string_archiver.equals("true")){
			archiver=true;
		}else {
			archiver=false;
		}
		
		if ( search.isEmpty() && du.isEmpty() && au.isEmpty() && contient.isEmpty()){			
			ArrayList<FichierLoi>  affichage= fichier.afficher(archiver);
			request.setAttribute("affichage", affichage);			
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

		} else {
			
		
		
		ArrayList<FichierLoi>  affichage= fichier.Chercher(archiver, request);
		request.setAttribute("affichage", affichage);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
