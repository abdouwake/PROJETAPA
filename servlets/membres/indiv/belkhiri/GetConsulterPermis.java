package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import membres.commun.beans.Utilisateur;

/**
 * Servlet implementation class GetConsulterPermis
 */
@WebServlet("/GetConsulterPermis")
public class GetConsulterPermis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/Permis/Consulter.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetConsulterPermis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession() ;
		Utilisateur user = (Utilisateur) session.getAttribute("USER");
		
		Workflow w = new Workflow();
		String message_end1=null;
		String message_end2=null;
		String message_end3=null;
		String message_end4=null;
		
		w.setIduser(user.getId());
 		w=w.trouver_by_userid(user.getId());
  		
 		if (w!=null) {
 		if (w.est_fini(w)) {
  			message_end1 = "Votre demande de permis a été traitée par toutes les parties";
 			message_end2 = "Vous avez eu une note de "+w.getNote()+" /20";
 			if(w.getNote() < w.getNotemine()) {
 			message_end3 = "Votre note ne vous permet pas de décrocher ce permis.";
 			}else {
 			message_end4="Félicitations, Votre permis vous sera bientôt délivrer, vous pourrez à tout moment consulter la page de vos permis.";
 			}
 			
 		w.Supprimer(w.getIdworkflow());
 		
 		}
 		}
 		
 		request.setAttribute("message_end1", message_end1);
 		request.setAttribute("message_end2", message_end2);
 		request.setAttribute("message_end3", message_end3);
 		request.setAttribute("message_end4", message_end4);

 		 
		request.setAttribute("workflow", w);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	 

}
