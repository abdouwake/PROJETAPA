package membres.indiv.belkhiri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;
import membres.commun.beans.Utilisateur;
import membres.commun.dao.DAOException;
import membres.commun.dao.DAOFactory;
import membres.commun.dao.DAOUtilitaire;

public class FichierFormulaireDaoImpl implements FichierFormulaireDao {
	private DAOFactory daoFactory; 
	private static final String SQL_INSERT ="INSERT INTO public.\"DemandePermi\" (titre,uri,etat,dansworkflow,iduser,but,nature,date,nom,prenom) VALUES (?,?,?,?, ?, ?, ?, ?,?,?) RETURNING idpdfdemande";
	 
	
	public FichierFormulaireDaoImpl( DAOFactory daoFactory ) {
		this.daoFactory = daoFactory;
		}
	
	@Override
	public int ajouter(DemandePermi d) {
 		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
 		int id=0;
 		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_INSERT, true,d.getTitre(),d.getUri(),d.getEtat(),d.isDansWorkflow(),d.getIduser(),d.getBut(),d.getNature(),date,d.getNom(),d.getPrenom());
			
			int statut = preparedStatement.executeUpdate();
			if ( statut == 0 ) {
			throw new DAOException( "Échec de l'insertion du fichier demande" );
			}
			valeursAutoGenerees = preparedStatement.getGeneratedKeys();
			if ( valeursAutoGenerees.next() ) {
			/* Puis initialisation de la propriété id du bean
			Utilisateur avec sa valeur */
			id= valeursAutoGenerees.getInt(1) ;}
			}catch ( SQLException e ) {
				System.out.println("mouchkil");
			throw new DAOException( e );
			} finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
			}
		


		
		
		return id;
	}
		
	

	@Override
	public ArrayList<DemandePermi> afficher(int id) {
		
	 	ArrayList<DemandePermi> affichage = new ArrayList<DemandePermi>();
		String SQL_SELECT ="SELECT* FROM public.\"DemandePermi\" where iduser="+id;
		
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
					 DemandePermi demande = new DemandePermi();
					 demande.setDansWorkflow(resultat.getBoolean("dansworkflow"));
					 demande.setEtat(resultat.getString("etat"));
					 demande.setTitre(resultat.getString("titre"));
					 demande.setUri(resultat.getString("uri"));		
					 demande.setDate(resultat.getDate("date"));
					 demande.setNom(resultat.getString("nom"));
					 demande.setPrenom(resultat.getString("prenom"));
					 demande.setIduser(resultat.getInt("iduser"));
					 affichage.add(demande);
				}
		}catch (SQLException e){

			
		}finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
		}
			
			
			
			return affichage;
		
	}

	@Override
	public ArrayList<DemandePermi> afficher_tout() {
		
		ArrayList<DemandePermi> affichage = new ArrayList<DemandePermi>();
		String SQL_SELECT ="SELECT* FROM public.\"DemandePermi\"";
		
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
					 DemandePermi demande = new DemandePermi();
					 demande.setDansWorkflow(resultat.getBoolean("dansworkflow"));
					 demande.setEtat(resultat.getString("etat"));
					 demande.setTitre(resultat.getString("titre"));
					 demande.setUri(resultat.getString("uri"));	
					 demande.setIddemande(resultat.getInt("idpdfdemande"));
					 demande.setNom(resultat.getString("nom"));
					 demande.setPrenom(resultat.getString("prenom"));
					 demande.setBut(resultat.getString("but"));
					 demande.setNature(resultat.getString("nature"));
					 demande.setDate(resultat.getDate("date"));
					 demande.setIduser(resultat.getInt("iduser"));


 					 affichage.add(demande);
				}
		}catch (SQLException e){

			
		}finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
		}
			
			
			
			return affichage;
	}

	
	 
	public DemandePermi trouver(int id) {
		String Sql_brik = "SELECT * from public.\"DemandePermi\" where idpdfdemande="+id;

		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		DemandePermi demande = new DemandePermi();
			try{
				connexion = daoFactory.getConnection();
				preparedStatement = utile.initialisationRequetePreparee(connexion, Sql_brik,true);	
						
				ResultSet resultat = preparedStatement.executeQuery();
			 
				
				while ( resultat.next() ) {
					
					 demande.setDansWorkflow(resultat.getBoolean("dansworkflow"));
					 demande.setEtat(resultat.getString("etat"));
					 demande.setTitre(resultat.getString("titre"));
					 demande.setUri(resultat.getString("uri"));	
					 demande.setIddemande(resultat.getInt("idpdfdemande"));
					 demande.setNom(resultat.getString("nom"));
					 demande.setPrenom(resultat.getString("prenom"));
					 demande.setBut(resultat.getString("but"));
					 demande.setNature(resultat.getString("nature"));
					 demande.setDate(resultat.getDate("date"));
					 demande.setIduser(resultat.getInt("iduser"));

				}
		}catch (SQLException e){

			
		}finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
		}
			
		
		return demande;
	}

	public void Dans_workflow(int iddemande) {
		String SQL_SELECT ="UPDATE public.\"DemandePermi\" set dansworkflow=true where idpdfdemande="+iddemande;
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
	
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,true);	
					
			ResultSet resultat = preparedStatement.executeQuery();
		  
			}catch (SQLException e){
		
				
			}finally {
				utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
			}
				
			}
	
	public  ArrayList<DemandePermi> Afficher_pour_délivrer(){
		String etat ="";
		ArrayList<DemandePermi> affichage = new ArrayList<DemandePermi>();
		String SQL_SELECT ="SELECT* FROM public.\"DemandePermi\" where etat='terminer' ";
		
 		 
		    Connection 		  connexion 			 = null;
			PreparedStatement preparedStatement      = null;
			ResultSet         valeursAutoGenerees    = null;
			DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
			
			try{
				connexion = daoFactory.getConnection();
 				preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,false);	
						
				ResultSet resultat = preparedStatement.executeQuery();
			 
				
				while ( resultat.next() ) {
					 DemandePermi demande = new DemandePermi();
					 demande.setDansWorkflow(resultat.getBoolean("dansworkflow"));
					 demande.setEtat(resultat.getString("etat"));
					 demande.setTitre(resultat.getString("titre"));
					 demande.setUri(resultat.getString("uri"));	
					 demande.setIddemande(resultat.getInt("idpdfdemande"));
					 demande.setNom(resultat.getString("nom"));
					 demande.setPrenom(resultat.getString("prenom"));
					 demande.setBut(resultat.getString("but"));
					 demande.setNature(resultat.getString("nature"));
					 demande.setDate(resultat.getDate("date"));
					 demande.setIduser(resultat.getInt("iduser"));

					 
					 affichage.add(demande);
				}
		}catch (SQLException e){

			
		}finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
		}
			
			
			
			return affichage;
	}
	@Override
	public ArrayList<DemandePermi> afficher_attente() {

	 	ArrayList<DemandePermi> affichage = new ArrayList<DemandePermi>();
		String SQL_SELECT ="SELECT* FROM public.\"DemandePermi\" where dansworkflow="+false;
		
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
					 DemandePermi demande = new DemandePermi();
					 demande.setDansWorkflow(resultat.getBoolean("dansworkflow"));
					 demande.setEtat(resultat.getString("etat"));
					 demande.setTitre(resultat.getString("titre"));
					 demande.setUri(resultat.getString("uri"));	
					 demande.setIddemande(resultat.getInt("idpdfdemande"));
					 demande.setNom(resultat.getString("nom"));
					 demande.setPrenom(resultat.getString("prenom"));
					 demande.setBut(resultat.getString("but"));
					 demande.setNature(resultat.getString("nature"));
					 demande.setDate(resultat.getDate("date"));
					 demande.setIduser(resultat.getInt("iduser"));

					 affichage.add(demande);
				}
		}catch (SQLException e){

			
		}finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
		}
			
			
			
			return affichage;
	}

	@Override
	public void update_set_done(int iddemande) {
		
		String SQL_SELECT ="UPDATE public.\"DemandePermi\" set etat='terminer' where idpdfdemande="+iddemande;
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
	
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,true);	
					
			ResultSet resultat = preparedStatement.executeQuery();
		  
			}catch (SQLException e){
		
				
			}finally {
				utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
			}
				
		
	}

	@Override
	public ArrayList<DemandePermi> trouver_by_date(String from, String to) {
		 
		ArrayList<DemandePermi> affichage = new ArrayList<DemandePermi>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");	 	
		java.sql.Date du = java.sql.Date.valueOf( from );
		java.sql.Date au = java.sql.Date.valueOf( to );
		
		String SQL_SELECT ="SELECT* FROM public.\"DemandePermi\" where date BETWEEN '"+du+"' AND '"+au+"' ";
		
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
					 DemandePermi demande = new DemandePermi();
					 demande.setDansWorkflow(resultat.getBoolean("dansworkflow"));
					 demande.setEtat(resultat.getString("etat"));
					 demande.setTitre(resultat.getString("titre"));
					 demande.setUri(resultat.getString("uri"));	
					 demande.setIddemande(resultat.getInt("idpdfdemande"));
					 demande.setNom(resultat.getString("nom"));
					 demande.setPrenom(resultat.getString("prenom"));
					 demande.setBut(resultat.getString("but"));
					 demande.setNature(resultat.getString("nature"));
					 demande.setDate(resultat.getDate("date"));
					 demande.setIduser(resultat.getInt("iduser"));

					 affichage.add(demande);
				}
		}catch (SQLException e){

			
		}finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
		}
			
			
			
			return affichage;
		
	}

	@Override
	public void set_terminer(int iddemande) {
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		String SQL_UPDATE ="UPDATE public.\"DemandePermi\" SET etat='terminer' WHERE idpdfdemande="+iddemande;
		
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
	public void set_archiver(int iddemande) {
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		String SQL_UPDATE ="UPDATE public.\"DemandePermi\" SET etat='archiver' WHERE idpdfdemande="+iddemande;
		
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
}
