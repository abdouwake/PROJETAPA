package membres.indiv.belkhiri;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetGestionPermis
 */
@WebServlet("/GetGestionPermis")
public class GetGestionPermis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/Permis/PermisPrincipale.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetGestionPermis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	

}
