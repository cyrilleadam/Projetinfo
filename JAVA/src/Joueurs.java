import java.util.Comparator;

public class Joueurs {
	//cr�ation var plateau
	Plateau plateau;
	String prenom;

	// Constructeur:
	Joueurs(String prenom) {
		this.prenom = prenom;
		this.plateau = new Plateau(9,9);
	}

}
