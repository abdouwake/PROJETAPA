package membres.indiv.belkhiri;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import membres.commun.dao.DAOFactory;

public class FichierLoi {
	
	private int     ID_Fichier;
	private String  Extension;
	private String  extensionAr;
	private String  NomFichier;
	private String  nomarabe;
	private String  URL;
	private String  urlarabe;
	private String  ContenuOcr;
	private String  ContenuOcrAr;
	private int     Version;
	private boolean Archiver;
	private String  descriptionFr;
	private String  descriptionAr;
	private String  source;
	private String  sourcearabe;
	private Date date;


	 
	public ArrayList<FichierLoi> Chercher(boolean archiver,HttpServletRequest request){
		
		ArrayList<FichierLoi> affichage = new ArrayList<FichierLoi>();
		ArrayList<FichierLoi> resultat = new ArrayList<FichierLoi>();
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fileuploaddao =  (FileUploadDaoImpl)daofactory.getFileUploadDao();
		
		affichage=fileuploaddao.afficher(archiver);
	
		String from = request.getParameter("du");
		String to = request.getParameter("au");
		String param_search = request.getParameter("search");
		String param_contient = request.getParameter("contient");
		
		String contient[]=null;
		String mots[] =null;
		String search[]=null;
		String description[]=null;
		
		
		//POUR LA RECHERCHE NUMERO 1
		
		if (param_search.isEmpty() == false) { 
		 search = param_search.split(" ");		 
		}
		if (search!=null) {
		for (int i=0;i<affichage.size();i++) {			
			String titre = affichage.get(i).getNomFichier();
			mots = titre.split(" ");
			 
			if (containes(search,mots)==true) {
				resultat.add(affichage.get(i));
			}
		}
		
		for (int i=0;i<affichage.size();i++) {
			description = affichage.get(i).getDescriptionFr().split(" ");
			if( (description != null) && (search!= null) ) {
				if (containes(description,search)) {
					resultat.add(affichage.get(i));
				}
			}
		}
		}
		
		 
		
		//POUR  LA RECHERCHE OCR
		
		if (param_contient.isEmpty()==false) {
			contient = param_contient.split(" ");
			
		
		
		for (int i=0;i<affichage.size();i++) {
			String contenuocr[] = affichage.get(i).getContenuOcr().split(" ");
			System.out.println(contenuocr[i]);
			if( (contenuocr != null) && (contient!= null) ) {
				if (containes(contenuocr,contient)) {
					resultat.add(affichage.get(i));
				}
			}
		}
	}
		//POUR LA DATE ------------------------------------------
		ArrayList<FichierLoi> dates = new ArrayList<FichierLoi>();	
		if (from.isEmpty() ==false && to.isEmpty()==false) {
		dates = fileuploaddao.afficher_by_date(archiver, from, to);
		for (int i=0;i<dates.size();i++) {
			resultat.add(dates.get(i));
		}
		resultat.retainAll(dates); //INTERSECTION
		}
		
		//-------------------------------------
		
		//Si la date n'est pas null, on doit faire une intersection avec la liste resultat... parceque si on cherche
		//un fichier a une date précise, on doit l'avoir a cette date et pas autrement
		
		
		
		
		
		return resultat;
	}
	
	
	public boolean containes (String[] Chaine,String[] mot) {
		boolean contient=false;
		ArrayList<String> innutiles = new ArrayList<String> ();
		innutiles.addAll(Arrays.asList("a","à","de","pour","mais","où","est","donc","or","ce","cette","du","le","la","les","est","une","un","des","en","ou",""));
		
 		for (int i=0;i<Chaine.length;i++) {
 		  if(est_innutile(innutiles,Chaine[i]) == false) {
			for (int j=0;j<mot.length;j++) {
				if(est_innutile(innutiles,mot[j]) == false) {
				if (mot[j].equals(Chaine[i])) {					
					contient=true;
 				}
			}
			}			
		}		
		}
		return contient;
	}
	
	public boolean est_innutile (ArrayList<String> innutiles, String mot) {
		boolean contient=false;
		
		for (int i=0;i<innutiles.size();i++) {
			if (mot.equals(innutiles.get(i)) ){
				contient=true;
			}
		}
		
		return contient;
	}
	
	
	 
	
	public ArrayList<FichierLoi>  affichage = new ArrayList<FichierLoi>();
	private FileUploadDao fileuploaddao;
	
	
	public void inserer(FichierLoi f) {
		
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fileuploaddao =  (FileUploadDaoImpl)daofactory.getFileUploadDao();
		
		
		fileuploaddao.ajouter(f);
		
		 
	}
 
	
	
	
	
	public ArrayList<FichierLoi> afficher(boolean archiver) {
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fileuploaddao =  (FileUploadDaoImpl)daofactory.getFileUploadDao();
		
		affichage=fileuploaddao.afficher(archiver);
		
		return this.affichage;
	}
	
	public void Archiver(int id) {
		DAOFactory daofactory = DAOFactory.getInstance();
		this.fileuploaddao =  (FileUploadDaoImpl)daofactory.getFileUploadDao();
		
		fileuploaddao.Archiver(id);
	}
	
	public String getDescriptionFr() {
		return descriptionFr;
	}



	public void setDescriptionFr(String descriptionFr) {
		this.descriptionFr = descriptionFr;
	}



	public String getDescriptionAr() {
		return descriptionAr;
	}



	public void setDescriptionAr(String descriptionAr) {
		this.descriptionAr = descriptionAr;
	}



	public int getID_Fichier() {
		return ID_Fichier;
	}
	public void setID_Fichier(int iD_Fichier) {
		ID_Fichier = iD_Fichier;
	}
	public String getExtension() {
		return Extension;
	}
	public void setExtension(String extension) {
		Extension = extension;
	}
	public String getNomFichier() {
		return NomFichier;
	}
	public void setNomFichier(String nomFichier) {
		NomFichier = nomFichier;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getContenuOcr() {
		return ContenuOcr;
	}
	public void setContenuOcr(String contenuOcr) {
		ContenuOcr = contenuOcr;
	}
	public int getVersion() {
		return Version;
	}
	public void setVersion(int version) {
		Version = version;
	}
	public boolean isArchiver() {
		return Archiver;
	}
	public void setArchiver(boolean archiver) {
		Archiver = archiver;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}



	public String getNomarabe() {
		return nomarabe;
	}



	public void setNomarabe(String nomarabe) {
		this.nomarabe = nomarabe;
	}



	public String getUrlarabe() {
		return urlarabe;
	}



	public void setUrlarabe(String urlarabe) {
		this.urlarabe = urlarabe;
	}



	public String getSourcearabe() {
		return sourcearabe;
	}



	public void setSourcearabe(String sourcearabe) {
		this.sourcearabe = sourcearabe;
	}
	
	
	public String getExtensionAr() {
		return extensionAr;
	}



	public void setExtensionAr(String extensionAr) {
		this.extensionAr = extensionAr;
	}



	public String getContenuOcrAr() {
		return ContenuOcrAr;
	}



	public void setContenuOcrAr(String contenuOcrAr) {
		ContenuOcrAr = contenuOcrAr;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
		//ici la fonction qui Upload 
}
