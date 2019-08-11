package membres.indiv.belkhiri;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Printer {
	public  static final String CHEMIN = "C:\\fichiers\\Demandes";

	
	
	public String ImprimerRapport_v1(HttpServletRequest request) throws InvalidPasswordException, IOException {
		
		PDDocument document = new PDDocument();
		String nomFichier = "rapport_v1.pdf";
		PDPage page = new PDPage();
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		 Date date = new Date();
		 
		PDImageXObject pdImage = PDImageXObject.createFromFile(this.getClass().getResource("modele.jpg").getPath(), document);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.drawImage(pdImage, 0, 0, 640, 795);
		
		//Un peut de traitement pour recupeer tt les permis
		
		ArrayList<Permis> al = new ArrayList<Permis>();
		Permis p = new Permis();
		al = p.afficher_tout();
		
		contentStream.beginText(); 
		contentStream.newLineAtOffset(270, 720);
	    contentStream.setFont(PDType1Font.HELVETICA, 18);
	    contentStream.showText("Tous les permis");
		contentStream.newLineAtOffset(20, -20);
	    contentStream.setFont(PDType1Font.HELVETICA, 14);
		contentStream.showText("Le "+dateFormat.format(date));
		contentStream.newLineAtOffset(-200, -100);

	    contentStream.showText("ID");
		contentStream.newLineAtOffset(50, 0);
	    contentStream.showText("Nom");
	    contentStream.newLineAtOffset(100, 0);
	    contentStream.showText("Prenom");
	    contentStream.newLineAtOffset(100, 0);
	    contentStream.showText("Du");
	    contentStream.newLineAtOffset(100, 0);
	    contentStream.showText("Au");
		contentStream.newLineAtOffset(100, 0);
	    contentStream.showText("Etat");
	    
	    contentStream.newLineAtOffset(-450, -25);
	    

		for (int i=0;i<al.size();i++) {
			
			int idpermi = al.get(i).getIdpermi();
			String id = String.valueOf(idpermi);
			contentStream.showText(id);
			contentStream.newLineAtOffset(50, 0);
		    contentStream.showText(al.get(i).getNomuser());
		    contentStream.newLineAtOffset(100, 0);
		    contentStream.showText(al.get(i).getPrenomuser());
		    contentStream.newLineAtOffset(100, 0);
		    contentStream.showText(al.get(i).getFrom());
		    contentStream.newLineAtOffset(100, 0);
		    contentStream.showText(al.get(i).getTo());
			contentStream.newLineAtOffset(100, 0);
			boolean isetat = al.get(i).isEtat();
			String etat=null;
			if (isetat) {
				etat="Actif";
			}else {
				etat="Révoqué";
			}
		    contentStream.showText(etat);
		    contentStream.newLineAtOffset(-450, -25);

		}
		contentStream.endText(); 

		
		document.addPage(page);
 		

	    contentStream.close();
		document.save(CHEMIN+nomFichier);
		String URI = CHEMIN+nomFichier;
		document.close();
		return URI;
	}
	
	public String ImprimerRapport_v2(HttpServletRequest request) throws IOException {
		
		
		PDDocument document = new PDDocument();
		String nomFichier = "rapport_v1.pdf";
		PDPage page = new PDPage();
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		 Date date = new Date();
		 
		PDImageXObject pdImage = PDImageXObject.createFromFile(this.getClass().getResource("modele.jpg").getPath(), document);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.drawImage(pdImage, 0, 0, 640, 795);
		
		//Un peut de traitement pour recupeer tt les permis
		
		ArrayList<Permis> al = new ArrayList<Permis>();
		Permis p = new Permis();
		al = p.afficher_tout(false);
		
		contentStream.beginText(); 
		contentStream.newLineAtOffset(270, 720);
	    contentStream.setFont(PDType1Font.HELVETICA, 18);
	    contentStream.showText("Tous les permis");
		contentStream.newLineAtOffset(20, -20);
	    contentStream.setFont(PDType1Font.HELVETICA, 14);
		contentStream.showText("Le "+dateFormat.format(date));
		contentStream.newLineAtOffset(-200, -100);

	    contentStream.showText("ID");
		contentStream.newLineAtOffset(50, 0);
	    contentStream.showText("Nom");
	    contentStream.newLineAtOffset(100, 0);
	    contentStream.showText("Prenom");
	    contentStream.newLineAtOffset(100, 0);
	    contentStream.showText("Du");
	    contentStream.newLineAtOffset(100, 0);
	    contentStream.showText("Au");
		contentStream.newLineAtOffset(100, 0);
	    contentStream.showText("Etat");
	    
	    contentStream.newLineAtOffset(-450, -25);
	    
	    if (al.isEmpty()==false) {
		for (int i=0;i<al.size();i++) {
			
			int idpermi = al.get(i).getIdpermi();
			String id = String.valueOf(idpermi);
			contentStream.showText(id);
			contentStream.newLineAtOffset(50, 0);
		    contentStream.showText(al.get(i).getNomuser());
		    contentStream.newLineAtOffset(100, 0);
		    contentStream.showText(al.get(i).getPrenomuser());
		    contentStream.newLineAtOffset(100, 0);
		    contentStream.showText(al.get(i).getFrom());
		    contentStream.newLineAtOffset(100, 0);
		    contentStream.showText(al.get(i).getTo());
			contentStream.newLineAtOffset(100, 0);
			boolean isetat = al.get(i).isEtat();
			String etat=null;
			if (isetat) {
				etat="Actif";
			}else {
				etat="Révoqué";
			}
		    contentStream.showText(etat);
		    contentStream.newLineAtOffset(-450, -25);

		}
	    }
		contentStream.endText(); 

		
		document.addPage(page);
 		

	    contentStream.close();
		document.save(CHEMIN+nomFichier);
		String URI = CHEMIN+nomFichier;
		document.close();
		return URI;
		
		 
	}
	
	public String ImprimerRapport_v3(HttpServletRequest request) throws IOException {

		
		PDDocument document = new PDDocument();
		String nomFichier = "rapport_v1.pdf";
		PDPage page = new PDPage();
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		 Date date = new Date();
		 
		PDImageXObject pdImage = PDImageXObject.createFromFile(this.getClass().getResource("modele.jpg").getPath(), document);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.drawImage(pdImage, 0, 0, 640, 795);
		
		//Un peut de traitement pour recupeer tt les permis
		
		ArrayList<Permis> al = new ArrayList<Permis>();
		Permis p = new Permis();
		al = p.afficher_tout(true);
		
		contentStream.beginText(); 
		contentStream.newLineAtOffset(270, 720);
	    contentStream.setFont(PDType1Font.HELVETICA, 18);
	    contentStream.showText("Tous les permis");
		contentStream.newLineAtOffset(20, -20);
	    contentStream.setFont(PDType1Font.HELVETICA, 14);
		contentStream.showText("Le "+dateFormat.format(date));
		contentStream.newLineAtOffset(-200, -100);

	    contentStream.showText("ID");
		contentStream.newLineAtOffset(50, 0);
	    contentStream.showText("Nom");
	    contentStream.newLineAtOffset(100, 0);
	    contentStream.showText("Prenom");
	    contentStream.newLineAtOffset(100, 0);
	    contentStream.showText("Du");
	    contentStream.newLineAtOffset(100, 0);
	    contentStream.showText("Au");
		contentStream.newLineAtOffset(100, 0);
	    contentStream.showText("Etat");
	    
	    contentStream.newLineAtOffset(-450, -25);
	    
	    if(al.isEmpty()==false) {
		for (int i=0;i<al.size();i++) {
			
			int idpermi = al.get(i).getIdpermi();
			String id = String.valueOf(idpermi);
			contentStream.showText(id);
			contentStream.newLineAtOffset(50, 0);
		    contentStream.showText(al.get(i).getNomuser());
		    contentStream.newLineAtOffset(100, 0);
		    contentStream.showText(al.get(i).getPrenomuser());
		    contentStream.newLineAtOffset(100, 0);
		    contentStream.showText(al.get(i).getFrom());
		    contentStream.newLineAtOffset(100, 0);
		    contentStream.showText(al.get(i).getTo());
			contentStream.newLineAtOffset(100, 0);
			boolean isetat = al.get(i).isEtat();
			String etat=null;
			if (isetat) {
				etat="Actif";
			}else {
				etat="Révoqué";
			}
		    contentStream.showText(etat);
		    contentStream.newLineAtOffset(-450, -25);

		}
	}
		contentStream.endText(); 

		
		document.addPage(page);
 		

	    contentStream.close();
		document.save(CHEMIN+nomFichier);
		String URI = CHEMIN+nomFichier;
		document.close();
		return URI;
	}
	
	
	public String DelivrerPermis (Permis p, HttpServletRequest request) throws IOException {
		 
		
		PDDocument document = new PDDocument();
		PDPage my_page = new PDPage();
		String nomFichier = p.getIddemande()+p.getIduser()+".pdf";
		String URI= new String();
		String nom = request.getParameter("nom");
		String type = request.getParameter("type");
		String ressources = request.getParameter("ressources");
		String connaissances = request.getParameter("connaissances");
		String endroits = request.getParameter("endroits");
		
		
			
		PDImageXObject pdImage = PDImageXObject.createFromFile(this.getClass().getResource("entête.jpg").getPath(), document);
		PDImageXObject tampon = PDImageXObject.createFromFile(this.getClass().getResource("tampon.jpg").getPath(), document);
		PDPageContentStream contentStream = new PDPageContentStream(document, my_page);
		//contentStream.drawImage(pdImage, 20, 20);
		contentStream.drawImage(pdImage, 0, 735, 75, 60);
		contentStream.drawImage(tampon, 430, 330, 170, 100);
	 
		contentStream.beginText(); 
		
		contentStream.newLineAtOffset(190, 700);
	    contentStream.setFont(PDType1Font.HELVETICA, 24);
	    contentStream.showText("Permis APA AlGERIE");
	    
	    
	    contentStream.setFont(PDType1Font.COURIER, 12);
	    
	    contentStream.newLineAtOffset(170, -20);
		contentStream.showText("Permi N° : "+p.getIddemande());
		
		contentStream.newLineAtOffset(-300, -70);
 		contentStream.showText("SI APA Algerie Atteste que ");
	    contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
 		contentStream.showText(nom);
	    contentStream.setFont(PDType1Font.COURIER, 12);
 		contentStream.showText(" a vérifié(e) toutes les ");
		contentStream.newLineAtOffset(0, -15);
 		contentStream.showText("contraintes judisciaires.");

		contentStream.newLineAtOffset(0, -20);
 		contentStream.showText("Ce présent permi est une piéce justificative nécessaire et  ");
 		contentStream.newLineAtOffset(0, -17);
 		contentStream.showText("suffisante pour l'exloitation des ressources suivantes : "); 
		contentStream.newLineAtOffset(0, -17);
	    contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
 		contentStream.showText(ressources);
 		contentStream.newLineAtOffset(0, -20);
	    contentStream.setFont(PDType1Font.COURIER, 12);
 		contentStream.showText("Ainsi que les connaissances traditionnelles suivantes : ");
	    contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
 		contentStream.newLineAtOffset(0, -20);
 		contentStream.showText(connaissances);
	    contentStream.setFont(PDType1Font.COURIER, 12);
 		contentStream.newLineAtOffset(0, -20);
 		contentStream.showText("Ce permi est valable du ");
 		
	    contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
	    contentStream.showText(p.getTo());
	    contentStream.setFont(PDType1Font.COURIER, 12);
	    contentStream.showText(" au ");
	    contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
	    contentStream.showText(p.getFrom());
	    contentStream.setFont(PDType1Font.COURIER, 12);
	    contentStream.showText(" à minuit");
 		contentStream.newLineAtOffset(0, -20);
 		contentStream.showText("Les endroits qui sont concernés autorisés avec ce permis sont : ");
 		contentStream.newLineAtOffset(0, -20);
	    contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
 		contentStream.showText(endroits);
	    contentStream.setFont(PDType1Font.COURIER, 12);

	     
		
		
 		  document.addPage(my_page);
	      PDDocumentInformation pdd = document.getDocumentInformation();
	      pdd.setAuthor("APA ALGERIE");
	      pdd.setTitle(nomFichier+".pdf");
	      pdd.setSubject("Un permis d'un client donné");
	      
	      
	      contentStream.endText();
	      contentStream.close();
		  document.save(CHEMIN+nomFichier);
		  document.close();
		
		URI = CHEMIN+nomFichier;
		
		return URI;
		
		
	}
	
	public String DemandePermis (Demande d) throws IOException {
		
		
		PDDocument document = new PDDocument();
		PDPage my_page = new PDPage();
		String nomFichier = d.getNom()+ d.getNomEntreprise()+d.getNumero()+".pdf";
		String URI= new String();
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		 Date date = new Date();
			
		PDImageXObject pdImage = PDImageXObject.createFromFile(this.getClass().getResource("entête.jpg").getPath(), document);
		PDPageContentStream contentStream = new PDPageContentStream(document, my_page);
		//contentStream.drawImage(pdImage, 20, 20);
		contentStream.drawImage(pdImage, 0, 735, 75, 60);
		
		contentStream.beginText(); 
		
		contentStream.newLineAtOffset(140, 700);
	    contentStream.setFont(PDType1Font.HELVETICA, 22);
	    contentStream.showText("Formulaire de demande de permis");  
	    
	    contentStream.setFont(PDType1Font.HELVETICA, 14);
	    contentStream.newLineAtOffset(100, -24);
		contentStream.showText("Le : "+dateFormat.format(date));

		contentStream.newLineAtOffset(-150, -65);
		contentStream.showText("Nom :          "+d.getNom());
		
		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("Prenom :     "+d.getPrenom());

		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("email :         "+d.getEmail());
		
		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("Numero :     "+d.getNumero());
		
		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("Adresse :     "+d.getAdresse());
		   
		
		contentStream.newLineAtOffset(0, -35);
		contentStream.showText("Titre du projet : "+d.getTitreProjet());
		
		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("Localisation :    "+d.getLieu());
		
		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("Longitude :       "+d.getLongitude());
		
		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("Latitude :          "+d.getLatitude());
		
		contentStream.newLineAtOffset(0, -35);
		contentStream.showText("Nom de l'entreprise : "+d.getNomEntreprise());

		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("Siége : "+d.getSiegeEntreprise());
		
		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("Numero : "+d.getNumeroEntreprise());
		
		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("Site Web : "+d.getSiteEntreprise());
		
		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("Fournisseur d'accès : "+d.getNomFournisseur());
		
		contentStream.newLineAtOffset(0, -35);
		contentStream.showText("Nom de la ressource utilisée : "+d.getNomRessource());
		
		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("Taxon : "+d.getTaxonRessource());
		
		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("Quantité : "+d.getQuantite());
		
		 
		contentStream.newLineAtOffset(0, -35);
		contentStream.showText("Connaissance traditionelle associée : "+d.getConnaissanceUtilisation());
		
		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("Type de la connaissance : "+d.getTypeConnaissance());
		
		contentStream.newLineAtOffset(0, -25);
		contentStream.showText("Usage : "+d.getDescriptionUsage());
		
		contentStream.endText();

		contentStream.close();

		  
		 
		    PDPage my_page2 = new PDPage();
		    
			contentStream = new PDPageContentStream(document, my_page2);

	    	contentStream.beginText(); 
			
			contentStream.newLineAtOffset(100, 700);
		    contentStream.setFont(PDType1Font.HELVETICA, 14);
		    contentStream.showText("Permis pour l'utilisation des : "+d.getPermiType());  
		 
		    contentStream.newLineAtOffset(0, -25);
			contentStream.showText("Permis à but :  "+d.getPermisBut());
			
			 contentStream.newLineAtOffset(0, -25);
			 contentStream.showText("Le projet va durer du "+d.getDebut()+" au "+d.getFin());
				
			
		     contentStream.endText();

			 contentStream.close();
			
			  document.addPage(my_page);
			  document.addPage(my_page2);
	      PDDocumentInformation pdd = document.getDocumentInformation();
	      pdd.setAuthor("APA ALGERIE");
	      pdd.setTitle(nomFichier+".pdf");
	      pdd.setSubject("Une demande de permis d'un client donné");
	      
		  document.save(CHEMIN+nomFichier);
		  document.close();
		
		URI = CHEMIN+nomFichier;
	    return URI;
}
	
	
	
	
	
	
	
	 
		
}










