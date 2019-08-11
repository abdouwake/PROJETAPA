package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membres.commun.dao.DAOFactory;

/**
 * Servlet implementation class GetLoiAlgeriennePage
 */
@WebServlet("/GetLoiAlgeriennePage")
public class GetLoiAlgeriennePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/loiAlgerienne.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLoiAlgeriennePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean archiver=false;
		FichierLoi fichier = new FichierLoi();
		ArrayList<FichierLoi>  affichage= fichier.afficher(archiver);
		request.setAttribute("affichage", affichage);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

		
	}

	

}
