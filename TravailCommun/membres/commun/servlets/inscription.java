package membres.commun.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membres.commun.dao.UtilisateurDao;
import membres.commun.forms.InscriptionForm;
import membres.commun.beans.Utilisateur;
import membres.commun.dao.DAOFactory;
import membres.commun.dao.UtilisateurDaoImpl;


@WebServlet("/inscription")
public class inscription extends HttpServlet {
	
	public static final String CONF_DAO_FACTORY = "daofactory";
	private UtilisateurDao utilisateurDao;
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_FORM = "form";
	public static final String VUE1 = "/VIEWS/Commun/HomeMember/homeMember.jsp";
	public static final String VUE2 = "/VIEWS/Commun/HomeVisitor/FormInscription.jsp";
	

	
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.utilisateurDao =  (UtilisateurDaoImpl)daoFactory.getUtilisateurDao();
		
		InscriptionForm form = new InscriptionForm(utilisateurDao);
		Utilisateur utilisateur = form.inscrireUtilisateur( request );
		request.setAttribute( ATT_FORM, form );
		request.setAttribute( ATT_USER, utilisateur );
		
		if (form.isOk()==true)  {
		this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
		}
		else {
		this.getServletContext().getRequestDispatcher(VUE2).forward(request, response);

		}
		
	}

}
