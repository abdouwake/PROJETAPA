package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import membres.commun.beans.Utilisateur;

/**
 * Servlet implementation class Noter
 */
@WebServlet("/Noter")
public class Noter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/myworkflows.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Noter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession() ;
		Utilisateur user = (Utilisateur) session.getAttribute("USER");
		
		String message= new String();
		Workflow w = new Workflow();
		int iddemande = Integer.valueOf(request.getParameter("idDemande"));
		
		
		Etape e = new Etape();
		w = w.trouver_by_iddemande(iddemande);
  		e = e.trouver_Etape(user.getId(), w);
 		int note = Integer.valueOf(request.getParameter("note"));
 		
 		if(e!=null) {
  		e.Noter(e, note);
		e.unlock(w);
 		}
		
		if(w!=null) {
		if (w.est_fini(w)) {						
			 w.set_terminer(e.getIdworkflow());
			 DemandePermi d = new DemandePermi();
			 d.set_terminer(iddemande);
			 w = w.trouver(e.getIdworkflow());
			 Modele m = new Modele();
			 m = m.recupererModele();
			 if (w.getNote()<m.getNotemin()) {
				 
			 }
		}
		}
		
 		message ="Votre note a été attribuée avec succès ! ";
		request.setAttribute("message", message);
		
		//----Pour laffichage mtn

		Modele m = new Modele();
		m = m.recupererModele();
		request.setAttribute("modele", m);
		
		ArrayList<Etape> el = new ArrayList<Etape>();
 		el = w.trouver_Etape_User(user.getId());		
		request.setAttribute("etapes", el);
		
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	 

}
