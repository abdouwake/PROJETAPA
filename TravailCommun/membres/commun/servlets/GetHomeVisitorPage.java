package membres.commun.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetHomeVisitorPage
 */
@WebServlet( "/GetHomeVisitorPage" )
public class GetHomeVisitorPage extends HttpServlet {
    private static final long  serialVersionUID = 1L;
    public static final String VUE              = "/WEB-INF/VIEWS/Commun/HomeVisitor/HomeVisitor.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHomeVisitorPage() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

}
