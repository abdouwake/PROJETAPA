package membres.indiv.belkhiri;

import java.util.ArrayList;

import membres.commun.dao.DAOFactory;
import java.util.Collections;
public class Etape implements Comparable<Etape> {

	private int idetape;
	private int idworkflow;
 	private int iduser;
 	private int iddemande;
	private String nom;
	private String role;
	private int coeffiscient;
	private int note; //ENTRE 0 ET 20
	private int ordre;
	private EtapeDao etapedao;
	private boolean done;
	private boolean lock;
	
//POUR NOTER
//	APPELER TROUVER ETAPE 
//	APPELER NOTER
//	FIN
	
	public void supprimer(int idworkflow) {
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.etapedao =  (EtapeDaoImpl)daofactory.getEtapeDao();
		
		etapedao.supprimer(idworkflow);
	}
	
	
	public Etape whosNext (ArrayList<Etape> al) {
		Etape e = new Etape();
		boolean fini = false;
 		
		Collections.sort(al);
		int i=0;
		
		  while (!fini && (i<al.size())) {
			  boolean done = al.get(i).isDone();
			  if (done==true) {
				  fini=true;
				  e = al.get(i);
				  etapedao.Unlock(al.get(i).getIdetape());

 			  }	  
			  
			  i++;
		  }
		  
		  if(fini==false) {
			  return null;
		  }
		  
		 
		  
		return e;
		
	}
	
	
	public void unlock(Workflow w) {
	ArrayList<Etape> al = new ArrayList<Etape>();
	al = w.getSteps();
	Collections.sort(al);
	boolean fini=false;

	DAOFactory daofactory = DAOFactory.getInstance();
	this.etapedao =  (EtapeDaoImpl)daofactory.getEtapeDao();
	
	int i=0;
	
	 while (!fini && (i<al.size())) {
		 boolean lock = al.get(i).isLock();
		 if (lock==true) {
			 etapedao.Unlock(al.get(i).getIdetape());
			 fini=true;
		 }
		 
		i++; 
	 }
	 
		
	}
	
	
 	public void Noter(Etape e,int note) {
 		DAOFactory daofactory = DAOFactory.getInstance();
		this.etapedao =  (EtapeDaoImpl)daofactory.getEtapeDao();
		
		etapedao.Noter(note, e.getIdetape());
		
		
 		Workflow w = new Workflow();
		w=w.trouver(e.getIdworkflow());
		
 		int Sum_coef =0;
		int Sum_note=0;
		for(int i=0;i<w.getSteps().size();i++) {
			Sum_coef=Sum_coef + w.getSteps().get(i).getCoeffiscient();
			Sum_note=Sum_note+ (( w.getSteps().get(i).getNote())*w.getSteps().get(i).getCoeffiscient() );
		}
		
		int newNote = Sum_note/Sum_coef;
		
		w.MAJnote(newNote, w.getIdworkflow());
		
 	}
 	
 	public Etape trouver_Etape (int iduser,Workflow w) {
 		
 		ArrayList<Etape> al = new ArrayList<Etape>();
 		al=w.getSteps();
 		Etape e = null;
 		for (int i=0;i<al.size();i++) {
 			if ((al.get(i).getIduser()==iduser)&&(al.get(i).isDone()==true)){
 				e= al.get(i);
 				return e;
 			}
 		}
 		return e;
 	}
 	
	public void creer(Etape e) {
		

		DAOFactory daofactory = DAOFactory.getInstance();
		this.etapedao =  (EtapeDaoImpl)daofactory.getEtapeDao();
		
		etapedao.creer(e);
		
	}
	
	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public ArrayList<Etape> trouver(int idworkflow){
	ArrayList<Etape> al = new ArrayList<Etape>();
	
	DAOFactory daofactory = DAOFactory.getInstance();
	this.etapedao =  (EtapeDaoImpl)daofactory.getEtapeDao();
	
	
	al =  etapedao.trouver(idworkflow);
	return al;
		
	}
	
	
	public int getIdetape() {
		return idetape;
	}
	public void setIdetape(int idetape) {
		this.idetape = idetape;
	}
	public int getIdworkflow() {
		return idworkflow;
	}
	public void setIdworkflow(int idworkflow) {
		this.idworkflow = idworkflow;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getCoeffiscient() {
		return coeffiscient;
	}
	public void setCoeffiscient(int coeffiscient) {
		this.coeffiscient = coeffiscient;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	 
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	
	
	
	
	@Override
	public int compareTo(Etape e) {
		// TODO Auto-generated method stub
		return (this.idetape - e.getIdetape() );
	}



	public int getIddemande() {
		return iddemande;
	}



	public void setIddemande(int iddemande) {
		this.iddemande = iddemande;
	}



	/**
	 * @return the lock
	 */
	public boolean isLock() {
		return lock;
	}



	/**
	 * @param lock the lock to set
	 */
	public void setLock(boolean lock) {
		this.lock = lock;
	}


	
	
	
	
	
	
}
