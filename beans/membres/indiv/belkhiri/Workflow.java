package membres.indiv.belkhiri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import membres.commun.beans.Utilisateur;
import membres.commun.dao.DAOFactory;
import membres.commun.dao.UtilisateurDao;

public class Workflow {

	private int idworkflow;
	private int idmodele;
	private int iddemande;
	private int iduser;
	private Date debut;
	private int nbsteps;
	private int notemine;
	private boolean encours;
	private ArrayList<Etape> steps;
	WorkflowDao workflowdao;
	private boolean archiver;
	private int note;
	
	
	public void Supprimer(int idworkflow) {
		DAOFactory daofactory = DAOFactory.getInstance();
		this.workflowdao =  (WorkflowDaoImpl)daofactory.getWorkflowDao();	
		
		workflowdao.supprimer(idworkflow);
		Etape e = new Etape();
		e.supprimer(idworkflow);
	}
	
	public void set_terminer(int idworkflow) {
		DAOFactory daofactory = DAOFactory.getInstance();
		this.workflowdao =  (WorkflowDaoImpl)daofactory.getWorkflowDao();	
		
		workflowdao.set_terminer(idworkflow);
	}
	
	
	public boolean est_fini(Workflow w) {
		DAOFactory daofactory = DAOFactory.getInstance();
		this.workflowdao =  (WorkflowDaoImpl)daofactory.getWorkflowDao();
		
		return workflowdao.est_fini(w.getIdworkflow());
	}
	
	public ArrayList<Etape> trouver_Etape_User(int iduser){
		//fonction qui retourne toutes les etapes dont luser est concerner
		ArrayList<Workflow> workflow = new ArrayList<Workflow>();
		ArrayList<Etape> 	etape 	 = new ArrayList<Etape>();
		ArrayList<Etape>	resultat = new ArrayList<Etape>();

		DAOFactory daofactory = DAOFactory.getInstance();
		this.workflowdao =  (WorkflowDaoImpl)daofactory.getWorkflowDao();				
		
		workflow = workflowdao.Afficher_Liste_Workflows();
		
		for (int i=0;i<workflow.size();i++) {
 			etape = workflow.get(i).getSteps();
				for(int j=0;j<etape.size();j++) {
					Etape e = etape.get(j);
					if ((e.getIduser()==iduser) && (e.isLock()==false) && (e.isDone()==true) ) {
						resultat.add(e);
					}					
				}			
		}		
		
		return resultat;
	}
	
	
	
	public ArrayList<Workflow> Afficher_Liste_Workflow(int iduser) {
		ArrayList<Workflow> liste = new ArrayList<Workflow>();
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.workflowdao =  (WorkflowDaoImpl)daofactory.getWorkflowDao();
		
		 
		return liste;
	}
	
	public void MAJnote(int note, int idworkflow) {
		DAOFactory daofactory = DAOFactory.getInstance();
		this.workflowdao =  (WorkflowDaoImpl)daofactory.getWorkflowDao();
		
		workflowdao.MAJnote(note, idworkflow);
		
	}
 	
		public Workflow trouver_by_userid(int iduser) {
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.workflowdao =  (WorkflowDaoImpl)daofactory.getWorkflowDao();
		

		Workflow w = new Workflow();
		w = workflowdao.trouver_by_iduser(iduser);
		 
		if(w!=null) {
		Etape e= new Etape();
		w.setSteps(e.trouver(w.getIdworkflow()));
		}
		return w;
	}
	
	public Workflow trouver_by_iddemande(int iddemande) {
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.workflowdao =  (WorkflowDaoImpl)daofactory.getWorkflowDao();
		

		Workflow w = new Workflow();
		w = workflowdao.trouver_by_iddemande(iddemande);
		 
		Etape e= new Etape();
		w.setSteps(e.trouver(w.getIdworkflow()));
		
		return w;
	}
	
	public Workflow trouver(int idworkflow) {
		DAOFactory daofactory = DAOFactory.getInstance();
		this.workflowdao =  (WorkflowDaoImpl)daofactory.getWorkflowDao();
		Etape e= new Etape();
		Workflow w = new Workflow();
		w = workflowdao.trouver(idworkflow);
		w.setSteps(e.trouver(idworkflow));
		
		return w;
		
	} 
	
	public void creer (HttpServletRequest request,int idmodele, int iddemande,String[] acteurs) {
		
		ArrayList<Etape> al = new ArrayList<Etape>();
		DAOFactory daofactory = DAOFactory.getInstance();
		this.workflowdao =  (WorkflowDaoImpl)daofactory.getWorkflowDao();
		
		this.setIdmodele(idmodele);
		this.setIddemande(iddemande);
		Modele m = new Modele();
		m=m.recupererModele();
		this.setNbsteps(m.getNbsteps());
		this.setEncours(true);
		this.setNotemine(m.getNotemin());
		this.setArchiver(false);
		this.setNote(0); 
 		
		
		Utilisateur u=new Utilisateur();
 		DemandePermi d =  new DemandePermi();
 		d= d.trouver(d,iddemande);
 		
 		this.setIduser(d.getIduser());
		
		 this.setIdworkflow(workflowdao.Creer(this));
		 
		 
		 for (int i=0;i<this.getNbsteps();i++) {
			 Etape e = new Etape();
			 e.setCoeffiscient(m.getEtape().get(i).getCoef());
			 e.setIdworkflow(this.getIdworkflow());
			 e.setNom(m.getEtape().get(i).getNom());
			 e.setOrdre(i+1);
			 e.setRole(m.getEtape().get(i).getRole());
			 e.setDone(true);
			 e.setIddemande(iddemande);
			 int id = u.trouver_by_username(acteurs[i]);
			 if (i==0) {
				 e.setLock(false);
			 }else {
				 e.setLock(true);
			 }
 			 e.setIduser(id);
  			 al.add(e);
  			 e.creer(e);
		 }
		 this.setSteps(al);
		 
 
		 
 				
	}
	
	public int getIdworkflow() {
		return idworkflow;
	}
	public void setIdworkflow(int idworkflow) {
		this.idworkflow = idworkflow;
	}
	public int getIdmodele() {
		return idmodele;
	}
	public void setIdmodele(int idmodele) {
		this.idmodele = idmodele;
	}
	public Date getDebut() {
		return debut;
	}
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	public int getNbsteps() {
		return nbsteps;
	}
	public void setNbsteps(int nbsteps) {
		this.nbsteps = nbsteps;
	}
	public boolean isEncours() {
		return encours;
	}
	public void setEncours(boolean encours) {
		this.encours = encours;
	}
	 
	public ArrayList<Etape> getSteps() {
		return steps;
	}
	public void setSteps(ArrayList<Etape> steps) {
		this.steps = steps;
	}

	public int getIddemande() {
		return iddemande;
	}

	public void setIddemande(int iddemande) {
		this.iddemande = iddemande;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	
	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	
	public int getNotemine() {
		return notemine;
	}

	public void setNotemine(int notemine) {
		this.notemine = notemine;
	}
	public void setNote(int note) {
		this.note = note;
	}

	public int getNote() {
		return note;
	}
}
