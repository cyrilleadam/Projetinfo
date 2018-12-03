//package jeu;

import java.util.*;

	public class Plateau {
		
		public static void main(String[] args) {
			Plateau p1 = new Plateau(8,5);
			p1.afficher();
			}

		private int nbrligne;
		private int nbrcolonne;
		private char [][] plateau;
	
		//Constructeur
		public Plateau(int n, int b) {
			nbrligne = n;
			nbrcolonne = b;
			plateau = new char [nbrligne][nbrcolonne];
			
			for(int i=0; i<nbrligne; i++) {
				for(int j=0; j<nbrcolonne; j++) {
					
					plateau[i][j] = 'x';
				}
			}
		}
		
		//Ascenseurs
		//Methodes
		public void afficher() {
			System.out.println();
			for(int i= 0; i<nbrligne; i++) {
				for(int j=0; j<nbrcolonne; j++) {
					System.out.print(" | " +plateau[i][j]);
				}
				System.out.println(" | ");
			}
			System.out.println();
		}	
	}
	