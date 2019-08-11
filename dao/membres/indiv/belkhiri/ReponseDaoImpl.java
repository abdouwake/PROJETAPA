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

public class ReponseDaoImpl implements ReponseDao {
	
	private DAOFactory daoFactory; 
	private static final String SQL_INSERT ="INSERT INTO public.\"Reponses\" (contenu,valider,date,idquestion,idutilisateur,username) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE ="UPDATE public.\"Questions\" SET avoirreponse=true WHERE idquestion= ?";

		public ReponseDaoImpl( DAOFactory daoFactory ) {
		this.daoFactory = daoFactory;
		}
	
	
	@Override
	public void AjouterReponse(Reponse r) throws DAOException {

		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();

		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
 		try {
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_INSERT, true,r.getContenu(),r.isValider(),date,r.getIdquestion(),r.getIdutilisateur(),r.getUsername());

			
			int statut = preparedStatement.executeUpdate();
			if ( statut == 0 ) {
			throw new DAOException( "Échec de l'insertion de la question" );
			}
			
			 

			} catch ( SQLException e ) {
				System.out.println("mouchkil reponse ya jdk");
			throw new DAOException( e );
			} finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
			}
		
	}

 

	
	@Override
	public ArrayList Afficher_reponse() throws DAOException {
		String SQL_SELECT_quest ="SELECT * FROM public.\"Reponses\" where valider="+false;
		
		ArrayList  al = new ArrayList();
		
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT_quest,false);	
			
			ResultSet resultat = preparedStatement.executeQuery();
			/* Récupération des données du résultat de la requête de lecture */
			
			while ( resultat.next() ) {
				
				Reponse r = new Reponse();
 				r.setContenu(resultat.getString("contenu"));
 				r.setIdreponse(resultat.getInt("idreponse"));
 				r.setIdquestion(resultat.getInt("idquestion"));
 				r.setUsername(resultat.getString("username"));
 				
 				String SQL_SELECT_rep = " SELECT * FROM public.\"Questions\" where idquestion="+r.getIdquestion();
 						
 				try{
 					connexion = daoFactory.getConnection();
 					preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT_rep,false);	
 					ResultSet resultat2 = preparedStatement.executeQuery();
 					while ( resultat2.next() ) {
 						Question q = new Question();
 						q.setContenu(resultat2.getString("contenu"));
 						r.setContenuquestion(q.getContenu());
 					}
 				    }catch (SQLException e){ 						
 					}finally {
 						utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
 					}
 				
 				
 				al.add(r);
			}
	
	}catch (SQLException e){

		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
		
		
	return al;
	}




	@Override
	public void Valider(int id) {
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		String SQL_UPDATE ="UPDATE public.\"Reponses\" SET valider=true WHERE idreponse="+id;
		
 		try {
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_UPDATE, true);
			int statut = preparedStatement.executeUpdate();
			if ( statut == 0 ) {
			throw new DAOException( "Échec de la validation" );
			}

			} catch ( SQLException e ) {
 			throw new DAOException( e );
			} finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
			}
		
	}

	@Override
	public void Supprimer(int id) {
	
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		String SQL_DELETE ="DELETE FROM public.\"Reponses\" WHERE idreponse="+id;
		
 		try {
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_DELETE, true);
			int statut = preparedStatement.executeUpdate();
			if ( statut == 0 ) {
			throw new DAOException( "Échec de la validation" );
			}

			} catch ( SQLException e ) {
 			throw new DAOException( e );
			} finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
			}
 		
	}


	@Override
	public int trouver_id_question(int idreponse) {
		
		String SQL_SELECT ="SELECT * FROM public.\"Reponses\" where idreponse="+idreponse;
				
		Reponse r = new Reponse();
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
  				r.setIdquestion(resultat.getInt("idquestion"));
  				 
			}
	
	}catch (SQLException e){

		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
		
		
	return r.getIdquestion();
	}

	 
	
}
