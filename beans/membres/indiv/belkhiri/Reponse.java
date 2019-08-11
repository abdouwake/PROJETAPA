package membres.indiv.belkhiri;

import java.sql.Date;
import java.util.ArrayList;

import membres.commun.dao.DAOFactory;

public class Reponse {
	private ReponseDao reponsedao;

		private int idreponse;
		private String contenu;
		private boolean valider=false;
		private Date date;
		private int idutilisateur;
		private int idquestion;
		private String username;
		private String contenuquestion;
		
		
		
		public void valider(int id) {
			
			Question q = new Question();
			Reponse r = new Reponse();
			
			DAOFactory daofactory = DAOFactory.getInstance();
			this.reponsedao =  (ReponseDaoImpl)daofactory.getReponseDao();
			reponsedao.Valider(id);
			
 			int idquestion = r.trouver_id_question(id);

			q.update_avoirreponse(idquestion);
		}
		
		public void supprimer(int id) {
			DAOFactory daofactory = DAOFactory.getInstance();
			this.reponsedao =  (ReponseDaoImpl)daofactory.getReponseDao();
			reponsedao.Supprimer(id);
		}
		
		
		public void repondre(Reponse r) {
			
			DAOFactory daofactory = DAOFactory.getInstance();
			this.reponsedao =  (ReponseDaoImpl)daofactory.getReponseDao();
			
			reponsedao.AjouterReponse(r);
			 
		}
		
		public ArrayList afficher_reponses_moderateur() {
			ArrayList al = new ArrayList();
			
			DAOFactory daofactory = DAOFactory.getInstance();
			this.reponsedao =  (ReponseDaoImpl)daofactory.getReponseDao();
			
			al=reponsedao.Afficher_reponse();
			return al;
		}
		
		public int getIdreponse() {
			return idreponse;
		}
		public void setIdreponse(int idreponse) {
			this.idreponse = idreponse;
		}
		public String getContenu() {
			return contenu;
		}
		public void setContenu(String contenu) {
			this.contenu = contenu;
		}
		public boolean isValider() {
			return valider;
		}
		public void setValider(boolean valider) {
			this.valider = valider;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}

		public int getIdutilisateur() {
			return idutilisateur;
		}

		public void setIdutilisateur(int idutilisateur) {
			this.idutilisateur = idutilisateur;
		}

		public int getIdquestion() {
			return idquestion;
		}

		public void setIdquestion(int question) {
			this.idquestion = question;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getContenuquestion() {
			return contenuquestion;
		}

		public void setContenuquestion(String contenuquestion) {
			this.contenuquestion = contenuquestion;
		}

		public int trouver_id_question(int id) {
			
			DAOFactory daofactory = DAOFactory.getInstance();
			this.reponsedao =  (ReponseDaoImpl)daofactory.getReponseDao();
			
			int idquestion = reponsedao.trouver_id_question(id);
 			return idquestion;
			
		}
		
	
	
	 
}
