package membres.indiv.belkhiri;

import java.util.ArrayList;

import membres.commun.dao.DAOException;

public interface WorkflowDao {

	
	int Creer(Workflow w) throws DAOException;
	Workflow trouver(int idworkflow) throws DAOException;
	Workflow trouver_by_iddemande (int iddemande) throws DAOException;
	Workflow trouver_by_iduser (int iduser) throws DAOException;
	void MAJnote (int note,int idworkflow);
	ArrayList<Workflow> Afficher_Liste_Workflows();
	public void set_terminer(int idworkflow);
	public boolean est_fini(int idworkflow);
	public void supprimer(int idworkflow);
	
	
}
