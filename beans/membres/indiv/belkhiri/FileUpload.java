package membres.indiv.belkhiri;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;


@MultipartConfig
public class FileUpload {
	public static final int TAILLE_TAMPON = 10240; // 10 ko
	public  static final String CHEMIN = "C:\\fichiers\\";

	public void enregFichier(HttpServletRequest request) throws IOException, ServletException {
	
		
		FichierLoi fichier = new FichierLoi();	
		OcrWork ocr = new OcrWork();

		fichier.setVersion(1);
		fichier.setArchiver(false);
		
		
		//TRAITEMENT DU FICHIER Français-------------------------------------------------------------------------------------------------
		Part part = request.getPart( "fileFr" );		
 		String nomFichier = getNomFichier( part );
		nomFichier = nomFichier.substring( nomFichier.lastIndexOf( '/' )+ 1 ).substring( nomFichier.lastIndexOf( '\\' ) + 1 );
		if ( nomFichier != null && !nomFichier.isEmpty() ) {
 			ecrireFichier( part, nomFichier, CHEMIN );		
			}
		
		
		fichier.setURL(CHEMIN+nomFichier);
		String extension = getFileExtension(new File(CHEMIN+nomFichier));
		fichier.setExtension(extension);
		fichier.setSource(request.getParameter("sourceFr"));
		fichier.setDescriptionFr(request.getParameter("contenuFr"));
		
    
		String OCRFR = ocr.OCR_WORK(CHEMIN+nomFichier);
		fichier.setContenuOcr(OCRFR);
		fichier.setNomFichier(request.getParameter("titreFr"));
		
		
		//TRAITEMENT DU FICHIER ARABE-------------------------------------------------------------------------------------------------
		Part part2 = request.getPart( "fileAr" );		
 		String nomFichier2 = getNomFichier( part2 );
		nomFichier2 = nomFichier2.substring( nomFichier2.lastIndexOf( '/' )+ 1 ).substring( nomFichier2.lastIndexOf( '\\' ) + 1 );
		if ( nomFichier2 != null && !nomFichier2.isEmpty() ) {
 			ecrireFichier( part2, nomFichier2, CHEMIN );					
			}	
		
		fichier.setNomarabe(nomFichier2);
		fichier.setUrlarabe(CHEMIN+nomFichier2);
		String extensionAr = getFileExtension(new File(CHEMIN+nomFichier2));
		fichier.setExtensionAr(extensionAr);
		fichier.setSourcearabe(request.getParameter("sourceAr"));
		fichier.setDescriptionAr(request.getParameter("contenuAr"));
		String OCRAR = ocr.OCR_WORK(CHEMIN+nomFichier2);
		fichier.setContenuOcrAr(OCRAR);
		 
		
		fichier.setNomarabe(request.getParameter("titreAr"));
		fichier.inserer(fichier);
		
	}
	
	public FichierDemande EnregFichierDemande(HttpServletRequest request, String nomFichier) throws IOException, ServletException {
		
		FichierDemande fichierdemande = new FichierDemande();
		Part part = request.getPart(nomFichier);	
 		String nom = getNomFichier( part );
 		
		nom = nom.substring( nom.lastIndexOf( '/' )+ 1 ).substring( nom.lastIndexOf( '\\' ) + 1 );
		
		if ( nom != null && !nom.isEmpty() ) {
 			ecrireFichier( part, nom , CHEMIN );		
			}
		
		fichierdemande.setExtension(getFileExtension(new File(CHEMIN+nom)));
		fichierdemande.setURI(CHEMIN+nom);
		fichierdemande.setNomFichier(nom);
 		return fichierdemande;
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
	
	private static String getValeurChamp( HttpServletRequest request,String nomChamp ) {
		String valeur = request.getParameter( nomChamp );
		if ( valeur == null || valeur.trim().length() == 0 ) {	
		return null;
		} else {
			return valeur.trim();
		}
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