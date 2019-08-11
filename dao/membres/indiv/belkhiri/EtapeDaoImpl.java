package membres.indiv.belkhiri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import membres.commun.dao.DAOException;
import membres.commun.dao.DAOFactory;
import membres.commun.dao.DAOUtilitaire;

public class EtapeDaoImpl implements EtapeDao {
	private DAOFactory daoFactory; 
	private static final String SQL_INSERT ="INSERT INTO public.\"Etape\" (lock,idworkflow,nom,role,coeffiscient,done,iduser,iddemande) VALUES (?,?,?,?,?,?,?,?)";
	  

	public EtapeDaoImpl( DAOFactory daoFactory ) {
		this.daoFactory = daoFactory;
		}
	
	@Override
	public void creer(Etape e) throws DAOException {
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		 
		 
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_INSERT, true,e.isLock(),e.getIdworkflow(),e.getNom(),e.getRole(),e.getCoeffiscient(),e.isDone(),e.getIduser(),e.getIddemande());
			
			int statut = preparedStatement.executeUpdate();
			if ( statut == 0 ) {
			throw new DAOException( "Échec de l'insertion du fichier demande" );
			}
			
			}catch ( SQLException e1 ) {
				System.out.println("probleme somewhere");
			throw new DAOException( e1 );
			} finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
			}
		

		
	}

	@Override
	public ArrayList<Etape> trouver(int idworkflow) throws DAOException {
		String SQL_SELECT ="SELECT * from public.\"Etape\" WHERE idworkflow="+idworkflow;
		ArrayList<Etape> al = new ArrayList<Etape>();
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		 
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,true);	
					
			ResultSet resultat = preparedStatement.executeQuery();
		 
			while ( resultat.next() ) {
				Etape e = new Etape();
				e.setCoeffiscient(resultat.getInt("coeffiscient"));
				e.setIdetape(resultat.getInt("idetape"));
				e.setIdworkflow(resultat.getInt("idworkflow"));
				e.setNom(resultat.getString("nom"));
				e.setNote(resultat.getInt("note"));
				e.setRole(resultat.getString("role"));
				e.setDone(resultat.getBoolean("done"));
				e.setIduser(resultat.getInt("iduser"));
				e.setIddemande(resultat.getInt("iddemande"));
				e.setLock(resultat.getBoolean("lock"));
				al.add(e);
			}
			 
	}catch (SQLException e){

		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
		
		return al;
	}

	@Override
	public void Noter(int note, int idetape) throws DAOException {
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		String SQL_UPDATE ="UPDATE public.\"Etape\" SET note='"+note+"' , done='false' WHERE idetape="+idetape;
		
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
	
	public void Unlock(int idetape) throws DAOException {
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		String SQL_UPDATE ="UPDATE public.\"Etape\" SET lock='false' WHERE idetape="+idetape;
		
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
	public void supprimer(int idworkflow) {
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		String SQL_UPDATE ="DELETE FROM public.\"Etape\"  WHERE idworkflow="+idworkflow;
		
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
