package membres.indiv.belkhiri;

import java.util.ArrayList;
import java.util.Date;

import membres.commun.dao.DAOException;

public interface FileUploadDao {
	
	void ajouter	(FichierLoi f) throws DAOException;
	void Archiver (int id) throws DAOException;
	ArrayList<FichierLoi>  afficher	(boolean tout) throws DAOException;
	ArrayList<FichierLoi> afficher_by_date (boolean archiver,String du, String au);
 }

 