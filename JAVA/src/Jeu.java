import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Jeu {
	Scanner scan = new Scanner(System.in);
	
	Pioche pioche = new Pioche();

	ArrayList<Joueurs> joueurs = new ArrayList<>();

	public  void jouer() {
		
		//différents joueurs

		//boucle du jeu
		List<Domino> plateau;
		enregistrerJoueurs();
		while(true) {
			reinitialiserTour();
			plateau = pioche.distribuer();
			Collections.sort(plateau, Domino.ordreComparateur);
			for(int i=0; i<plateau.size(); i++) {
				System.out.println("[" + i + "] " + plateau.get(i).toString()); 
			}

			triJoueursOrdreActuel();
			for(int i=0; i<joueurs.size(); i++) {
				System.out.println( joueurs.get(i).prenom + " à toi de piocher");
				int j = 0;
				do {
					j = scan.nextInt();
					if(j<0 || j>2 || verifDomino(j) == false ) {
						System.out.println("choisir un domino existant ou qui n'est pas prit"); 
					}

				} while(j<0 || j>2 || verifDomino(j) == false);
				joueurs.get(i).ordreFutur = j;
			}
		}
		/*Faire une boucle, tant que la partie n'est pas finit 
			Distribuer les cartes
		 	Chaque joueur choisit une carte dans l'ordre 
		 	Poser la carte dans le royaume
		 	...
		 	compte les points
		 	Détermine le gagnat
		 	Fin du programme*/
	}
	public void reinitialiserTour() {
		for(int i=0; i<joueurs.size(); i++) {
			joueurs.get(i).ordreActuel = joueurs.get(i).ordreFutur;
			joueurs.get(i).ordreFutur = -1;

		}		
	}
	
	public boolean verifDomino(int domino) {
		for(int i=0; i<joueurs.size(); i++) {
			if(joueurs.get(i).ordreFutur == domino) {
				return false;
			}
		}
		return true;
	}
	
	public void NombreJoueurs() {
		
	}
	
	//renseigner les noms des différents joueurs
	public void enregistrerJoueurs() {
		ArrayList<Joueurs> nouveauJoueurs = new ArrayList<>();
		for(int i=0; i<3; i++) {
			System.out.println("Renseigner votre pseudo : ");
			String pseudo = scan.nextLine();
			nouveauJoueurs.add(new Joueurs(i, pseudo));
		}
		Collections.shuffle(nouveauJoueurs);
		for(int i=0; i<nouveauJoueurs.size(); i++) {
			nouveauJoueurs.get(i).ordreActuel = i;
		}
		joueurs = nouveauJoueurs;
		triJoueursOrdreActuel();
		System.out.println(joueurs.get(0).prenom + " jouera en premier ");
		System.out.println(joueurs.get(1).prenom + " jouera en second ");
		System.out.println(joueurs.get(2).prenom + " jouera en troisième ");
		System.out.println(" ");

		
	}
	
	//rendre le tri des joueurs aléatoire
	public void triJoueursOrdreActuel() {
		Collections.sort(joueurs, Joueurs.ordreComparateur);
	}
}
