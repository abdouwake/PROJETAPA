package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetFaqPageWithAnswers
 */
@WebServlet("/GetFaqPageWithAnswers")
public class GetFaqPageWithAnswers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/faq.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFaqPageWithAnswers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Question q= new Question();
		ArrayList affichage = q.afficher(false);
		
		request.setAttribute("affichage", affichage);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	

}
