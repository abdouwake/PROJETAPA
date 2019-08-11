package membres.indiv.belkhiri;

import java.util.ArrayList;

import membres.commun.dao.DAOException;

public interface EtapeDao {

	void creer(Etape e) throws DAOException;
	ArrayList<Etape> trouver (int idworkflow) throws DAOException;
	void Noter(int note, int idetape) throws DAOException;
	public void Unlock(int idetape) throws DAOException;
	public void supprimer (int idworkflow);
}
