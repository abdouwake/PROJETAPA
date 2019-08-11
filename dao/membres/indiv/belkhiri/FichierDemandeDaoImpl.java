package membres.indiv.belkhiri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import membres.commun.dao.DAOException;
import membres.commun.dao.DAOFactory;
import membres.commun.dao.DAOUtilitaire;

public class FichierDemandeDaoImpl implements FichierDemandeDao {
	private static final String SQL_INSERT ="INSERT INTO public.\"FichierDemande\" (nom,uri,extension,iddemande,nomuser,prenomuser) VALUES (?,?,?, ?, ?, ?)";
	private DAOFactory daoFactory; 

	
	public FichierDemandeDaoImpl( DAOFactory daoFactory ) {
		this.daoFactory = daoFactory;
		}
	
	@Override
	public void ajouter(FichierDemande f) throws DAOException {
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_INSERT, true,f.getNomFichier(),f.getURI(),f.getExtension(),f.getIdDemande(),f.getNom(),f.getPrenom());
			
			int statut = preparedStatement.executeUpdate();
			if ( statut == 0 ) {
			throw new DAOException( "Échec de l'insertion du fichier demande" );
			}
			} catch ( SQLException e ) {
				System.out.println("mouchkil");
			throw new DAOException( e );
			} finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
			}
	}
		
	

	@Override
	public ArrayList <FichierDemande> afficher	(int id)  throws DAOException {
		
	     String SQL_SELECT ="SELECT * FROM public.\"FichierDemande\" WHERE iddemande="+id;
	 	 ArrayList<FichierDemande> affichage = new ArrayList<FichierDemande>();
		 FichierDemande fichier = new FichierDemande();
		
		 
		 Connection 		  connexion 			 = null;
			PreparedStatement preparedStatement      = null;
			ResultSet         valeursAutoGenerees    = null;
			DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
			
			try{
				connexion = daoFactory.getConnection();
				preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,true);	
						
				ResultSet resultat = preparedStatement.executeQuery();
			 
				while ( resultat.next() ) {
					FichierDemande fichierdemande = new FichierDemande();
					fichierdemande.setExtension(resultat.getString("extension"));
					fichierdemande.setIdDemande(resultat.getInt("iddemande"));
					fichierdemande.setNomFichier(resultat.getString("nom"));
					fichierdemande.setURI(resultat.getString("uri"));
					fichierdemande.setNom(resultat.getString("nomuser"));
					fichierdemande.setPrenom(resultat.getString("prenomuser"));
					
					affichage.add(fichierdemande);
				}
				 
		}catch (SQLException e){

			
		}finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
		}
			
			
			
			return affichage;
		
	}

	@Override
	public ArrayList<FichierDemande> afficher_tout() throws DAOException {
		String SQL_SELECT ="SELECT * FROM public.\"FichierDemande\"";
	 	 ArrayList<FichierDemande> affichage = new ArrayList<FichierDemande>();
		 FichierDemande fichier = new FichierDemande();
		
		 
		 Connection 		  connexion 			 = null;
			PreparedStatement preparedStatement      = null;
			ResultSet         valeursAutoGenerees    = null;
			DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
			
			try{
				connexion = daoFactory.getConnection();
				preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,true);	
						
				ResultSet resultat = preparedStatement.executeQuery();
			 
				while ( resultat.next() ) {
					FichierDemande fichierdemande = new FichierDemande();
					fichierdemande.setExtension(resultat.getString("extension"));
					fichierdemande.setIdDemande(resultat.getInt("iddemande"));
					fichierdemande.setNomFichier(resultat.getString("nom"));
					fichierdemande.setURI(resultat.getString("uri"));	
					fichierdemande.setNom(resultat.getString("nomuser"));
					fichierdemande.setPrenom(resultat.getString("prenomuser"));
					affichage.add(fichierdemande);
				}
				 
		}catch (SQLException e){

			
		}finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
		}
			
			
			
			return affichage;
		
		
	 
	}

	@Override
	public ArrayList<FichierDemande> trouver_by_date(String from, String to) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");	 	
		java.sql.Date du = java.sql.Date.valueOf( from );
		java.sql.Date au = java.sql.Date.valueOf( to );
		
	 	 String SQL_SELECT ="SELECT * FROM public.\"FichierDemande\" WHERE date BETWEEN '"+du+"' AND '"+au+"'";
	 	 ArrayList<FichierDemande> affichage = new ArrayList<FichierDemande>();
		 FichierDemande fichier = new FichierDemande();
		
		 
		    Connection 		  connexion 			 = null;
			PreparedStatement preparedStatement      = null;
			ResultSet         valeursAutoGenerees    = null;
			DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
			
			try{
				connexion = daoFactory.getConnection();
				preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,true);	
						
				ResultSet resultat = preparedStatement.executeQuery();
			 
				while ( resultat.next() ) {
					FichierDemande fichierdemande = new FichierDemande();
					fichierdemande.setExtension(resultat.getString("extension"));
					fichierdemande.setIdDemande(resultat.getInt("iddemande"));
					fichierdemande.setNomFichier(resultat.getString("nom"));
					fichierdemande.setURI(resultat.getString("uri"));	
					fichierdemande.setNom(resultat.getString("nomuser"));
					fichierdemande.setPrenom(resultat.getString("prenomuser"));
					affichage.add(fichierdemande);
				}
				 
		}catch (SQLException e){

			
		}finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
		}
			
			
			
			return affichage;
	}

}
