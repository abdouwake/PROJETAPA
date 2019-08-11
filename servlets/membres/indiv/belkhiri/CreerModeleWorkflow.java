package membres.indiv.belkhiri;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreerModeleWorkflow
 */
@WebServlet("/CreerModeleWorkflow")
public class CreerModeleWorkflow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/DashPermis/DashPermis.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerModeleWorkflow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		
		Modele m = new Modele();
		String[] step = request.getParameterValues("tab");
		m.setNbsteps((step.length)/3);	
		m.setNotemin( Integer.valueOf(request.getParameter("note")));
		
		m.CreerModele(step,m);
		
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

 

}
