import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Jeu {

	ListDomino listeDomino = new ListDomino();

	int nbJoueurs = nombreJoueurs();
//Initialisation des arraylist
	ArrayList<Joueurs> ordreActuelJoueur, ordreFuturJoueur;

	ArrayList<Joueurs> joueurs = new ArrayList<>();

	ArrayList<Integer> dominoUtiliser;

	public void jouer() {
		// boucle du jeu

		// Nombre de rois par joueurs
		List<Domino> listeDeDomino;

		int nbRois;
		if (nbJoueurs == 2) {
			nbRois = 4;
		} else if (nbJoueurs == 3) {
			nbRois = 3;
		} else {
			nbRois = 4;
		}

		// Joueurs rentrés enregistrer dans le jeu
		enregistrerJoueurs(nbJoueurs, joueurs);

		listeDomino.dominosRestants(nbJoueurs);
		while (true) {
			reinitialiserTour();

			listeDeDomino = listeDomino.distribuer(nbRois);
			Collections.sort(listeDeDomino, Domino.ordreComparateur);
			for (int i = 0; i < listeDeDomino.size(); i++) {
				System.out.println("[" + i + "] " + listeDeDomino.get(i).toString());
			}

			// demande et vérification de saisie et affichage domino
			for (int i = 0; i < ordreActuelJoueur.size(); i++) {
				System.out.println(ordreActuelJoueur.get(i).prenom + " à toi de piocher");
				int numeroChoisit = 0;
				boolean dominoMis = false;
				
				do {
					try {
						Scanner scan = new Scanner(System.in);
						numeroChoisit = scan.nextInt();
						if (numeroChoisit < 0 || numeroChoisit > 3 || dominoUtiliser.contains(numeroChoisit))
							throw new Exception("veuillez entrer un nombre entre 0 et 3");
					} catch (Exception e) {
						System.out.println("choisir un domino existant ou qui n'est pas prit");
						numeroChoisit = -1;
					}

				} while (numeroChoisit < 0 || numeroChoisit > 3 || dominoUtiliser.contains(numeroChoisit));
				do {
				ordreFuturJoueur.set(numeroChoisit, ordreActuelJoueur.get(i));
				System.out.println(listeDeDomino.get(numeroChoisit).toString());
				dominoMis = mettreDomino(listeDeDomino, numeroChoisit, i);
				if(!dominoMis) {
					System.out.println("met une position valide batard");
				}
				}while(!dominoMis);
			}
		}
	}

	// Afficher le plateau et stoque dans l'historique
	public boolean mettreDomino(List<Domino> listeDeDomino, int numeroChoisit, int i) {
		List<Integer> listePosition = placerDomino();
		Plateau plateau = ordreActuelJoueur.get(i).plateau;
		boolean[] dominoAjouter1 = listeDeDomino.get(numeroChoisit).cote1.regarderAutour(plateau, listePosition.get(0),
				listePosition.get(1));// recup les 2 listes
		boolean[] dominoAjouter2 = listeDeDomino.get(numeroChoisit).cote2.regarderAutour(plateau, listePosition.get(2),
				listePosition.get(3));// recup les 2 listes
		if (dominoAjouter1[0] && dominoAjouter2[0] && (dominoAjouter1[1] || dominoAjouter2[1])) {	// case 1 et s=case 2 domino + case adjacente
			plateau.placerTuile(listeDeDomino.get(numeroChoisit).cote1, listePosition.get(0), listePosition.get(1));
			plateau.placerTuile(listeDeDomino.get(numeroChoisit).cote2, listePosition.get(2), listePosition.get(3));
			plateau.afficher();
			return true;
		}
		return false;
	}

	// Demander de saisir les coordonnées des dominos
	public List placerDomino() {
		Scanner scan = new Scanner(System.in);
		int coordonnee1 = -1;
		int coordonnee2 = -1;
		int placementO = -1;
		int coordonnee2x = -1;
		int coordonnee2y = -1;

		// Haut Bas Gauche Droite
		while ((placementO == -1)) {
			try {
				System.out.println("Saisissez 0 pour Haut 1 pour Bas 2 pour Gauche 3 pour Droite : ");
				placementO = scan.nextInt();
				if (placementO > 3 || placementO < 0) {
					throw new Exception("Ce nombre est invalide");
				}
			} catch (Exception e) {
				placementO = -1;
			}
		}
		// Coordonnées X et Y
		while ((coordonnee1 == -1)) {
			try {
				System.out.println("Saisissez les coordonées x : ");
				coordonnee1 = scan.nextInt();
				if (coordonnee1 > 9 || coordonnee1 < 0) {
					throw new Exception("Ce nombre est invalide");
				}
			} catch (Exception e) {
				coordonnee1 = -1;
			}
		}
		while ((coordonnee2 == -1)) {
			try {
				System.out.println("Saisissez les coordonées y : ");
				coordonnee2 = scan.nextInt();
				if (coordonnee2 > 9 || coordonnee2 < 0) {
					throw new Exception("Ce nombre est invalide");
				}
			} catch (Exception e) {
				coordonnee2 = -1;
			}
		}
		// coordonnées du DemiDomino 2
		coordonnee2y = coordonnee2;
		coordonnee2x = coordonnee1;
		if (placementO == 0) { // HAUT
			coordonnee2y = coordonnee2 - 1;
		} else if (placementO == 1) { // BAS
			coordonnee2y = coordonnee2 + 1;
		} else if (placementO == 2) { // Gauche
			coordonnee2x = coordonnee1 - 1;
		} else { // Droite
			coordonnee2x = coordonnee1 + 1;
		}
		// récupération des données
		List<Integer> list = new ArrayList<>();
		list.add(coordonnee1);
		list.add(coordonnee2);
		list.add(coordonnee2x);
		list.add(coordonnee2y);

		System.out.println(list);
		return list;
	}

	// Placer les joueurs dans le bon ordre par tours
	public void reinitialiserTour() {
		ordreActuelJoueur = (ArrayList<Joueurs>) ordreFuturJoueur.clone();
		dominoUtiliser = new ArrayList();
	}

	// choix du nombre de joueurs dans la partie, 1 à 4
	public int nombreJoueurs() {
		Scanner scan = new Scanner(System.in);
		int nombreDeJoueurs = 0;
		while (!((nombreDeJoueurs >= 2) && (nombreDeJoueurs <= 4))) {
			try {
				System.out.println("Saisissez un nombre de joueurs : ");
				nombreDeJoueurs = scan.nextInt();
			} catch (Exception e) {
				scan.nextLine();
			}
		}
		return nombreDeJoueurs;
	}

	// renseigner les noms des différents joueurs
	public void enregistrerJoueurs(int nombreDeJoueurs, ArrayList<Joueurs> nouveauJoueurs) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < nombreDeJoueurs; i++) {
			System.out.println("Renseigner votre pseudo : ");
			String pseudo = scan.nextLine();
			nouveauJoueurs.add(new Joueurs(pseudo));
		}
		if (nombreDeJoueurs == 2) {
			int listSize = nouveauJoueurs.size();
			for (int i = 0; i < listSize; i++) {
				nouveauJoueurs.add(nouveauJoueurs.get(i));
			}
		}

		// trie de l'ordre des tours en fonction des numéros de dominos
		Collections.shuffle(nouveauJoueurs);
		ordreActuelJoueur = (ArrayList) nouveauJoueurs.clone();
		ordreFuturJoueur = (ArrayList) nouveauJoueurs.clone();

		// Récapitulatif des noms et de l'ordre de jeu des joueurs
		joueurs = nouveauJoueurs;
		List<String> positions = Arrays.asList("Premier", "Second", "Troisième", "Quatrième");
		for (int i = 0; i < ordreActuelJoueur.size(); i++) {
			System.out.println(ordreActuelJoueur.get(i).prenom + " jouera en " + positions.get(i));
		}
		System.out.println();

	}
}
