package membres.indiv.belkhiri;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import membres.commun.beans.Utilisateur;
import membres.commun.dao.DAOFactory;

public class DemandePermi {

	private int iddemande;
	private String titre;
	private String uri;
	private String etat; //en traitement, actif,revoquer
	private boolean dansWorkflow; // pour voir si ça va s'afficher dans un workflow dans le tableau de bord du modérateur
	private int iduser;
	private FichierFormulaireDao fichierformulairedao;
	private String nom;
	private String prenom;
	private String nature;
	private String but;
	private Date   date;
	
	
	public ArrayList<DemandePermi> chercher_parcourir(String name,String from, String to) {
		ArrayList<DemandePermi> al = new ArrayList<DemandePermi>();
		ArrayList<DemandePermi> resultat = new ArrayList<DemandePermi>();
		ArrayList<DemandePermi> bydates = new ArrayList<DemandePermi>();

		DAOFactory daofactory = DAOFactory.getInstance();
		this.fichierformulairedao =  (FichierFormulaireDaoImpl)daofactory.getFichierFormulaireDao();
		
		
		
		String nom[]=null;
		if (name.isEmpty()==false) {
			nom = name.split(" ");
		}
		
		
		al = fichierformulairedao.afficher_tout();
		
		if (nom!=null) {
			for (int i=0;i<al.size();i++) {
				String Nom = al.get(i).getNom()+" "+al.get(i).getPrenom();
				String[] nomcomplet = Nom.split(" ");
				if (containes(nomcomplet,nom)){
					resultat.add(al.get(i));
				}
				
			}
		
		}
		
			if (from.isEmpty()==false && to.isEmpty()==false) {
			
			bydates= fichierformulairedao.trouver_by_date(from, to);
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
	
	
	
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getBut() {
		return but;
	}
	public void setBut(String but) {
		this.but = but;
	}
	
	public void update_set_done(int iddemande) {
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fichierformulairedao =  (FichierFormulaireDaoImpl)daofactory.getFichierFormulaireDao();
		
		fichierformulairedao.update_set_done(iddemande);
		
	}
	public ArrayList<DemandePermi> afficher_délivrance(){
		ArrayList<DemandePermi> affichage = new ArrayList<DemandePermi>();

		DAOFactory daofactory = DAOFactory.getInstance();
		this.fichierformulairedao =  (FichierFormulaireDaoImpl)daofactory.getFichierFormulaireDao();
		
		affichage = fichierformulairedao.Afficher_pour_délivrer();
		 
		return affichage;
	}
	
	public DemandePermi trouver(DemandePermi d,int iddemande) {
		 
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fichierformulairedao =  (FichierFormulaireDaoImpl)daofactory.getFichierFormulaireDao();
		
		return d=fichierformulairedao.trouver(iddemande);
		 		
	}
	
	public void set_terminer(int iddemande) {
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fichierformulairedao =  (FichierFormulaireDaoImpl)daofactory.getFichierFormulaireDao();
		
		fichierformulairedao.set_terminer(iddemande);
		
	}

	public void set_archiver(int iddemande) {
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fichierformulairedao =  (FichierFormulaireDaoImpl)daofactory.getFichierFormulaireDao();
		
		fichierformulairedao.set_archiver(iddemande);
	}
	
	public DemandePermi CreerDemande(HttpServletRequest request, DemandePermi d,String uri,Utilisateur user) {
		
		
		String title = "Demande de permi-"+ getValeurChamp(request,"nom");
		String state = new String();
		boolean workflow =false;
		d.setIduser(user.getId());
		d.setDansWorkflow(workflow);
		d.setEtat("En traitement");
		d.setTitre(title);
		d.setUri(uri);
 		return d;		
	}
	
	public void MAJ_demande(int iddemande) {
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fichierformulairedao =  (FichierFormulaireDaoImpl)daofactory.getFichierFormulaireDao();
		
 		fichierformulairedao.Dans_workflow(iddemande);
	}
	
	public ArrayList<DemandePermi> afficher_en_attente(){
		
		ArrayList<DemandePermi> affichage = new ArrayList<DemandePermi>();
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fichierformulairedao =  (FichierFormulaireDaoImpl)daofactory.getFichierFormulaireDao();
		
		
		
		affichage = fichierformulairedao.afficher_attente();
		
		return affichage;
	}
	public ArrayList<DemandePermi> afficher_tout(){
		ArrayList<DemandePermi> affichage = new ArrayList<DemandePermi>();
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fichierformulairedao =  (FichierFormulaireDaoImpl)daofactory.getFichierFormulaireDao();
		
		
		
		affichage = fichierformulairedao.afficher_tout();
		
		return affichage;
		
	}
	public ArrayList<DemandePermi> afficher(int id){
		ArrayList<DemandePermi> affichage = new ArrayList<DemandePermi>();
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fichierformulairedao =  (FichierFormulaireDaoImpl)daofactory.getFichierFormulaireDao();
		
		
		affichage = fichierformulairedao.afficher(id);
		return affichage;
		
	}
	
	public int getIddemande() {
		return iddemande;
	}



	public void setIddemande(int iddemande) {
		this.iddemande = iddemande;
	}



	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	 
  



 



	public String getEtat() {
		return etat;
	}



	public void setEtat(String etat) {
		this.etat = etat;
	}



	private static String getValeurChamp( HttpServletRequest request,String nomChamp ) {
		String valeur = request.getParameter( nomChamp );
		if ( valeur == null || valeur.trim().length() == 0 ) {	
		return null;
		} else {
			return valeur.trim();
		}
		}


	public boolean isDansWorkflow() {
		return dansWorkflow;
	}


	public void setDansWorkflow(boolean dansWorkflow) {
		this.dansWorkflow = dansWorkflow;
	}


	public int getIduser() {
		return iduser;
	}


	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
