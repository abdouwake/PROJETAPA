package membres.commun.forms;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import membres.commun.beans.Utilisateur;
import membres.commun.dao.DAOFactory;
import membres.commun.dao.UtilisateurDao;
import membres.commun.dao.UtilisateurDaoImpl;

public class ConnexionForm {

		private UtilisateurDao utilisateurDao;
		private static final String 	CHAMP_USERNAME	   = "username";
		private static final String 	CHAMP_PASSWORD 	   = "password";
		private Map<String, String> erreur= new HashMap<String,String>();
		private boolean connecter=false;
		Utilisateur target = new Utilisateur();
		
		
		public Utilisateur doConnexion( HttpServletRequest request ){
		DAOFactory daofactory = DAOFactory.getInstance();
		this.utilisateurDao =  (UtilisateurDaoImpl)daofactory.getUtilisateurDao();
		
		Utilisateur u = new Utilisateur();	
		String formUsername = getValeurChamp( request, CHAMP_USERNAME );
		String formPassword = getValeurChamp( request, CHAMP_PASSWORD );
		
		
		try {
			ValidationUsername( formUsername );
			} catch ( Exception e ) {
			setErreur( CHAMP_USERNAME, e.getMessage() );
			this.setConnecter(false);
			return null;
			}
			u.setUsername( formUsername );
		
			
			try {
				validationMotsDePasse( formPassword );
				} catch ( Exception e ) {
				setErreur( CHAMP_PASSWORD, e.getMessage() );
				this.setConnecter(false);
				return null;
				}
				u.setPassword( formPassword );
				
				
				if (erreur.isEmpty()) {
					 target = utilisateurDao.trouver(request.getParameter("username"),request.getParameter("password"));
					 if (target.getPassword()==null) {
						 	setErreur("complet","pseudonyme ou mot de passe incorrects.");
							this.setConnecter(false);
							return null;
					 } else {
						 this.setConnecter(true);
					 }
				}
				return target;		
		}
		
		
	
	
	
		private void validationMotsDePasse( String motDePasse) throws Exception {
		if ( motDePasse == null  ) {
		throw new Exception( "Entrez un Mot de passe !" );
		} else if ( motDePasse.length() < 3 ) {
		throw new Exception( "Mot de passe incorrecte ! " );
		}
		}

	
	
		private void ValidationUsername( String username ) throws Exception {
		if ( username == null) {
		throw new Exception( "Veuillez entrer votre pseudonyme ! " );
		} else if (username.length() < 3 ) {
			throw new Exception( "Veuillez entrer un pseudonyme correcte." );
		}
		}
	
	
		private static String getValeurChamp( HttpServletRequest request,String nomChamp ) {
		String valeur = request.getParameter( nomChamp );
		if ( valeur == null || valeur.trim().length() == 0 ) {	
		return null;
		} else {
			return valeur.trim();
		}
		}





		public Map<String, String> getErreur() {
			return erreur;
		}





		public void setErreur(Map<String, String> erreur) {
			this.erreur = erreur;
		}





		public boolean isConnecter() {
			return connecter;
		}





		public void setConnecter(boolean connecter) {
			this.connecter = connecter;
		}





		public static String getChampUsername() {
			return CHAMP_USERNAME;
		}





		public static String getChampPassword() {
			return CHAMP_PASSWORD;
		}
		
		private void setErreur( String champ, String message ) {
			erreur.put( champ, message );
			}
		
		
}
