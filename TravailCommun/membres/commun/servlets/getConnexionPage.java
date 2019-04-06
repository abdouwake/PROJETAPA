package membres.commun.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membres.indiv.belkhiri.FichierLoi;

/**
 * Servlet implementation class getConnexionPage
 */
@WebServlet( "/getConnexionPage" )
public class getConnexionPage extends HttpServlet {
    private static final long  serialVersionUID = 1L;

    public static final String VUE              = "/WEB-INF/VIEWS/Commun/HomeVisitor/connexion.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public getConnexionPage() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        FichierLoi f = new FichierLoi();

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet( request, response );
    }

}
