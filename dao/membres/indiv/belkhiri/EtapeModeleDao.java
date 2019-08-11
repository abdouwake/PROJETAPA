package membres.indiv.belkhiri;

import java.util.ArrayList;

public interface EtapeModeleDao {

	
	ArrayList<ModeleEtape> trouver(int idmodele);
	void ajouter(ArrayList<ModeleEtape> al, int idmodele);
}
