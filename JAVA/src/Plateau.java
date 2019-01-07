//package jeu;

import java.util.*;

	public class Plateau {
		
		public static void main(String[] args) {
			//Création du plateau
			//Plateau total
			Plateau p1 = new Plateau(5,5);
			Plateau p2 = new Plateau(5,10);
			
			//Placement des chateaux
			p1.placer(3,3,'C');
			
			//Placement de la pioche actuelle
			p2.placer(3,2,'D');
			p2.placer(3,3,'D');
			p2.placer(3,5,'D');
			p2.placer(3,6,'D');
			p2.placer(3,8,'D');
			p2.placer(3,9,'D');
			
			//Afficher le plateau
			p1.afficher();
			p2.afficher();
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
					
					plateau[i][j] = '-';
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
		
		public void placer(int l, int c, char t) {
			l=l-1;
			c=c-1;
			
			if(l<0 || c<0 || l>nbrligne || c>nbrcolonne) {
				System.out.println("Error !");
				return;
			}
			if(plateau[l][c] == '-') {
				plateau[l][c] = t;	
			}
			else {
				System.out.println("zone déja prise !");
			}
		}
	}
	