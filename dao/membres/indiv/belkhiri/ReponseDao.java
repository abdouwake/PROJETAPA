package membres.indiv.belkhiri;

import java.util.ArrayList;

import membres.commun.dao.DAOException;

public interface ReponseDao {
	
	
	public void AjouterReponse(Reponse r) throws DAOException;
	public void Supprimer(int id);
	public void Valider (int id);
	ArrayList  Afficher_reponse() throws DAOException;
	public int trouver_id_question(int id);

}
