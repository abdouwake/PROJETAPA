package membres.indiv.belkhiri;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import membres.commun.dao.DAOConfigurationException;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OcrWork {
	
	private static final String FICHIER_PROPERTIES = "\\membres\\indiv\\belkhiri\\OCR.properties";
	
	public String OCR_WORK(String path) {
    	 
        File file = new File(path);
    	ITesseract instance = new Tesseract();
    	Properties properties = new Properties();
    	String url = new String();
    	
    	//----------------IMPORTATIN DU FICHIER PROPERTIES
    	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    	InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );
    	if ( fichierProperties == null ) {
    		throw new DAOConfigurationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
    		}
    	
    	try {
    		properties.load( fichierProperties );
    		url= properties.getProperty( "URL" );
    	} catch ( IOException e ) {
    		throw new DAOConfigurationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e );
    	}
    	
    	//----------------IMPORTATIN DU FICHIER PROPERTIES

      	instance.setDatapath(url);
    	try {
    		String result = instance.doOCR(file);
    		result = result.replace("\r\n", " ").replace("\n", " ");
    		 
    		return result;
    	}catch (TesseractException e) {
    			System.err.println(e.getMessage());
    	}
    	return null;
    }
}
