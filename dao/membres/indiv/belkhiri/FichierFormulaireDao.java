package membres.indiv.belkhiri;

import java.util.ArrayList;

public interface FichierFormulaireDao {

	
	//Le formulaire de demande en question
	
	 int ajouter(DemandePermi d);	 
	 ArrayList<DemandePermi> afficher(int id);
	 ArrayList<DemandePermi> afficher_tout();
	 ArrayList<DemandePermi> afficher_attente();
	 public DemandePermi trouver(int id);
     public void Dans_workflow(int iddemande);
     public  ArrayList<DemandePermi> Afficher_pour_délivrer();
     public void update_set_done(int iddemande);
     ArrayList<DemandePermi>  trouver_by_date(String from,String to);
     public void set_terminer(int iddemande);
     public void set_archiver(int iddemande);
}
