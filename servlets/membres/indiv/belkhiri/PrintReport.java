package membres.indiv.belkhiri;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintReport
 */
@WebServlet( "/PrintReport" )
public class PrintReport extends HttpServlet {
    private static final long  serialVersionUID = 1L;
    public static final String VUE              = "/WEB-INF/VIEWS/BELKHIRI/TableauDeBord/RapportMaker.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintReport() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        Printer p = new Printer();
        String k = request.getParameter( "type" );
        String url = null;

        if ( k.isEmpty() == false ) {
            int key = Integer.valueOf( k );

            if ( key == 1 ) {
                url = p.ImprimerRapport_v1( request );

            } else if ( key == 2 ) {

                url = p.ImprimerRapport_v2( request );

            } else if ( key == 3 ) {

                url = p.ImprimerRapport_v3( request );
            }

            if ( url != null ) {
                File file = new File( url );
                if ( !Desktop.isDesktopSupported() ) {
                    System.out.println( "Desktop is not supported" );
                    return;
                }
                System.out.println( "fichier ouvert" );
                Desktop desktop = Desktop.getDesktop();
                if ( file.exists() )
                    desktop.open( file );
            }

        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

}
