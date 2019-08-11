package membres.indiv.belkhiri;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import membres.commun.beans.Utilisateur;
import membres.commun.dao.DAOFactory;

/**
 * Servlet implementation class PostForm
 */
@MultipartConfig
@WebServlet("/PostForm")
public class PostForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_TAMPON = 10240; // 10 ko
	public  static final String CHEMIN = "C:\\fichiers\\";
	private FichierDemandeDao fichierdemandedao;
	private FichierFormulaireDao fichierformulairedao;
	public static final String VUE = "/WEB-INF/VIEWS/BELKHIRI/Permis/PermisPrincipale.jsp";   

	/**
     * @see HttpServlet#HttpServlet()
     */
    public PostForm() {
        super();
        // TODO Auto-generated constructor stub
    }

 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

	        
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fichierdemandedao =  (FichierDemandeDaoImpl)daofactory.getFichierDemandeDao();
		this.fichierformulairedao = (FichierFormulaireDaoImpl)daofactory.getFichierFormulaireDao();
		
		HttpSession session =request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("USER");
		
		
		FichierDemande fichierdemande = new FichierDemande();
		Demande d = new Demande();
		d= d.Creer(request, d);
		
		Printer p = new Printer();
		String url = p.DemandePermis(d);
		
		DemandePermi demande = new DemandePermi();
		demande.setNom(d.getNom());
		demande.setPrenom(d.getPrenom());
		demande.setBut(d.getPermisBut());
		demande.setNature(d.getPermiType());
		demande.setNom(request.getParameter("nom"));
		demande.setPrenom(request.getParameter("prenom"));
		demande = demande.CreerDemande(request,demande,url,user);
		
		int id = fichierformulairedao.ajouter(demande);
		
		
		
		//IMPORTER LES 3 FICHIERS DU FRMULAIRE UN PAR UN ET LES METTRE UN PAR UN DANS LA BASE DE DONNE JAI ESSAYER DE FAIRE AUTREMENT
		//MAIS IL RECONNAIT PAS LE PART ME RENVOIT NULL JE NE COMPREND PAS PK ! 
		Part part = request.getPart("carteid");	
 		String nom = getNomFichier( part );		
		nom = nom.substring( nom.lastIndexOf( '/' )+ 1 ).substring( nom.lastIndexOf( '\\' ) + 1 );
		if ( nom != null && !nom.isEmpty() ) {
 			ecrireFichier( part, nom , CHEMIN );		
			}
		
		fichierdemande.setIdDemande(id);
		fichierdemande.setNomFichier(nom);
		fichierdemande.setNom(demande.getNom());
		fichierdemande.setPrenom(demande.getPrenom());
		fichierdemande.setExtension(getFileExtension(new File(CHEMIN+nom)));
		fichierdemande.setURI(CHEMIN+nom);
		fichierdemandedao.ajouter(fichierdemande);
		d.setURLidentité(fichierdemande.getURI());
		
		part = request.getPart("autorisationFournisseur");
		nom = getNomFichier(part);
		nom = nom.substring( nom.lastIndexOf( '/' )+ 1 ).substring( nom.lastIndexOf( '\\' ) + 1 );
		if ( nom != null && !nom.isEmpty() ) {
 			ecrireFichier( part, nom , CHEMIN );		
			}
		
		fichierdemande.setIdDemande(id);
		fichierdemande.setNomFichier(nom);
		fichierdemande.setExtension(getFileExtension(new File(CHEMIN+nom)));
		fichierdemande.setURI(CHEMIN+nom);
		fichierdemande.setNom(demande.getNom());
		fichierdemande.setPrenom(demande.getPrenom());
		fichierdemandedao.ajouter(fichierdemande);
		d.setURLautorisation(fichierdemande.getURI());
		
		part = request.getPart("demandemanuscrite");
		nom = getNomFichier(part);
		nom = nom.substring( nom.lastIndexOf( '/' )+ 1 ).substring( nom.lastIndexOf( '\\' ) + 1 );
		if ( nom != null && !nom.isEmpty() ) {
 			ecrireFichier( part, nom , CHEMIN );		
			}
		
		fichierdemande.setIdDemande(id);
		fichierdemande.setNomFichier(nom);
		fichierdemande.setExtension(getFileExtension(new File(CHEMIN+nom)));
		fichierdemande.setURI(CHEMIN+nom);
		fichierdemande.setNom(demande.getNom());
		fichierdemande.setPrenom(demande.getPrenom());
		fichierdemandedao.ajouter(fichierdemande);
		d.setURIdemandemanuscrite(fichierdemande.getURI());
		
		
		part = request.getPart("projetdescription");
		nom = getNomFichier(part);
		nom = nom.substring( nom.lastIndexOf( '/' )+ 1 ).substring( nom.lastIndexOf( '\\' ) + 1 );
		if ( nom != null && !nom.isEmpty() ) {
 			ecrireFichier( part, nom , CHEMIN );		
			}
		fichierdemande.setIdDemande(id);
		fichierdemande.setNomFichier(nom);
		fichierdemande.setExtension(getFileExtension(new File(CHEMIN+nom)));
		fichierdemande.setURI(CHEMIN+nom);
		fichierdemande.setNom(demande.getNom());
		fichierdemande.setPrenom(demande.getPrenom());		
		fichierdemandedao.ajouter(fichierdemande);
		d.setURIdemandemanuscrite(fichierdemande.getURI());
		
		
		String message=" Tout a été Uploader Avec succé !";
		request.setAttribute("message", message);
		
		
		 
		
		Workflow w = new Workflow();
		
		w.setIduser(user.getId());
 		w=w.trouver_by_userid(user.getId());
  		
		request.setAttribute("workflow", w);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

		
		
	}
	
	private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
		/* Prépare les flux. */
 		BufferedInputStream entree = null;
		BufferedOutputStream sortie = null;
		try {
		/* Ouvre les flux. */
		entree = new BufferedInputStream( part.getInputStream(),TAILLE_TAMPON );
		sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin + nomFichier ) ),TAILLE_TAMPON );
		
		/*
		* Lit le fichier reçu et écrit son contenu dans un fichier sur le
		* disque.
		*/
		byte[] tampon = new byte[TAILLE_TAMPON];
		int longueur;
		while ( ( longueur = entree.read( tampon ) ) > 0 ) {
		sortie.write( tampon, 0, longueur );
		}
		} finally {
		try {
		sortie.close();
		} catch ( IOException ignore ) {
		}
		try {
		entree.close();
		} catch ( IOException ignore ) {
		}
		}
		}
	
	private static String getNomFichier( Part part ) {
		/* Boucle sur chacun des paramètres de l'en-tête "contentdisposition". */
		for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
		/* Recherche de l'éventuelle présence du paramètre
		"filename". */
		if ( contentDisposition.trim().startsWith( "filename" ) ) {
		/*
		* Si "filename" est présent, alors renvoi de sa valeur,
		* c'est-à-dire du nom de fichier sans guillemets.
		*/
		return contentDisposition.substring(contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
		}
		}
		/* Et pour terminer, si rien n'a été trouvé... */
		return null;
		}
	private static String getFileExtension(File file) {
        String extension = "";
 
        try {
            if (file != null && file.exists()) {
                String name = file.getName();
                extension = name.substring(name.lastIndexOf("."));
            }
        } catch (Exception e) {
            extension = "";
        }
        return extension;

	}
}
