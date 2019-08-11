package membres.indiv.belkhiri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import membres.commun.dao.DAOException;
import membres.commun.dao.DAOFactory;
import membres.commun.dao.DAOUtilitaire;


public class EtapeModeleDaoImpl implements EtapeModeleDao {

	private DAOFactory daoFactory; 
	private static final String SQL_INSERT ="INSERT INTO public.\"ModeleEtape\" (nometape,coefetape,ordre,role,idmodele) VALUES (?, ?, ?, ?, ?)";
  

	public EtapeModeleDaoImpl( DAOFactory daoFactory ) {
		this.daoFactory = daoFactory;
		}
	
	@Override
	public ArrayList<ModeleEtape> trouver(int idmodele) {
		String SQL_SELECT ="SELECT * FROM public.\"ModeleEtape\" WHERE idmodele="+idmodele;
		ArrayList<ModeleEtape> al = new ArrayList<ModeleEtape>();
		
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
				
				ModeleEtape e = new ModeleEtape();
				e.setCoef(resultat.getInt("coefetape"));
				e.setNom(resultat.getString("nometape"));
				e.setRole(resultat.getString("role"));
				e.setOrdre(resultat.getInt("ordre"));
				e.setIdmodele(resultat.getInt("idmodele"));
			

				al.add(e);
			}
	
	}catch (SQLException e){
 		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}

		return al;
	}

	@Override
	public void ajouter(ArrayList<ModeleEtape> al, int idmodele) {
 
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		 
		for(int i=0;i<al.size();i++) {
		 
			ModeleEtape e = al.get(i);
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_INSERT, true,e.getNom(),e.getCoef(),e.getOrdre(),e.getRole(),idmodele);
			
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
		
		
		
	}
		
	}

	

