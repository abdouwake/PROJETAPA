package membres.indiv.belkhiri;

import java.util.ArrayList;

import membres.commun.dao.DAOException;

public interface ModeleDao {

	
	void Creer(Modele m) throws DAOException;
	Modele trouver() throws DAOException;
	ArrayList<Modele> afficher_tout() throws DAOException;
}
