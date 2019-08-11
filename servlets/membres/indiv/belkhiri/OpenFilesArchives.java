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
 * Servlet implementation class OpenFilesArchives
 */
@WebServlet("/OpenFilesArchives")
public class OpenFilesArchives extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/Archive.jsp";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenFilesArchives() {
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
        
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) desktop.open(file);
        
        
        boolean archiver=true;
		FichierLoi fichier = new FichierLoi();
		ArrayList<FichierLoi>  affichage= fichier.afficher(archiver);
		request.setAttribute("affichage", affichage);
	
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	 

}
