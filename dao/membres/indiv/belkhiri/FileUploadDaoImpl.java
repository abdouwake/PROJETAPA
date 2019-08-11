package membres.indiv.belkhiri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import membres.commun.dao.DAOException;
import membres.commun.dao.DAOFactory;
import membres.commun.dao.DAOUtilitaire;

public class FileUploadDaoImpl implements FileUploadDao {
	
	private DAOFactory daoFactory; 
	private static final String SQL_INSERT ="INSERT INTO public.\"FichiersLoi\" (extension,extensionar,nomfichier,nomarabe,url,urlarabe,contenuocr,contenuocrarabe,version,archiver,source,sourcearabe,date,descriptionfr,descriptionar) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  


	public FileUploadDaoImpl( DAOFactory daoFactory ) {
		this.daoFactory = daoFactory;
		}

	@Override
	public void ajouter(FichierLoi f) throws DAOException {
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_INSERT, true,f.getExtension(),f.getExtensionAr(),f.getNomFichier(),f.getNomarabe(),f.getURL(),f.getUrlarabe(),f.getContenuOcr(),f.getContenuOcrAr(),f.getVersion(),f.isArchiver(),f.getSource(),f.getSourcearabe(),date,f.getDescriptionFr(),f.getDescriptionAr());
			
			int statut = preparedStatement.executeUpdate();
			if ( statut == 0 ) {
			throw new DAOException( "Échec de l'insertion de la question" );
			}
			} catch ( SQLException e ) {
				System.out.println("mouchkil");
			throw new DAOException( e );
			} finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
			}
		
		
		
		
	}

	@Override
	public void Archiver (int id) throws DAOException {
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		String SQL_UPDATE ="UPDATE public.\"FichiersLoi\" SET archiver=true WHERE id_fichier="+id;
		
 		try {
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_UPDATE, true);
			int statut = preparedStatement.executeUpdate();
			if ( statut == 0 ) {
			throw new DAOException( "Échec de l'archivage" );
			}

			} catch ( SQLException e ) {
				System.out.println("mouchkil reponse ya jdk");
			throw new DAOException( e );
			} finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
			}
	}

	
	
	@Override
	public ArrayList<FichierLoi> afficher(boolean archiver) throws DAOException {
		
		String SQL_SELECT ="SELECT * FROM public.\"FichiersLoi\" WHERE archiver='"+archiver+"'";

		ArrayList<FichierLoi> liste = new ArrayList<FichierLoi>();
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,true);	
					
			ResultSet resultat = preparedStatement.executeQuery();
			
			while ( resultat.next() ) {
			FichierLoi fichier = new FichierLoi();
			
			fichier.setContenuOcr(resultat.getString("contenuocr"));
			fichier.setContenuOcrAr(resultat.getString("contenuocrarabe"));
			fichier.setNomFichier(resultat.getString("nomfichier"));
			fichier.setNomarabe(resultat.getString("nomarabe"));
			fichier.setDescriptionFr(resultat.getString("descriptionfr"));
			fichier.setDescriptionAr(resultat.getString("descriptionar"));
			fichier.setURL(resultat.getString("url"));
			fichier.setUrlarabe(resultat.getString("urlarabe"));
			fichier.setSource(resultat.getString("source"));
			fichier.setSourcearabe(resultat.getString("sourcearabe"));
			fichier.setID_Fichier(resultat.getInt("id_fichier"));
			fichier.setArchiver(resultat.getBoolean("archiver"));
			fichier.setDate(resultat.getDate("date"));
			
			if(archiver) {
				if (fichier.isArchiver()){	
				liste.add(fichier);			
				}
			}else {
			liste.add(fichier);
			}
			
			}
	}catch (SQLException e){

		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
		
		
		return liste;
		
	}

	@Override
	public ArrayList<FichierLoi> afficher_by_date(boolean archiver, String du, String au) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");	 	
		java.sql.Date from = java.sql.Date.valueOf( du );
		java.sql.Date to = java.sql.Date.valueOf( au );
		
		String SQL_SELECT ="SELECT * FROM public.\"FichiersLoi\" WHERE date between '"+from+"' AND '"+to+"'";

		ArrayList<FichierLoi> liste = new ArrayList<FichierLoi>();
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,true);	
					
			ResultSet resultat = preparedStatement.executeQuery();
			
			while ( resultat.next() ) {
			FichierLoi fichier = new FichierLoi();
			
			fichier.setContenuOcr(resultat.getString("contenuocr"));
			fichier.setContenuOcrAr(resultat.getString("contenuocrarabe"));
			fichier.setNomFichier(resultat.getString("nomfichier"));
			fichier.setNomarabe(resultat.getString("nomarabe"));
			fichier.setDescriptionFr(resultat.getString("descriptionfr"));
			fichier.setDescriptionAr(resultat.getString("descriptionar"));
			fichier.setURL(resultat.getString("url"));
			fichier.setUrlarabe(resultat.getString("urlarabe"));
			fichier.setSource(resultat.getString("source"));
			fichier.setSourcearabe(resultat.getString("sourcearabe"));
			fichier.setID_Fichier(resultat.getInt("id_fichier"));
			fichier.setArchiver(resultat.getBoolean("archiver"));
			fichier.setDate(resultat.getDate("date"));
			
			if( archiver) {
				if (fichier.isArchiver()){	
				liste.add(fichier);
				}
			}else {
			liste.add(fichier);
			}
			
			}
	}catch (SQLException e){

		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
		
		
		return liste;
	}

	
		
	 
	}


