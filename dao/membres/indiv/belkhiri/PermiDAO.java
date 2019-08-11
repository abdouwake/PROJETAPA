package membres.indiv.belkhiri;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public interface PermiDAO {

	
	void creer(Permis p);
	Permis trouver (int idpermi);
	ArrayList<Permis> afficher_permis(boolean revoquer);
	ArrayList<Permis>  afficher_tout();
	void Revoquer (int idpermi);
	void Reactiver (int idpermi);
	ArrayList<Permis> Chercher(HttpServletRequest request);
	ArrayList<Permis> trouver_by_date(String from,String to);
	ArrayList<Permis> trouver_by_user(int iduser);
}
