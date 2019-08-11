package membres.indiv.belkhiri;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DélivrerPermi
 */
@WebServlet("/DélivrerPermi")
public class DélivrerPermi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/DelivrerPermis.jsp";   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DélivrerPermi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		int iddemande = Integer.valueOf(request.getParameter("iddemande"));
		int iduser = Integer.valueOf(request.getParameter("iduser"));
		String nature = request.getParameter("nature");
		String but = request.getParameter("but");
		Permis p = new Permis();
		p.setEtat(true);
		p.setIddemande(iddemande);
		p.setNature(nature);
		p.setBut(but);
		DemandePermi d = new DemandePermi();
		d = d.trouver(d, iddemande);
		p.setNomuser(d.getNom());
		p.setPrenomuser(d.getPrenom());
		String from = request.getParameter("du");
		String to = request.getParameter("au");
	    SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  

		
		p.setFrom(from);
		p.setTo(to);
		Printer print = new Printer();
		String url = print.DelivrerPermis(p,request);
		p.setIdpermi(p.getIddemande());
		p.setUrl(url);
	 
		p.creer(p);
		
		
		
		ArrayList<DemandePermi> liste = new ArrayList<DemandePermi>();
		DemandePermi d2 = new DemandePermi();
		
		liste = d2.afficher_délivrance();
		request.setAttribute("affichage", liste);
		String message ="Le permi a été délivré avec succés ! ";
		request.setAttribute("message", message);
		
		d.set_archiver(iddemande);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}
 

}
