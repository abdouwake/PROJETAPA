package membres.indiv.belkhiri;

import java.util.ArrayList;
import java.util.Map;

import membres.commun.beans.Utilisateur;
import membres.commun.dao.DAOException;

public interface QuestionDao {
	
	ArrayList  afficher(boolean tout) throws DAOException;
	ArrayList  Afficher_question() throws DAOException;
	void ajouter	(Question q) throws DAOException;
	void Valider	(int id) throws DAOException;
	void supprimer(int id) throws DAOException;
	public void Update_avoirreponse(int id) throws DAOException;
  }
