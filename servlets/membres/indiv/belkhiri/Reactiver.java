package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reactiver
 */
@WebServlet("/Reactiver")
public class Reactiver extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/EtatsPermis.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reactiver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Permis p = new Permis();
		int id = Integer.valueOf(request.getParameter("idpermi"));
		p.Reactiver(id);
		
		
 		ArrayList<Permis> affichage = p.afficher_tout();
		request.setAttribute("affichage", affichage);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
		
	}
 

}
