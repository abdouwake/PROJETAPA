package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValiderReponse
 */
@WebServlet("/ValiderReponse")
public class ValiderReponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/FaqManager.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValiderReponse() {
        super();
        // TODO Auto-generated constructor stub
    }

 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("idreponseValider"));

		ArrayList affichage=new ArrayList();		
		Question q= new Question();
		Reponse r = new Reponse();
		r.valider(id);
		affichage = q.Afficher_Question_Moderateur();
		request.setAttribute("Questions", affichage);
		affichage = r.afficher_reponses_moderateur();
		request.setAttribute("Reponses", affichage);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
