package membres.indiv.belkhiri;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpenFilesParcourir
 */
@WebServlet("/OpenFilesParcourir")
public class OpenFilesParcourir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/ParcourirDocuments.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenFilesParcourir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		File file = new File(request.getParameter("url"));
		if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }
        System.out.println("fichier ouvert");
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) desktop.open(file);
        
		FichierDemande demande = new FichierDemande();
		ArrayList<FichierDemande> affichage = demande.afficher_tout();
		request.setAttribute("affichage", affichage);
		ArrayList<DemandePermi> affichageForms = new ArrayList<DemandePermi>();

		DemandePermi d = new DemandePermi();
		affichageForms= d.afficher_tout();
		request.setAttribute("affichageForms", affichageForms);
		
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        
	}

}
