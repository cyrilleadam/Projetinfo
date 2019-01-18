import java.util.Comparator;

public class Joueurs {
	//création var plateau
	Plateau plateau;
	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	String prenom;

	// Constructeur:
	Joueurs(String prenom) {
		this.prenom = prenom;
		this.plateau = new Plateau(9,9);// taille du plateau
	}

}
