package membres.indiv.belkhiri;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;




/**
 * Servlet implementation class AjouterLoi
 */
@MultipartConfig
@WebServlet("/AjouterLoi")
public class AjouterLoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/DashLoi/loiAlgerienne.jsp";   
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterLoi() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
   		FileUpload upload = new FileUpload();
 		 upload.enregFichier(request);
		
 		 request.setAttribute("message", "Votre fichier a été enregistrer avec succès");
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	
	
	
	

}
