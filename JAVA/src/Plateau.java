
//package jeu;
import java.util.*;

public class Plateau {
	private int nbrligne;
	private int nbrcolonne;
	private String[][] plateau;
	public String[][] historiquePlateau;

	// Constructeur
	public Plateau(int n, int b) {
		nbrligne = n;
		nbrcolonne = b;
		plateau = new String[nbrligne][nbrcolonne];

		for (int i = 0; i < nbrligne; i++) {
			for (int j = 0; j < nbrcolonne; j++) {

				plateau[i][j] = "-";
			}
		}
		historiquePlateau = plateau.clone();
		placerTuile("C", 4, 4); // Placer le chateau
	}

	// Surcharger une fonction : avoir plusieurs fonction types différents en entrée
	public void placerTuile(String typeTerrain, int i, int j) {
		this.plateau[j][i] = typeTerrain;
		this.historiquePlateau[j][i] = typeTerrain;
	}

	// Surcharger une fonction : avoir plusieurs fonction types différents en entrée
	public void placerTuile(DemiDomino demiDomino, int i, int j) {
		this.plateau[j][i] = demiDomino.showDemiDomino();
		this.historiquePlateau[j][i] = demiDomino.typeTerrain + ";" + demiDomino.nbrCouronne; // ";" permet se séparer
																								// type et colonne
	}

	// Ascenseurs
	// Methodes
	public void afficher() {
		System.out.println();
		for (int i = 0; i < nbrligne; i++) {
			for (int j = 0; j < nbrcolonne; j++) {
				System.out.print(" | " + plateau[i][j]);
			}
			System.out.println(" | ");
		}
		System.out.println();
	}

	public void placer(int l, int c, String t) {
		l = l - 1;
		c = c - 1;

		if (l < 0 || c < 0 || l > nbrligne || c > nbrcolonne) {
			System.out.println("Error !");
			return;
		}
		if (plateau[l][c] == "-") {
			plateau[l][c] = t;
		} else {
			System.out.println("zone déja prise !");
		}
	}
}