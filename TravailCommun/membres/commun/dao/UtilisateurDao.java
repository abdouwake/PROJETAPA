package membres.commun.dao;

import membres.commun.beans.Utilisateur;

public interface UtilisateurDao {

    void creer( Utilisateur u ) throws IllegalArgumentException, DAOException;

    Utilisateur trouver( String username, String password ) throws DAOException;

    int trouver_by_username( String username ) throws DAOException;

    Utilisateur trouver( int iduser );

}
