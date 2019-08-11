package membres.indiv.belkhiri;

import java.util.ArrayList;

import membres.commun.dao.DAOFactory;

public class ModeleEtape {
		
	private int idetape;
	private int idmodele;
	private String nom;
	private int ordre;
	private String role;
	private int coef;
	private EtapeModeleDao etapemodeledao;
	
	public void creer(ArrayList<ModeleEtape> al, int idmodele) {
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.etapemodeledao =  (EtapeModeleDaoImpl)daofactory.getEtapeModeleDao();
		
		etapemodeledao.ajouter(al,idmodele);
	}
	
	public ArrayList<ModeleEtape> trouver(int idmodele){
		ArrayList<ModeleEtape> al = new ArrayList<ModeleEtape>();
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.etapemodeledao =  (EtapeModeleDaoImpl)daofactory.getEtapeModeleDao();
		
		al = etapemodeledao.trouver(idmodele);
		return al;
		
	}
	
	
	public int getIdetape() {
		return idetape;
	}
	public void setIdetape(int idetape) {
		this.idetape = idetape;
	}
	public int getIdmodele() {
		return idmodele;
	}
	public void setIdmodele(int idmodele) {
		this.idmodele = idmodele;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getCoef() {
		return coef;
	}
	public void setCoef(int coef) {
		this.coef = coef;
	}
	
	
}
