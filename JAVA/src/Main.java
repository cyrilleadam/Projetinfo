import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import edu.princeton.cs.introcs.StdDraw;


public class Main {
	
	
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		jeu.jouer();
		
		// Cr�ation du plateau
				// Plateau total
				Plateau p1 = new Plateau(9, 9);
				// Placement des chateaux
				p1.placer(5, 5, "C");
				// Afficher le plateau
				p1.afficher();
	}
}
