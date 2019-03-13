package membres.commun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import membres.commun.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {
	
		private static final String SQL_INSERT = "INSERT INTO public.\"Utilisateur\" (id, username, nom, prenom, password, email, sexe) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
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
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_INSERT, true,25,u.getUsername(),u.getNom(),u.getPrenom(),u.getPassword(),u.getEmail(),u.getSexe());

			int statut = preparedStatement.executeUpdate();
			if ( statut == 0 ) {
			throw new DAOException( "�chec de la cr�ation de l'utilisateur, aucune ligne ajout�e dans la table." );
			}
			
	valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	if ( valeursAutoGenerees.next() ) {
	u.setId( valeursAutoGenerees.getLong( 1 ) );
	} else {
	throw new DAOException( "�chec de la cr�ation de l'utilisateur en base, aucun ID auto-g�n�r� retourn�." );
	}
	} catch ( SQLException e ) {
	throw new DAOException( e );
	} finally {
	utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
	}
	
	
}

