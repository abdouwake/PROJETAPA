package membres.indiv.belkhiri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import membres.commun.beans.Utilisateur;
import membres.commun.dao.DAOFactory;

public class Permis {
	private int idpermi;
	private int iddemande;
	private int iduser;
	private String from;
	private String to;
	private boolean etat;
	private String nature;
	private String url;
	private String but;
	private PermiDAO permidao;
	private String nomuser;
	private String prenomuser;
	 
	
	public ArrayList<Permis> afficher_tout(boolean revoquer){
		ArrayList<Permis> al = new ArrayList<Permis>();

		DAOFactory daofactory = DAOFactory.getInstance();
		this.permidao =  (PermiDaoImpl)daofactory.getPermiDao();
		
		al = permidao.afficher_permis(revoquer);
		return al;
	}
	
	public ArrayList<Permis> trouver_by_user(int iduser){
		ArrayList<Permis> al = new ArrayList<Permis>();

		DAOFactory daofactory = DAOFactory.getInstance();
		this.permidao =  (PermiDaoImpl)daofactory.getPermiDao();
		
		al = permidao.trouver_by_user(iduser);
		return al;
	}
	
	
	
	public ArrayList<Permis> chercher_parcourir(String name, String from,String to){
		ArrayList<Permis> al = new ArrayList<Permis>();
		ArrayList<Permis> resultat = new ArrayList<Permis>();
		ArrayList<Permis> bydates = new ArrayList<Permis>();

		
		String nom[]=null;
		if (name.isEmpty()==false) {
			nom = name.split(" ");
		}
		
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.permidao =  (PermiDaoImpl)daofactory.getPermiDao();
		
		al = permidao.afficher_tout();
		
		if (nom!=null) {
			for (int i=0;i<al.size();i++) {
				String Nom = al.get(i).getNomuser()+" "+al.get(i).getPrenomuser();
				String[] nomcomplet = Nom.split(" ");
				if (containes(nomcomplet,nom)){
					resultat.add(al.get(i));
				}
				
			}
		
		}
		
		if (from.isEmpty()==false && to.isEmpty()==false) {
			
			bydates= permidao.trouver_by_date(from, to);
			resultat.retainAll(bydates);
		}
		
		return resultat;
	}
	
	public boolean containes (String[] Chaine,String[] mot) {
		boolean contient=false;
		ArrayList<String> innutiles = new ArrayList<String> ();
 		
 		for (int i=0;i<Chaine.length;i++) {
 			for (int j=0;j<mot.length;j++) {
 				if (mot[j].equals(Chaine[i])) {					
					contient=true;
 				}
			 			
		}		
		}
		return contient;
	}
	
	
	public ArrayList<Permis> Chercher (HttpServletRequest request) {
		ArrayList<Permis> resultat = new ArrayList<Permis>();
		
		
		ArrayList<Permis> al = new ArrayList<Permis>();
		Permis p = new Permis();
		
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.permidao =  (PermiDaoImpl)daofactory.getPermiDao();
		 
		resultat = permidao.Chercher(request);
		
		return resultat;
		
	}
	
	  
	
	 
	public void Revoquer(int idpermi) {
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.permidao =  (PermiDaoImpl)daofactory.getPermiDao();
		
		permidao.Revoquer(idpermi);
	}
	
public void Reactiver(int idpermi) {
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.permidao =  (PermiDaoImpl)daofactory.getPermiDao();
		
		permidao.Reactiver(idpermi);
	}

	public String getNomuser() {
		return nomuser;
	}
	public void setNomuser(String nomuser) {
		this.nomuser = nomuser;
	}
	public String getPrenomuser() {
		return prenomuser;
	}
	public void setPrenomuser(String prenomuser) {
		this.prenomuser = prenomuser;
	}
	
	public ArrayList<Permis> afficher_tout(){
		DAOFactory daofactory = DAOFactory.getInstance();
		this.permidao =  (PermiDaoImpl)daofactory.getPermiDao();
		
		return permidao.afficher_tout();
		
	}
	public void creer(Permis p) {
		DAOFactory daofactory = DAOFactory.getInstance();
		this.permidao =  (PermiDaoImpl)daofactory.getPermiDao();
		
		Utilisateur user = new Utilisateur();
		user = user.trouver(p.getIduser());
		p.setIduser(user.getId());
		p.setNomuser(user.getNom());
		p.setPrenomuser(user.getPrenom());
		permidao.creer(p);
		
		DemandePermi d = new DemandePermi();
		d.update_set_done(p.getIddemande());
		
	}
	
	public int getIdpermi() {
		return idpermi;
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
	 
	 
	 

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setIdpermi(int idpermi) {
		this.idpermi = idpermi;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getBut() {
		return but;
	}

	public void setBut(String but) {
		this.but = but;
	}
	
	

}
