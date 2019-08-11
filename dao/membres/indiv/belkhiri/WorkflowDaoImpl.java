package membres.indiv.belkhiri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import membres.commun.dao.DAOException;
import membres.commun.dao.DAOFactory;
import membres.commun.dao.DAOUtilitaire;

public class WorkflowDaoImpl implements WorkflowDao {
	private DAOFactory daoFactory; 
	private static final String SQL_INSERT ="INSERT INTO public.\"Workflow\" (idmodele,debut,nbsteps,encours,iduser,iddemande,archiver,notemine,note) VALUES (?,?,?,?,?,?,?,?,?) RETURNING idworkflow";

	public WorkflowDaoImpl( DAOFactory daoFactory ) {
		this.daoFactory = daoFactory;
		}
	
	@Override
	public int Creer(Workflow w) throws DAOException {
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

		
		try {
			connexion = daoFactory.getConnection();
			
	preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_INSERT, true,w.getIdmodele(),date,w.getNbsteps(),w.isEncours(),w.getIduser(),w.getIddemande(),w.isArchiver(),w.getNotemine(),w.getNote());
			
			int statut = preparedStatement.executeUpdate();
			if ( statut == 0 ) {
			throw new DAOException( "Échec de l'insertion du fichier demande" );
			}
			valeursAutoGenerees = preparedStatement.getGeneratedKeys();
			if ( valeursAutoGenerees.next() ) {
			/* Puis initialisation de la propriété id du bean
			Utilisateur avec sa valeur */
			int id= valeursAutoGenerees.getInt(1) ;
			w.setIdworkflow(id);}
			} catch ( SQLException e ) {
				System.out.println("mouchkil");
			throw new DAOException( e );
			} finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
			}
		
			return w.getIdworkflow();
	}

	@Override
	public Workflow trouver_by_iddemande(int iddemande) throws DAOException {
		Workflow w = new Workflow();
		 
		String SQL_SELECT ="SELECT * FROM public.\"Workflow\" where iddemande="+iddemande;
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,false);	
			
			ResultSet resultat = preparedStatement.executeQuery();
			
			while ( resultat.next() ) {
 				 w.setDebut(resultat.getDate("debut"));
				 w.setEncours(resultat.getBoolean("encours"));
				 w.setIddemande(resultat.getInt("iddemande"));
				 w.setIdmodele(resultat.getInt("idmodele"));
				 w.setIduser(resultat.getInt("iduser"));
				 w.setIdworkflow(resultat.getInt("idworkflow"));
				 w.setNbsteps(resultat.getInt("nbsteps"));
				 w.setNotemine(resultat.getInt("notemine"));
				 w.setArchiver(resultat.getBoolean("archiver")); 
				 w.setNote(resultat.getInt("note"));
			}
	
	}catch (SQLException e){
 		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
 
	return w;
		
	}
	public Workflow trouver(int idworkflow) throws DAOException {
		Workflow w = new Workflow();
		 
		String SQL_SELECT ="SELECT * FROM public.\"Workflow\" WHERE idworkflow="+idworkflow;
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,false);	
			
			ResultSet resultat = preparedStatement.executeQuery();
			/* Récupération des données du résultat de la requête de lecture */
			
			while ( resultat.next() ) {
				
				 w.setDebut(resultat.getDate("debut"));
				 w.setEncours(resultat.getBoolean("encours"));
				 w.setIddemande(resultat.getInt("iddemande"));
				 w.setIdmodele(resultat.getInt("idmodele"));
				 w.setIduser(resultat.getInt("iduser"));
				 w.setIdworkflow(resultat.getInt("idworkflow"));
				 w.setNbsteps(resultat.getInt("nbsteps"));
				 w.setNote(resultat.getInt("note"));

			}
	
	}catch (SQLException e){
 		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
 
	return w;

	}

	@Override
	public void MAJnote(int note, int idworkflow) {
		 
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		String SQL_UPDATE ="UPDATE public.\"Workflow\" SET note="+note+" WHERE idworkflow="+idworkflow;
		
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

	
	//iduser c pas celui qui est concerné par le workflow mais par la validation x)
	@Override
	public ArrayList<Workflow> Afficher_Liste_Workflows() {
		
		ArrayList<Workflow> liste = new  ArrayList<Workflow>();
		String SQL_SELECT ="SELECT * FROM public.\"Workflow\"";
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,false);	
			
			ResultSet resultat = preparedStatement.executeQuery();
			
			while ( resultat.next() ) {
				 Workflow w = new Workflow();
 				 w.setDebut(resultat.getDate("debut"));
				 w.setEncours(resultat.getBoolean("encours"));
				 w.setIddemande(resultat.getInt("iddemande"));
				 w.setIdmodele(resultat.getInt("idmodele"));
				 w.setIduser(resultat.getInt("iduser"));
				 w.setIdworkflow(resultat.getInt("idworkflow"));
				 w.setNbsteps(resultat.getInt("nbsteps"));
				 w.setNotemine(resultat.getInt("notemine"));
				 w.setArchiver(resultat.getBoolean("archiver")); 
				 w.setNote(resultat.getInt("note"));
				 
				 Etape e = new Etape();
				 w.setSteps(e.trouver(w.getIdworkflow()));
				 liste.add(w);
				 
			}	
	
	}catch (SQLException e){
 		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
 
	return liste;
	 
	}

	@Override
	public void set_terminer(int idworkflow) {
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		String SQL_UPDATE ="UPDATE public.\"Workflow\" SET archiver='true' WHERE idworkflow="+idworkflow;
		
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
	public boolean est_fini(int idworkflow) {
		
		String SQL_SELECT ="SELECT * FROM public.\"Etape\" where note IS NULL and idworkflow="+idworkflow;
		boolean empty = true;
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,false);	
			
			ResultSet resultat = preparedStatement.executeQuery();
			
			while ( resultat.next() ) {
				 empty=false;  
			}	
	
	}catch (SQLException e){
 		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
 
	return empty;
	}

	@Override
	public Workflow trouver_by_iduser(int iduser) throws DAOException {
		Workflow w = null;
		 
		String SQL_SELECT ="SELECT * FROM public.\"Workflow\" where iduser="+iduser;
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,false);	
			
			ResultSet resultat = preparedStatement.executeQuery();
			
			while ( resultat.next() ) {
			     w = new Workflow();
 				 w.setDebut(resultat.getDate("debut"));
				 w.setEncours(resultat.getBoolean("encours"));
				 w.setIddemande(resultat.getInt("iddemande"));
				 w.setIdmodele(resultat.getInt("idmodele"));
				 w.setIduser(resultat.getInt("iduser"));
				 w.setIdworkflow(resultat.getInt("idworkflow"));
				 w.setNbsteps(resultat.getInt("nbsteps"));
				 w.setNotemine(resultat.getInt("notemine"));
				 w.setArchiver(resultat.getBoolean("archiver")); 
				 w.setNote(resultat.getInt("note"));
			}
	
	}catch (SQLException e){
 		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
 
	return w;
	}

	@Override
	public void supprimer(int idworkflow) {
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		String SQL_UPDATE ="Delete from public.\"Workflow\" WHERE idworkflow="+idworkflow;
		
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
