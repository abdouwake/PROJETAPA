package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RechercherDocument
 */
@WebServlet("/RechercherDocument")
public class RechercherDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/ParcourirDocuments.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercherDocument() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
		String from = request.getParameter("du");
		String to = request.getParameter("au");
		
		if (nom.isEmpty() && from.isEmpty() && to.isEmpty()) {
			

			FichierDemande demande = new FichierDemande();
			ArrayList<FichierDemande> affichage = demande.afficher_tout();
			request.setAttribute("affichage", affichage);
			ArrayList<DemandePermi> affichageForms = new ArrayList<DemandePermi>();
			DemandePermi d = new DemandePermi();
			affichageForms= d.afficher_tout();
			request.setAttribute("affichageForms", affichageForms);
			Permis p = new Permis();
			ArrayList<Permis> permis = new ArrayList<Permis>();
			permis = p.afficher_tout();
			request.setAttribute("permis", permis);
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			
		}
		
		else {
			
			Permis permi = new Permis();		
			ArrayList<Permis> permis = new ArrayList<Permis>();
			permis = permi.chercher_parcourir(nom, from, to);	
			request.setAttribute("permis", permis);

			
			DemandePermi d = new DemandePermi();	
			ArrayList<DemandePermi> affichageForms = new ArrayList<DemandePermi>();
			affichageForms = d.chercher_parcourir(nom, from, to);
			request.setAttribute("affichageForms", affichageForms);

			
			FichierDemande fichierdemande = new FichierDemande();
			ArrayList<FichierDemande> affichage = new ArrayList<FichierDemande>();
			affichage = fichierdemande.chercher_parcourir(nom, from, to);
			request.setAttribute("affichage", affichage);
		
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

		}

	}
 

}
