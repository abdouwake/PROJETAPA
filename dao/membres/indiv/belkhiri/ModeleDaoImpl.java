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

public class ModeleDaoImpl implements ModeleDao {
	private DAOFactory daoFactory; 
	private static final String SQL_SELECT ="SELECT * from public.\"Modele\"";
	private static final String SQL_INSERT ="INSERT INTO public.\"Modele\" (debut,nbsteps,valide,notemin) VALUES (?, ?, ?, ?) RETURNING idmodele";
	private static final String SQL_UPDATE = "UPDATE public.\"Modele\" SET valide=false";
	private int idmodele;
	
	public ModeleDaoImpl( DAOFactory daoFactory ) {
		this.daoFactory = daoFactory;
		}
	
	@Override
	
	public ArrayList<Modele> afficher_tout() throws DAOException{
		ArrayList<Modele> al = new ArrayList<Modele>();
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
 
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,true);	
					
			ResultSet resultat = preparedStatement.executeQuery();
		 
			while ( resultat.next() ) {
				Modele m = new Modele();
				m.setDebut(resultat.getDate("debut"));
				m.setIdmodele(resultat.getInt("idmodele"));
				m.setNbsteps(resultat.getInt("nbsteps"));
				m.setNotemin(resultat.getInt("notemin"));
				al.add(m);
			}
			 
	}catch (SQLException e){

		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
		
		
		return al;
		
	}
	
	
	public int getIdmodele() {
		return idmodele;
	}

	public void setIdmodele(int idmodele) {
		this.idmodele = idmodele;
	}

	public void Creer(Modele m) throws DAOException {
		
		ArrayList<Modele> al = new ArrayList<Modele>();

		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		al = afficher_tout();
		if (al!=null) {
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
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());		
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_INSERT, true,date,m.getNbsteps(),true,m.getNotemin());
			
			int statut = preparedStatement.executeUpdate();
			if ( statut == 0 ) {
			throw new DAOException( "Échec de l'insertion du fichier demande" );
			}
			valeursAutoGenerees = preparedStatement.getGeneratedKeys();
			if ( valeursAutoGenerees.next() ) {
			/* Puis initialisation de la propriété id du bean
			Utilisateur avec sa valeur */
			int idmodele = valeursAutoGenerees.getInt(1) ;
			this.setIdmodele(idmodele);
			}
			} catch ( SQLException e ) {
				System.out.println("mouchkil");
			throw new DAOException( e );
			}
			
		finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
			}
		
		
		ModeleEtape modele = new ModeleEtape();
		modele.creer(m.getEtape(),this.getIdmodele());
		
	}

	@Override
	public Modele trouver() throws DAOException {
	 String SQL_SELECT ="SELECT * from public.\"Modele\" where valide=true";
	 Modele actuel = new Modele();
	 
	 Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		 
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,true);	
					
			ResultSet resultat = preparedStatement.executeQuery();
		 
			while ( resultat.next() ) {
				 actuel.setDebut(resultat.getDate("debut"));
				 actuel.setIdmodele(resultat.getInt("idmodele"));
				 actuel.setNbsteps(resultat.getInt("nbsteps"));
				 actuel.setNotemin(resultat.getInt("notemin"));
				 actuel.setValide(true);
				 
			}
			 
	}catch (SQLException e){

		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
		 
		
		return actuel;
	}

}
