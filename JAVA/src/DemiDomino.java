import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemiDomino {

	String typeTerrain;
	int nbrCouronne;

	// Constructeur
	public DemiDomino(String type, int couronne) {

		typeTerrain = type;
		nbrCouronne = couronne;
	}

	// Reprise de la premiere lettre terrain + nbCouronne
	public String showDemiDomino() {
		return typeTerrain.split("")[0] + nbrCouronne;
	}

	// verifier qu'on peut poser la pièce
	public boolean[] regarderAutour(Plateau plateau, int x, int y) {
		int[][] listAutour = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };// création position de vérif
		boolean[] listeResultats = {false, false};
		if (x < 0 || x > 8 || y < 0 || y > 8 || !plateau.historiquePlateau[y][x].equals("-")) {
			System.out.println(typeTerrain + " false " + x + " " + y);
			return listeResultats;
		}
		listeResultats[0] = true;//Droit de placer la liste domi a cet endroit
		for (int i = 0; i < listAutour.length; i++) {
			try {
				String val = plateau.historiquePlateau[y + listAutour[i][1]][x + listAutour[i][0]]; // verification

				String type = val.split(";")[0];

				if (type.equals(typeTerrain) || type.equals("C")) {//regarder si le typeTerrain est le meme type que le domi ou "C"
					System.out.println(typeTerrain + " true");
					listeResultats[1] = true;
				}
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {// etre sur de ne pas etre en dehors du terrain

			}

		}
		return listeResultats;
	}
}