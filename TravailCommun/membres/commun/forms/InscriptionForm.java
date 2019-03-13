package membres.commun.forms;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import membres.commun.beans.Utilisateur;
import membres.commun.dao.UtilisateurDao;



public class InscriptionForm {
	
	private UtilisateurDao 			utilisateurDao;
	private static final String 	CHAMP_USERNAME = "username";
	private static final String 	CHAMP_NOM 	   = "nom";
	private static final String		CHAMP_PRENOM   = "prenom";
	private static final String 	CHAMP_EMAIL    = "email";
	private static final String 	CHAMP_PASS     = "password";
	private static final String 	CHAMP_CONF     = "confmdp";
	private static final String 	CHAMP_SEXE     = "sexe";
	private	String 	resultat;
	private Map<String, String> erreurs= new HashMap<String,String>();
	private boolean ok=false;
	
	
	public InscriptionForm( UtilisateurDao utilisateurDao ) {
		this.utilisateurDao = utilisateurDao;
		}

	
	//méthode qui inscrire l'utilisateur
	public Utilisateur inscrireUtilisateur( HttpServletRequest request )
	{
		
	String username = getValeurChamp( request, CHAMP_USERNAME );
	String nom = getValeurChamp( request, CHAMP_NOM );
	String prenom = getValeurChamp( request, CHAMP_PRENOM );
	String email = getValeurChamp( request, CHAMP_EMAIL);
	String password = getValeurChamp( request, CHAMP_PASS );
	String confmdp = getValeurChamp( request, CHAMP_CONF );
	String sexe = getValeurChamp( request, CHAMP_SEXE );
	
	Utilisateur utilisateur = new Utilisateur();

	try {
		validationEmail( email );
		} catch ( Exception e ) {
		setErreur( CHAMP_EMAIL, e.getMessage() );
		}
		utilisateur.setEmail( email );
		
		try {
			validationMotsDePasse( password, confmdp );
			} catch ( Exception e ) {
			setErreur( CHAMP_PASS, e.getMessage() );
			setErreur( CHAMP_CONF, null );
			}
			utilisateur.setPassword( password );
			
			try {
				validationMotsDePasse( password, confmdp );
				} catch ( Exception e ) {
				setErreur( CHAMP_PASS, e.getMessage() );
				setErreur( CHAMP_CONF, null );
				}
			
			//------------------------------HACHE
			/*ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
			passwordEncryptor.setAlgorithm( "SHA-256" );
			passwordEncryptor.setPlainDigest( false );
			String motDePasseChiffre = passwordEncryptor.encryptPassword(password);
					
		    utilisateur.setPassword( password );*/
		
			 
			try { ValidationSexe(sexe);
			}catch (Exception e) {
				setErreur (CHAMP_SEXE,e.getMessage());
			}
			utilisateur.setSexe(sexe);
			
			try {ValidationUsername(username);
			}catch (Exception e) {
				setErreur(CHAMP_USERNAME,e.getMessage());
			}
			utilisateur.setUsername(username);
			
			try { ValidationNom(nom);
			}catch (Exception e) {
				setErreur(CHAMP_NOM,e.getMessage());
			}
			
			
			utilisateur.setNom(nom);
			
			
			try { ValidationPrenom(prenom);
			}catch (Exception e) {
				setErreur(CHAMP_PRENOM,e.getMessage());
			}
			utilisateur.setPrenom(prenom);
			
			if(erreurs.isEmpty()) {
				this.ok=true;
				utilisateurDao.creer( utilisateur );
				resultat = "Succès de l'inscription.";
			}
			else {
				this.ok=false;
				resultat = "Échec de l'inscription.";
			}
			
			
			
			return utilisateur;
	}
	
		
	
	//Methode pour récupérer l'argument depuis la requete http
	private static String getValeurChamp( HttpServletRequest request,String nomChamp ) {
	String valeur = request.getParameter( nomChamp );
	if ( valeur == null || valeur.trim().length() == 0 ) {	
	return null;
	} else {
		return valeur.trim();
	}
	}

	private void ValidationPrenom(String prenom) throws Exception {
		if (prenom==null) {
			throw new Exception ("Merci de saisir votre prenom.");
		}
	}
	
	private void validationEmail( String email ) throws Exception {
		if ( email != null ) {
		if ( !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
		throw new Exception( "Merci de saisir une adresse mail valide." );
		}
		} else {
		throw new Exception( "Merci de saisir une adresse mail." );
		}
		}

	
	private void ValidationSexe ( String sexe ) throws Exception {
		if ( !sexe.equals("sexe") ) {
		throw new Exception( "Merci de saisir votre sexe." );
		}
		} 
		
	private void ValidationNom(String nom) throws Exception {
		if (nom==null) {
			throw new Exception ("Merci de saisir votre nom.");
		}
	}
	
	private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
			if ( motDePasse != null && confirmation != null ) {
			if ( !motDePasse.equals( confirmation ) ) {
			throw new Exception( "Mots de passes différents !" );
			} else if ( motDePasse.length() < 3 ) {
			throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
			}
			} else {
			throw new Exception( "Merci de saisir mot de passe." );
			}
			}

	private void ValidationUsername( String username ) throws Exception {
		if ( username == null) {
		throw new Exception( "Veuillez entrer un pseudonyme ! " );
		} else if (username.length() < 3 ) {
			throw new Exception( "Le nom doit contenir au moins 3 caractères." );

		}
		}
	
	private void setErreur( String champ, String message ) {
		erreurs.put( champ, message );
		}
	

	public String getResultat() {
		return resultat;
	}



	public void setResultat(String resultat) {
		this.resultat = resultat;
	}



	public Map<String, String> getErreurs() {
		return erreurs;
	}



	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}



	public static String getChampUsername() {
		return CHAMP_USERNAME;
	}



	public static String getChampNom() {
		return CHAMP_NOM;
	}



	public static String getChampPrenom() {
		return CHAMP_PRENOM;
	}



	public static String getChampEmail() {
		return CHAMP_EMAIL;
	}



	public static String getChampPass() {
		return CHAMP_PASS;
	}



	public static String getChampConf() {
		return CHAMP_CONF;
	}



	public static String getChampSexe() {
		return CHAMP_SEXE;
	}



	public boolean isOk() {
		return ok;
	}



	public void setOk(boolean ok) {
		this.ok = ok;
	}


	
	
	
	
	
	
	
}
