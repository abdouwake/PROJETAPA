package membres.commun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import membres.commun.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {
	
		private static final String SQL_INSERT = "INSERT INTO public.\"Utilisateur\" ( username, nom, prenom, password, email, sexe) VALUES (?, ?, ?, ?, ?, ?)";
		private static final String SQL_SELECT = "SELECT username,password FROM public.\"Utilisateur\" where username=? AND password=?";
		private DAOFactory daoFactory; 

		UtilisateurDaoImpl( DAOFactory daoFactory ) {
		this.daoFactory = daoFactory;
		}
		
	 public void creer( Utilisateur u ) throws IllegalArgumentException, DAOException {
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_INSERT, true,u.getUsername(),u.getNom(),u.getPrenom(),u.getPassword(),u.getEmail(),u.getSexe());

			int statut = preparedStatement.executeUpdate();
			if ( statut == 0 ) {
			throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
			}
			
	/*
	 valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	if ( valeursAutoGenerees.next() ) {
	u.setId( valeursAutoGenerees.getLong( 1 ) );
	} else {
	throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
	}*/
	} catch ( SQLException e ) {
	throw new DAOException( e );
	} finally {
	utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	
	}
	}

	 
	 
	@Override
	public Utilisateur trouver(String username, String password) throws DAOException {
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		Utilisateur u = new Utilisateur();
		
		try{
				connexion = daoFactory.getConnection();
				preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,false,username,password);	
				
				preparedStatement.setString( 1, username );
				preparedStatement.setString( 2, password );
				
				ResultSet resultat = preparedStatement.executeQuery();
				
				/* Récupération des données du résultat de la requête de lecture */
				while ( resultat.next() ) {
					u.setUsername(resultat.getString("username"));
					u.setPassword(resultat.getString("password"));
				}
				
		}catch (SQLException e){
			
			 
			u=null;
			
		}finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
		}
		return u;
	}
	
}

