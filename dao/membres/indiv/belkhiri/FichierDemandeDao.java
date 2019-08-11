package membres.indiv.belkhiri;

import java.util.ArrayList;

import membres.commun.dao.DAOException;

public interface FichierDemandeDao {
	
	//Les fichiers associés à la demande
	void ajouter	(FichierDemande f) throws DAOException;
	ArrayList<FichierDemande> afficher	(int id) throws DAOException;
	ArrayList<FichierDemande> afficher_tout() throws DAOException;
	ArrayList<FichierDemande> trouver_by_date(String from,String to);
}
