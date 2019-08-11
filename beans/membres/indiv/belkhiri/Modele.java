package membres.indiv.belkhiri;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import membres.commun.dao.DAOFactory;

public class Modele {

	private int idmodele;
 	private Date Debut;
	private int nbsteps;
	private boolean valide; 
	private int notemin;
	private ModeleDao modeledao;
	private ArrayList<ModeleEtape> etape = new ArrayList<ModeleEtape>();
	
	
	 

	public ArrayList<ModeleEtape> getEtape() {
		return etape;
	}

	public void setEtape(ArrayList<ModeleEtape> etape) {
		this.etape = etape; 
	}
	
	public Modele recupererModele() {
		Modele m = new Modele();
		ModeleEtape e = new ModeleEtape();

		DAOFactory daofactory = DAOFactory.getInstance();
		this.modeledao =  (ModeleDaoImpl)daofactory.getModeleDao();
		
		m=modeledao.trouver();
		
		int idmodele= m.getIdmodele();
		m.setEtape( e.trouver(idmodele));
		
		return m;
		
	}
	
	
	
	public void CreerModele (String[] tab, Modele m) {
			//Instanciation des Etapes
		int i=0,j=0;
	 
		
		while(i<tab.length) {
 			 ModeleEtape e=  new ModeleEtape();
			 e.setOrdre(j);
			 e.setNom(tab[i]);
			 i++;
			 e.setRole(tab[i]);
			 i++;
			 e.setCoef(Integer.valueOf(tab[i]));
			 i++; 
			  
			 j++;
			 etape.add(e);
			 
		}
		
		m.etape=this.etape;
		 
		enregistrer_modele(m);
		
	}
	
	public void enregistrer_modele(Modele m) {
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.modeledao =  (ModeleDaoImpl)daofactory.getModeleDao();
		
		modeledao.Creer(m);
	}
	
	public int getIdmodele() {
		return idmodele;
	}
	public void setIdmodele(int idmodele) {
		this.idmodele = idmodele;
	}
	public Date getDebut() {
		return Debut;
	}
	public void setDebut(Date debut) {
		Debut = debut;
	}
	public int getNbsteps() {
		return nbsteps;
	}
	public void setNbsteps(int nbsteps) {
		this.nbsteps = nbsteps;
	}
	 
	public boolean isValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	public int getNotemin() {
		return notemin;
	}
	public void setNotemin(int notemin) {
		this.notemin = notemin;
	}
	 
	
	
	
}
