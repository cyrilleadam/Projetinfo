
//package jeu;
import java.util.*;

public class Plateau {
	private int nbrligne;
	private int nbrcolonne;
	private String[][] plateau;
	public String[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(String[][] plateau) {
		this.plateau = plateau;
	}

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

	// Surcharger une fonction : avoir plusieurs fonction types diff�rents en entr�e
	public void placerTuile(String typeTerrain, int i, int j) {
		this.plateau[j][i] = typeTerrain;
		this.historiquePlateau[j][i] = typeTerrain;
	}

	// Surcharger une fonction : avoir plusieurs fonction types diff�rents en entr�e
	public void placerTuile(DemiDomino demiDomino, int i, int j) {
		this.plateau[j][i] = demiDomino.showDemiDomino();
		this.historiquePlateau[j][i] = demiDomino.typeTerrain + ";" + demiDomino.nbrCouronne; // ";" permet se s�parer
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

}
