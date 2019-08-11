package membres.indiv.belkhiri;

import java.util.ArrayList;

import membres.commun.dao.DAOFactory;

public class FichierDemande {
	
	private FichierDemandeDao fichierdemandedao;
	private int idDemande; // hadi clé étrangère
	private String nomFichier;
	private String Extension;
	private String URI;
	private String nom;
	private String prenom;
	
	
	public ArrayList<FichierDemande> chercher_parcourir(String name,String from,String to){
 		
		ArrayList<FichierDemande> al = new ArrayList<FichierDemande>();
		ArrayList<FichierDemande> resultat = new ArrayList<FichierDemande>();
		ArrayList<FichierDemande> bydates = new ArrayList<FichierDemande>();
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fichierdemandedao =  (FichierDemandeDaoImpl)daofactory.getFichierDemandeDao();
		
		al =  fichierdemandedao.afficher_tout();
		
		String nom[]=null;
		if (name.isEmpty()==false) {
			nom = name.split(" ");
		}
		
		
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
			
			bydates= fichierdemandedao.trouver_by_date(from, to);
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
	
	
	
	public ArrayList<FichierDemande> afficher_tout(){
		ArrayList<FichierDemande> al = new ArrayList<FichierDemande>();

		DAOFactory daofactory = DAOFactory.getInstance();
		this.fichierdemandedao =  (FichierDemandeDaoImpl)daofactory.getFichierDemandeDao();
		
		al= fichierdemandedao.afficher_tout();
		
		return al;
		
	}
	public ArrayList<FichierDemande>afficher(int id){
		ArrayList<FichierDemande> al = new ArrayList<FichierDemande>();
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fichierdemandedao =  (FichierDemandeDaoImpl)daofactory.getFichierDemandeDao();
		
		al= fichierdemandedao.afficher(id);
		
		return al;
		
		
	}
	
	public int getIdDemande() {
		return idDemande;
	}
	public void setIdDemande(int idDemande) {
		this.idDemande = idDemande;
	}
	public String getNomFichier() {
		return nomFichier;
	}
	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}
	public String getExtension() {
		return Extension;
	}
	public void setExtension(String extension) {
		Extension = extension;
	}
	public String getURI() {
		return URI;
	}
	public void setURI(String uRI) {
		URI = uRI;
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




	
}
