package membres.indiv.belkhiri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import membres.commun.dao.DAOException;
import membres.commun.dao.DAOFactory;
import membres.commun.dao.DAOUtilitaire;
import java.util.ArrayList;



	public class QuestionDaoImpl implements QuestionDao {
	public ArrayList affichage = new ArrayList(); 

	private DAOFactory daoFactory; 
	private static final String SQL_INSERT ="INSERT INTO public.\"Questions\" (titre,contenu,etat,valider,idUtilisateur,avoirreponse,date,username) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_SELECT ="SELECT titre,contenu,etat,valider,idquestion,idUtilisateur,avoirreponse FROM public.\"Questions\" ";
	 
	public QuestionDaoImpl( DAOFactory daoFactory ) {
		this.daoFactory = daoFactory;
		}

	
	@Override
	public void ajouter(Question q) throws DAOException {
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();

		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
 		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_INSERT, true,q.getTitre(),q.getContenu(),q.isEtat(),q.isValider(),q.getIDUtilisateur(),q.isAvoirReponse(),date,q.getUsername());
			
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
	public ArrayList  afficher(boolean tout) throws DAOException {
		
		
		ArrayList rep = new ArrayList();
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		int i=0;
		String SQL_SELECT_QUEST ="SELECT * FROM public.\"Questions\" ";
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT_QUEST,true);	
					
			ResultSet resultat = preparedStatement.executeQuery();
		 
			
			while ( resultat.next() ) {
				Question q= new Question();
				q.setId(resultat.getInt("idquestion"));
				q.setAvoirReponse(resultat.getBoolean("avoirreponse"));
				q.setEtat(resultat.getBoolean("etat"));
				q.setContenu(resultat.getString("contenu"));
				q.setIDUtilisateur(resultat.getInt("idutilisateur"));
				q.setTitre(resultat.getString("titre"));
				q.setValider(resultat.getBoolean("valider"));
				if (resultat.getDate("date") != null) {
				q.setDate(resultat.getDate("date"));	}	
				q.setUsername(resultat.getString("username"));
				
				int nb=0,j=0;
				if(q.isValider()==true) {
				if(tout==false) {
					if(q.isAvoirReponse()==true) {
						this.affichage.add(q);
							rep =getRep(q.getId());
							nb=rep.size();					
							if(nb!=0) {
								for (j=0;j<nb;j++) {
								this.affichage.add(rep.get(j));				
								}
								}
			 				
							}
					}
				else {
					
					this.affichage.add(q);
					if(q.isAvoirReponse()==true) {
						rep =getRep(q.getId());
					nb=rep.size();					
					if(nb!=0) {
						for (j=0;j<nb;j++) {
						this.affichage.add(rep.get(j));				
						}
				}
				}
				}
				} 
			}
	}catch (SQLException e){

		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
		
		
		
	return this.affichage;
	}


	
	public ArrayList getRep(int idquest) {
		
		ArrayList  al = new ArrayList();
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		

		String add = String.valueOf(idquest);
		String SQL_SELECT_REP ="SELECT * FROM public.\"Reponses\" where idquestion="+add;
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT_REP,false);	
			
			ResultSet resultat = preparedStatement.executeQuery();
			/* Récupération des données du résultat de la requête de lecture */
			
			while ( resultat.next() ) {
				
				Reponse r = new Reponse();
				r.setContenu(resultat.getString("contenu"));
				r.setValider(resultat.getBoolean("valider"));
				r.setDate(resultat.getDate("date"));
				
				if (resultat.getString("username") != null){
				r.setUsername(resultat.getString("username"));}
				 
				if (r.isValider()==true) {
 				al.add(r);
				}
			}
	
	}catch (SQLException e){

		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
		
		
		return al;
		
	}


	@Override
	public ArrayList Afficher_question() throws DAOException {
		
		String SQL_SELECT_quest ="SELECT * FROM public.\"Questions\" where valider="+false;
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
				
				Question q = new Question();
 				q.setContenu(resultat.getString("contenu"));
 				q.setIDUtilisateur(resultat.getInt("idutilisateur"));
				q.setId(resultat.getInt("idquestion"));
				q.setUsername(resultat.getString("username"));
				
 				al.add(q);
			}
	
	}catch (SQLException e){

		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
		
		
		
 		return al;
	}

 

	@Override
	public void Valider(int id) throws DAOException {
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		String SQL_UPDATE ="UPDATE public.\"Questions\" SET valider=true WHERE idquestion="+id;
		
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
	public void supprimer(int id) throws DAOException {
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		String SQL_DELETE ="DELETE FROM public.\"Questions\" WHERE idquestion="+id;
		
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


	

public void Update_avoirreponse(int id) throws DAOException {
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
  	 	 String SQL_UPDATE ="UPDATE public.\"Questions\" SET avoirreponse='true' WHERE idquestion="+id;
	 	 
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

 

	
	

}
