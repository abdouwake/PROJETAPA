package membres.commun.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import membres.indiv.belkhiri.EtapeDao;
import membres.indiv.belkhiri.EtapeDaoImpl;
import membres.indiv.belkhiri.EtapeModeleDao;
import membres.indiv.belkhiri.EtapeModeleDaoImpl;
import membres.indiv.belkhiri.FichierDemandeDao;
import membres.indiv.belkhiri.FichierDemandeDaoImpl;
import membres.indiv.belkhiri.FichierFormulaireDao;
import membres.indiv.belkhiri.FichierFormulaireDaoImpl;
import membres.indiv.belkhiri.FileUploadDao;
import membres.indiv.belkhiri.FileUploadDaoImpl;
import membres.indiv.belkhiri.ModeleDao;
import membres.indiv.belkhiri.ModeleDaoImpl;
import membres.indiv.belkhiri.PermiDAO;
import membres.indiv.belkhiri.PermiDaoImpl;
import membres.indiv.belkhiri.QuestionDao;
import membres.indiv.belkhiri.QuestionDaoImpl;
import membres.indiv.belkhiri.ReponseDao;
import membres.indiv.belkhiri.ReponseDaoImpl;
import membres.indiv.belkhiri.WorkflowDao;
import membres.indiv.belkhiri.WorkflowDaoImpl;

public class DAOFactory {

    private static final String FICHIER_PROPERTIES       = "\\membres\\commun\\dao\\dao.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";
    private String              url;
    private String              username;
    private String              password;

    DAOFactory( String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /*
     * Méthode chargée de récupérer les informations de connexion à la base de
     * données, charger le driver JDBC et retourner une instance de la Factory
     */

    public static DAOFactory getInstance() throws DAOConfigurationException {

        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );
        if ( fichierProperties == null ) {
            throw new DAOConfigurationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }

        try {
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            driver = properties.getProperty( PROPERTY_DRIVER );
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES,
                    e );
        }

        try {
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
        }

        DAOFactory instance = new DAOFactory( url, nomUtilisateur, motDePasse );
        return instance;
    }

    /*
     * Méthode chargée de fournir une connexion à la base de données
     */
    /* package */

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection( url, username, password );
    }

    /*
     * METTEZ ICI TOUTES LES METHODES de récupération de l'implémentation des
     * différents DAO
     */

    public UtilisateurDao getUtilisateurDao() {
        return new UtilisateurDaoImpl( this );
    }

    public QuestionDao getQuestionDao() {
        return new QuestionDaoImpl( this );
    }

    public ReponseDao getReponseDao() {
        return new ReponseDaoImpl( this );
    }

    public FileUploadDao getFileUploadDao() {
        return new FileUploadDaoImpl( this );
    }

    public FichierDemandeDao getFichierDemandeDao() {
        return new FichierDemandeDaoImpl( this );
    }

    public FichierFormulaireDao getFichierFormulaireDao() {
        return new FichierFormulaireDaoImpl( this );
    }

    public ModeleDao getModeleDao() {
        return new ModeleDaoImpl( this );
    }

    public WorkflowDao getWorkflowDao() {
        return new WorkflowDaoImpl( this );
    }

    public EtapeDao getEtapeDao() {
        return new EtapeDaoImpl( this );
    }

    public EtapeModeleDao getEtapeModeleDao() {
        return new EtapeModeleDaoImpl( this );
    }

    public PermiDAO getPermiDao() {
        return new PermiDaoImpl( this );
    }

}
