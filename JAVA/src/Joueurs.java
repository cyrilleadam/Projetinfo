import java.util.Comparator;

public class Joueurs {
	int ordreActuel;
	int ordreFutur;
	String prenom;
	
	//Constructeur:
	Joueurs(int ordre, String prenom) {
		this.ordreActuel = ordreActuel;
		this.ordreFutur = ordreActuel;
		this.prenom = prenom;
	}
	
	//Comparateur : 
	public static Comparator<Joueurs> ordreComparateur = new Comparator<Joueurs>() {
		public int compare(Joueurs j1, Joueurs j2) {
			return j1.ordreActuel - j2.ordreActuel;
			
		}
	};
	
}



