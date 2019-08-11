package membres.indiv.belkhiri;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetFormDelivrer
 */
@WebServlet("/GetFormDelivrer")
public class GetFormDelivrer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/delivrerform.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFormDelivrer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int iddemande = Integer.valueOf(request.getParameter("iddemande"));
		int iduser = Integer.valueOf(request.getParameter("iduser"));
		String nature = request.getParameter("nature");
		String but = request.getParameter("but");
		
		request.setAttribute("iddemande", iddemande);
		request.setAttribute("iduser", iduser);
		request.setAttribute("nature", nature);
		request.setAttribute("but", but);
		
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

		
	}

	 

}
