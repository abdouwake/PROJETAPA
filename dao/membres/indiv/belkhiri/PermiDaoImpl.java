package membres.indiv.belkhiri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import membres.commun.dao.DAOException;
import membres.commun.dao.DAOFactory;
import membres.commun.dao.DAOUtilitaire;

public class PermiDaoImpl implements PermiDAO{
	
	private static final String SQL_INSERT ="INSERT INTO public.\"Permi\" (idpermi,iddemande,iduser,du,au,etat,nature,url,nom,prenom) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private DAOFactory daoFactory; 
	
	public PermiDaoImpl( DAOFactory daoFactory ) {
		this.daoFactory = daoFactory;
		}
	
	@Override 
	public void creer(Permis p){
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		 
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
 		 
 	
		java.sql.Date from = java.sql.Date.valueOf( p.getFrom() );
		java.sql.Date to = java.sql.Date.valueOf( p.getTo() );



		try {
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_INSERT, true,p.getIdpermi(),p.getIddemande(),p.getIduser(),from,to,true,p.getNature(),p.getUrl(),p.getNomuser(),p.getPrenomuser());
			
			int statut = preparedStatement.executeUpdate();
			if ( statut == 0 ) {
			throw new DAOException( "Échec de l'insertion du fichier Permi" );
			}
			
			}catch ( SQLException e1 ) {
				System.out.println("probleme somewhere");
			throw new DAOException( e1 );
			} finally {
			utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
			}
	}

	@Override
	public Permis trouver(int idpermi) {
		Permis p = new Permis();
		
		String SQL_SELECT ="SELECT * from public.\"Permi\" WHERE idpermi="+idpermi;
 		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		 
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,true);	
					
			ResultSet resultat = preparedStatement.executeQuery();
			DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
			while ( resultat.next() ) {
				 p.setEtat(resultat.getBoolean("etat"));
				 
				 p.setIddemande(resultat.getInt("iddemande"));
				 p.setIdpermi(resultat.getInt("idpermi"));
				 p.setIduser(resultat.getInt("iduser"));
				 p.setNature(resultat.getString("nature"));
				 p.setUrl(resultat.getString("url"));
				 p.setNomuser(resultat.getString("nom"));
				 p.setPrenomuser(resultat.getString("prenom"));
				 p.setEtat(resultat.getBoolean("etat"));
				 Date d =resultat.getDate("du");
				 p.setFrom(dateFormat.format(d));
				 
				 d= resultat.getDate("au");
				 p.setTo(dateFormat.format(d));
 				 
			}
			 
	}catch (SQLException e){

		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
		
		return p;
	}

	@Override
	public ArrayList<Permis> afficher_permis(boolean revoquer) {
		String SQL_SELECT ="SELECT * FROM public.\"Permi\" where etat="+revoquer;
		ArrayList<Permis> al = new ArrayList<Permis>();
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,false);	
			
			ResultSet resultat = preparedStatement.executeQuery();
			
			while ( resultat.next() ) {
				Permis p = new Permis();
				 p.setEtat(resultat.getBoolean("etat"));
				 Date from = resultat.getDate("du");
				 p.setFrom(from.toString());
				 p.setIddemande(resultat.getInt("iddemande"));
				 p.setIdpermi(resultat.getInt("idpermi"));
				 p.setIduser(resultat.getInt("iduser"));
				 p.setNature(resultat.getString("nature"));
				 Date to = resultat.getDate("au");
				 p.setTo(to.toString());
				 p.setUrl(resultat.getString("url"));
				 p.setNomuser(resultat.getString("nom"));
				 p.setPrenomuser(resultat.getString("prenom"));
 
				 al.add(p);
			}
	
	}catch (SQLException e){
 		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
 
		
		return al;
	}

	@Override
	public ArrayList<Permis> afficher_tout() {
		String SQL_SELECT ="SELECT * FROM public.\"Permi\"";
		ArrayList<Permis> al = new ArrayList<Permis>();
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,false);	
			
			ResultSet resultat = preparedStatement.executeQuery();
			
			while ( resultat.next() ) {
				Permis p = new Permis();
				 p.setEtat(resultat.getBoolean("etat"));
				 Date from = resultat.getDate("du");
				 p.setFrom(from.toString());
				 p.setIddemande(resultat.getInt("iddemande"));
				 p.setIdpermi(resultat.getInt("idpermi"));
				 p.setIduser(resultat.getInt("iduser"));
				 p.setNature(resultat.getString("nature"));
				 Date to = resultat.getDate("au");
				 p.setTo(to.toString());
				 p.setUrl(resultat.getString("url"));
				 p.setNomuser(resultat.getString("nom"));
				 p.setPrenomuser(resultat.getString("prenom"));
 
				 al.add(p);
			}
	
	}catch (SQLException e){
 		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
 
		
		return al;
	}

	@Override
	public void Revoquer(int idpermi) {
		String SQL_UPDATE ="UPDATE public.\"Permi\" set etat='false' where idpermi="+idpermi;
	 
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_UPDATE,false);	
			
			ResultSet resultat = preparedStatement.executeQuery();
			 
			
	}catch (SQLException e){ 
 		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
		
		
	}

	@Override
	public void Reactiver(int idpermi) {
		String SQL_UPDATE ="UPDATE public.\"Permi\" set etat='true' where idpermi="+idpermi;
	 
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_UPDATE,false);	
			
			ResultSet resultat = preparedStatement.executeQuery();
			
			
	}catch (SQLException e){
 		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
		
		
	}

	@Override
	public ArrayList<Permis> Chercher(HttpServletRequest request) {
		 
		ArrayList<Permis> al = new ArrayList<Permis>();
		
		String id =request.getParameter("idpermi");
 		int idpermi=0;
		
		if (!id.isEmpty()){
			idpermi= Integer.valueOf(id);
		}
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String etat = request.getParameter("etat");
		
		 
		
		String REQUETE = "SELECT * FROM public.\"Permi\" ";
		if ( (!nom.isEmpty()) || (!prenom.isEmpty()) || (!etat.equals("Etat du permi")) ||(idpermi!=0) ) {
			REQUETE =REQUETE + " WHERE ";
		}
		
		if(!nom.isEmpty()) {
			REQUETE = REQUETE + "nom='"+nom+"' ";
		}
		if(!prenom.isEmpty()) {
			if(!nom.isEmpty()) {
				REQUETE = REQUETE +" AND ";
			}
			REQUETE = REQUETE + " prenom='"+prenom+"' ";
		}
		
		if(idpermi!=0) {
			if(!nom.isEmpty() || !prenom.isEmpty()) {
				REQUETE = REQUETE +" AND ";
			}
			REQUETE = REQUETE +" idpermi='"+idpermi+"' ";
		}
		
		
		
		if(etat.equals("true") || etat.equals("tous")){
			if(!nom.isEmpty() || !prenom.isEmpty() || idpermi!=0) {
				REQUETE = REQUETE +" AND ";
			}
			REQUETE =REQUETE +" etat='true' ";
		}
		
		if(etat.equals("false")) {
			if(!nom.isEmpty() || !prenom.isEmpty() || idpermi!=0) {
				REQUETE = REQUETE +" AND ";
			}
			REQUETE = REQUETE +" etat='false' ";
		}
		 

		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, REQUETE,false);	
			
			ResultSet resultat = preparedStatement.executeQuery();
			
			while ( resultat.next() ) {
				Permis p = new Permis();
				 p.setEtat(resultat.getBoolean("etat"));
				 Date from = resultat.getDate("du");
				 p.setFrom(from.toString());
				 p.setIddemande(resultat.getInt("iddemande"));
				 p.setIdpermi(resultat.getInt("idpermi"));
				 p.setIduser(resultat.getInt("iduser"));
				 p.setNature(resultat.getString("nature"));
				 Date to = resultat.getDate("au");
				 p.setTo(to.toString());
				 p.setUrl(resultat.getString("url"));
				 p.setNomuser(resultat.getString("nom"));
				 p.setPrenomuser(resultat.getString("prenom"));
				 
				 al.add(p);
			}
	
	}catch (SQLException e){
 		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
 
		
		return al;
		
	}

	@Override
	public ArrayList<Permis> trouver_by_date(String from, String to) {
		
		Permis p = new Permis();
		ArrayList<Permis> result = new ArrayList<Permis>();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");	 	
		java.sql.Date du = java.sql.Date.valueOf( from );
		java.sql.Date au = java.sql.Date.valueOf( to );
		
		String SQL_SELECT ="SELECT * from public.\"Permi\" WHERE du BETWEEN '"+du+"' AND '"+au+"'";
 		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		 
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,true);	
					
			ResultSet resultat = preparedStatement.executeQuery();
			DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
			while ( resultat.next() ) {
				 p.setEtat(resultat.getBoolean("etat"));
				 
				 p.setIddemande(resultat.getInt("iddemande"));
				 p.setIdpermi(resultat.getInt("idpermi"));
				 p.setIduser(resultat.getInt("iduser"));
				 p.setNature(resultat.getString("nature"));
				 p.setUrl(resultat.getString("url"));
				 p.setNomuser(resultat.getString("nom"));
				 p.setPrenomuser(resultat.getString("prenom"));
				 p.setEtat(resultat.getBoolean("etat"));

				 Date d =resultat.getDate("du");
				 p.setFrom(dateFormat.format(d));
				 
				 d= resultat.getDate("au");
				 p.setTo(dateFormat.format(d));
				 result.add(p);
				 
 				 
			}
			 
	}catch (SQLException e){

		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
		
		return result;
	}

	@Override
	public ArrayList<Permis> trouver_by_user(int iduser) {
		String SQL_SELECT ="SELECT * FROM public.\"Permi\" where iduser="+iduser;
		ArrayList<Permis> al = new ArrayList<Permis>();
		
		Connection 		  connexion 			 = null;
		PreparedStatement preparedStatement      = null;
		ResultSet         valeursAutoGenerees    = null;
		DAOUtilitaire     utile 				 = new DAOUtilitaire();
		
		try{
			connexion = daoFactory.getConnection();
			preparedStatement = utile.initialisationRequetePreparee(connexion, SQL_SELECT,false);	
			
			ResultSet resultat = preparedStatement.executeQuery();
			
			while ( resultat.next() ) {
				Permis p = new Permis();
				 p.setEtat(resultat.getBoolean("etat"));
				 Date from = resultat.getDate("du");
				 p.setFrom(from.toString());
				 p.setIddemande(resultat.getInt("iddemande"));
				 p.setIdpermi(resultat.getInt("idpermi"));
				 p.setIduser(resultat.getInt("iduser"));
				 p.setNature(resultat.getString("nature"));
				 Date to = resultat.getDate("au");
				 p.setTo(to.toString());
				 p.setUrl(resultat.getString("url"));
				 p.setNomuser(resultat.getString("nom"));
				 p.setPrenomuser(resultat.getString("prenom"));
				 
				 al.add(p);
			}
	
	}catch (SQLException e){
 		
	}finally {
		utile.fermeturesSilencieuses( valeursAutoGenerees,preparedStatement, connexion );
	}
 
		
		return al;
	}

}
