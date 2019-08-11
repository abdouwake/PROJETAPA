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
 * Servlet implementation class ConsulterFichiersDemande
 */
@WebServlet("/ConsulterFichiersDemande")
public class ConsulterFichiersDemande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/fichiersdemande.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterFichiersDemande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		 
		    File file = new File(request.getParameter("uri"));
			if(!Desktop.isDesktopSupported()){
	            System.out.println("Desktop is not supported");
	            return;
	        }
	        
	        Desktop desktop = Desktop.getDesktop();
	        if(file.exists()) desktop.open(file);
	        
	        int id = Integer.valueOf(request.getParameter("idDemande"));
			FichierDemande demande = new FichierDemande();
			ArrayList<FichierDemande> affichage = demande.afficher(id);
			request.setAttribute("affichage", affichage);
			
			DemandePermi d = new DemandePermi();
			d = d.trouver(d, id);
  			request.setAttribute("demande", d);
			
	        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	 

}
