package membres.commun.beans;

import java.util.Date;

import membres.commun.dao.DAOFactory;
import membres.commun.dao.UtilisateurDao;
import membres.commun.dao.UtilisateurDaoImpl;
import membres.indiv.belkhiri.FichierDemandeDaoImpl;

public class Utilisateur {

    private int            id;
    private String         username;
    private String         nom;
    private String         prenom;
    private String         password;
    private String         email;
    private String         sexe;
    private UtilisateurDao utilisateurdao;

    public Utilisateur trouver( int iduser ) {

        DAOFactory daofactory = DAOFactory.getInstance();
        this.utilisateurdao = (UtilisateurDaoImpl) daofactory.getUtilisateurDao();

        Utilisateur user = utilisateurdao.trouver( iduser );
        return user;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe( String sexe ) {
        this.sexe = sexe;
    }

    public int getId() {
        return id;
    }

    public void setId( int i ) {
        this.id = i;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public int trouver_by_username( String username ) {

        DAOFactory daofactory = DAOFactory.getInstance();
        this.utilisateurdao = (UtilisateurDaoImpl) daofactory.getUtilisateurDao();

        int id = utilisateurdao.trouver_by_username( username );
        return id;
    }

}
