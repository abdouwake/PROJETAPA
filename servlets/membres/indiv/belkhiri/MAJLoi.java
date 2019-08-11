package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MAJLoi
 */
@WebServlet("/MAJLoi")
public class MAJLoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/DashLoi/Archive.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MAJLoi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strid = request.getParameter("idloi");
		int id =  Integer.valueOf(strid);
		
		boolean archiver=true;
		FichierLoi fichier = new FichierLoi();
		fichier.Archiver(id);
		ArrayList<FichierLoi>  affichage= fichier.afficher(archiver);
		request.setAttribute("affichage", affichage);
		
		String success = "Votre fichier a été archiver avec succès ! ";
		request.setAttribute("message", success);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}

	 

}
