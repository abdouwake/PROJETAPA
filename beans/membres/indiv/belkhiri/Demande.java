package membres.indiv.belkhiri;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import membres.commun.dao.DAOFactory;

public class Demande {
	private String nom;
	private String prenom;
	private String email;
	private String numero;
	private String adresse;
	private String URLidentité;
	private String titreProjet;
	private String resume;
	private String lieu;
	private String longitude;
	private String latitude;
	private String duree;
	
	private String nomEntreprise;
	private String siegeEntreprise;
	private String numeroEntreprise;
	private String siteEntreprise;
	private String nomFournisseur;
	private String URLautorisation;
	private String nomRessource;
	private String taxonRessource;
	private String quantite;
	private String idCommunaute;
	private String typeConnaissance;
	private String DescriptionUsage;
	private String connaissanceUtilisation;
	private String PermiType;
	private String PermisBut;
	private String   debut;
	private String   fin;
	private String URIdemandemanuscrite;
	private String URIdescriptionprojet;
	private int idDemandeClass;
	
	public Demande Creer(HttpServletRequest request, Demande d) throws IOException, ServletException {	 
		
		d.setNom(getValeurChamp(request,"nom"));
		d.setPrenom(getValeurChamp(request,"prenom"));
		d.setEmail(getValeurChamp(request,"email"));
		d.setNumero(getValeurChamp(request,"numero"));
		d.setAdresse(getValeurChamp(request,"adresse"));
		d.setTitreProjet(getValeurChamp(request, "titreprojet"));
		d.setLieu(getValeurChamp(request,"localisation"));
		d.setLongitude(getValeurChamp(request,"longitude"));
		d.setLatitude(getValeurChamp(request,"latitude"));
		d.setDuree(getValeurChamp(request,"duree"));
		d.setNomEntreprise(getValeurChamp(request,"nomentreprise"));
		d.setSiegeEntreprise(getValeurChamp(request,"siege"));
		d.setNumeroEntreprise(getValeurChamp(request,"numeroentreprise"));
		d.setSiteEntreprise(getValeurChamp(request,"siteentreprise"));
		d.setNomFournisseur(getValeurChamp(request,"fournisseurnom"));
		d.setNomRessource(getValeurChamp(request,"nomusuel"));
		d.setTaxonRessource(getValeurChamp(request,"taxonomie"));
		d.setQuantite(getValeurChamp(request,"quantite"));
		d.setIdCommunaute(getValeurChamp(request,"community"));
		d.setTypeConnaissance(getValeurChamp(request,"typeconnaissance"));
		d.setDescriptionUsage(getValeurChamp(request,"descriptionUsage"));
		d.setPermiType(getValeurChamp(request,"type"));
		d.setPermisBut(getValeurChamp(request,"but"));
		d.setDebut(getValeurChamp(request,"du"));
		d.setFin(getValeurChamp(request,"jusquau"));
		
		
		 
		
		
		return d;
	}
		
	
	
	
	public int getIdDemandeClass() {
		return idDemandeClass;
	}




	public void setIdDemandeClass(int idDemandeClass) {
		this.idDemandeClass = idDemandeClass;
	}




	private static String getValeurChamp( HttpServletRequest request,String nomChamp ) {
		String valeur = request.getParameter( nomChamp );
		if ( valeur == null || valeur.trim().length() == 0 ) {	
		return null;
		} else {
			return valeur.trim();
		}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getURLidentité() {
		return URLidentité;
	}
	public void setURLidentité(String uRLidentité) {
		URLidentité = uRLidentité;
	}
	public String getTitreProjet() {
		return titreProjet;
	}
	public void setTitreProjet(String titreProjet) {
		this.titreProjet = titreProjet;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public String getSiegeEntreprise() {
		return siegeEntreprise;
	}
	public void setSiegeEntreprise(String siegeEntreprise) {
		this.siegeEntreprise = siegeEntreprise;
	}
	public String getNumeroEntreprise() {
		return numeroEntreprise;
	}
	public void setNumeroEntreprise(String numeroEntreprise) {
		this.numeroEntreprise = numeroEntreprise;
	}
	public String getSiteEntreprise() {
		return siteEntreprise;
	}
	public void setSiteEntreprise(String siteEntreprise) {
		this.siteEntreprise = siteEntreprise;
	}
	public String getNomFournisseur() {
		return nomFournisseur;
	}
	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}
	public String getURLautorisation() {
		return URLautorisation;
	}
	public void setURLautorisation(String uRLautorisation) {
		URLautorisation = uRLautorisation;
	}
	public String getNomRessource() {
		return nomRessource;
	}
	public void setNomRessource(String nomRessource) {
		this.nomRessource = nomRessource;
	}
	public String getTaxonRessource() {
		return taxonRessource;
	}
	public void setTaxonRessource(String taxonRessource) {
		this.taxonRessource = taxonRessource;
	}
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	public String getIdCommunaute() {
		return idCommunaute;
	}
	public void setIdCommunaute(String idCommunaute) {
		this.idCommunaute = idCommunaute;
	}
	public String getTypeConnaissance() {
		return typeConnaissance;
	}
	public void setTypeConnaissance(String typeConnaissance) {
		this.typeConnaissance = typeConnaissance;
	}
	public String getDescriptionUsage() {
		return DescriptionUsage;
	}
	public void setDescriptionUsage(String descriptionUsage) {
		DescriptionUsage = descriptionUsage;
	}
	
 

	public String getDebut() {
		return debut;
	}

	public void setDebut(String debut) {
		this.debut = debut;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getConnaissanceUtilisation() {
		return connaissanceUtilisation;
	}

	public void setConnaissanceUtilisation(String connaissanceUtilisation) {
		this.connaissanceUtilisation = connaissanceUtilisation;
	}

	public String getPermisBut() {
		return PermisBut;
	}

	public void setPermisBut(String permisBut) {
		PermisBut = permisBut;
	}

	public String getPermiType() {
		return PermiType;
	}

	public void setPermiType(String permiType) {
		PermiType = permiType;
	}




	public String getURIdemandemanuscrite() {
		return URIdemandemanuscrite;
	}




	public void setURIdemandemanuscrite(String iRIdemandemanuscrite) {
		URIdemandemanuscrite = iRIdemandemanuscrite;
	}




	public String getURIdescriptionprojet() {
		return URIdescriptionprojet;
	}




	public void setURIdescriptionprojet(String uRIdescriptionprojet) {
		URIdescriptionprojet = uRIdescriptionprojet;
	}
	
	
	
	
	
	
}
