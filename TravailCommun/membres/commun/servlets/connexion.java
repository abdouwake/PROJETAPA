package membres.commun.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membres.commun.beans.Utilisateur;
import membres.commun.dao.DAOFactory;
import membres.commun.dao.UtilisateurDao;
import membres.commun.dao.UtilisateurDaoImpl;
import membres.commun.forms.ConnexionForm;
/**
 * Servlet implementation class connexion
 */
@WebServlet("/connexion")
public class connexion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String VUE1 = "/WEB-INF/VIEWS/Commun/HomeMember/homeMember.jsp";
	public static final String VUE2 = "/WEB-INF/VIEWS/Commun/HomeVisitor/connexion.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConnexionForm 	form = new ConnexionForm();
		Utilisateur 	user = form.doConnexion(request);
	
 		request.setAttribute( "form", form );
		
		
		if (form.isConnecter()==true && user!=null) {
			request.setAttribute( "user", user );
			this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);

		}else if (form.isConnecter()==false || user==null) {
			this.getServletContext().getRequestDispatcher(VUE2).forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
