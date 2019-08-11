package membres.indiv.belkhiri;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import membres.commun.dao.DAOFactory;
import membres.commun.dao.UtilisateurDao;
import membres.commun.dao.UtilisateurDaoImpl;

public class Question {

	public ArrayList  affichage = new ArrayList();
	private QuestionDao questionDao;
	private int id;
	private int IDUtilisateur;
	private String Titre;
	private String Contenu;
	private boolean Etat=false;;
	private boolean Valider=false;;
	private boolean AvoirReponse=false;;
	private Date 	date;
	private String username;
	
	public void update_avoirreponse(int idquestion) {
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.questionDao =  (QuestionDaoImpl)daofactory.getQuestionDao();
		
		questionDao.Update_avoirreponse(idquestion);
	}

	void valider(int id) {
		DAOFactory daofactory = DAOFactory.getInstance();
		this.questionDao =  (QuestionDaoImpl)daofactory.getQuestionDao();
		
		questionDao.Valider(id);
	}
	
	void supprimer (int id) {
		DAOFactory daofactory = DAOFactory.getInstance();
		this.questionDao =  (QuestionDaoImpl)daofactory.getQuestionDao();
		questionDao.supprimer(id);
	}

	void Poster (Question q) {
	
		DAOFactory daofactory = DAOFactory.getInstance();
		this.questionDao =  (QuestionDaoImpl)daofactory.getQuestionDao();

		try {
		questionDao.ajouter(q);
		} catch ( Exception e ) {
		
		}
		
	}
	
	public ArrayList Afficher_Question_Moderateur() {
		ArrayList al = new ArrayList();
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.questionDao =  (QuestionDaoImpl)daofactory.getQuestionDao();
		
		al = questionDao.Afficher_question();
		
		return al;
		
		
	}
	
	public  ArrayList  afficher (boolean tout) {
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.questionDao =  (QuestionDaoImpl)daofactory.getQuestionDao();
		
		if (tout==true) {
			
			 this.affichage=questionDao.afficher(true);

			}else {
				 this.affichage=questionDao.afficher(false);

			}
		
	 return this.affichage;
	}
	
	
	
	
	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIDUtilisateur() {
		return IDUtilisateur;
	}
	public void setIDUtilisateur(int iDUtilisateur) {
		IDUtilisateur = iDUtilisateur;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getContenu() {
		return Contenu;
	}
	public void setContenu(String contenu) {
		Contenu = contenu;
	}
	public boolean isEtat() {
		return Etat;
	}
	public void setEtat(boolean etat) {
		Etat = etat;
	}
	public boolean isValider() {
		return Valider;
	}
	public void setValider(boolean valider) {
		Valider = valider;
	}
	public boolean isAvoirReponse() {
		return AvoirReponse;
	}
	public void setAvoirReponse(boolean avoirReponse) {
		AvoirReponse = avoirReponse;
	}
	
	 


	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	
}
