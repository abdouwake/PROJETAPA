package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValiderQuestion
 */
@WebServlet("/ValiderQuestion")
public class ValiderQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/FaqManager.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValiderQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }
 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("idquestionValider"));

		ArrayList affichage=new ArrayList();		
		Question q= new Question();
		q.valider(id);
		Reponse r = new Reponse();
		
		affichage = q.Afficher_Question_Moderateur();
		request.setAttribute("Questions", affichage);
		affichage = r.afficher_reponses_moderateur();
		request.setAttribute("Reponses", affichage);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
