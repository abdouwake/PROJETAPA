package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetD�livrerPermisPage
 */
@WebServlet("/GetD�livrerPermisPage")
public class GetD�livrerPermisPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/DelivrerPermis.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetD�livrerPermisPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		ArrayList<DemandePermi> liste = new ArrayList<DemandePermi>();
		DemandePermi d = new DemandePermi();
		
		liste = d.afficher_d�livrance();
		request.setAttribute("affichage", liste);
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	 
}
