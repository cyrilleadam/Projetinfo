import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ListDomino {
	List<Domino> listeDomino;
	String dataDomi[] = new String[5];
	
	//Reprise des dominos dans le csv
	public static final String FILE_PATH_DOMINO = "./DominoList/dominos.csv";
	Map<Integer, Domino> dictDomino = new HashMap<Integer, Domino>();

	public void ReadFile(String filename) {
		Path path = Paths.get(filename);

		try (BufferedReader br = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {

			br.readLine();
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				dataDomi = line.split(",");
				//Association aux valeurs dominos
				Domino domi = new Domino(false, Integer.parseInt(dataDomi[4]), dataDomi[1],
						Integer.parseInt(dataDomi[0]), dataDomi[3], Integer.parseInt(dataDomi[2]));

				listeDomino.add(domi);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private int index = 0;

	// Melange aleatoire de la pioche
	public ListDomino() {
		listeDomino = new ArrayList<Domino>();
		ReadFile(FILE_PATH_DOMINO);
		Collections.shuffle(listeDomino);
		// afficher();
	}

	// Afficher la pile de 48 dominos
	public void afficher() {
		for (int i = 0; i < listeDomino.size(); i++) {
			System.out.println(listeDomino.get(i).numero + "TEST");
		}
	}

	// Choix de la pioche 24, 36, 48 par rapport au nombre de joueurs
	public void dominosRestants(int nombreDeJoueurs) {
		if (nombreDeJoueurs == 2) {
			for (int i = 0; i < 24; i++) {
				int hasardDomino = (int) (Math.random() * (listeDomino.size() - 1)); // Prise de position aléatoire dans
																						// les 48 Dominos
				Domino domino = listeDomino.get(hasardDomino); // créer un domino aléatoire
				listeDomino.remove(domino); // retire les dominos

			}
			System.out.println(listeDomino.size());

		} else if (nombreDeJoueurs == 3) {
			for (int i = 0; i < 12; i++) {
				int hasardDomino = (int) (Math.random() * (listeDomino.size() - 1)); // Prise de position aléatoire dans
																						// les 48 Dominos
				Domino domino = listeDomino.get(hasardDomino); // créer un domino aléatoire
				listeDomino.remove(domino); // retire les dominos
			}

		}System.out.println(listeDomino.size());
		
	}

	// Recupere les premieres dominos de la pile
	public List<Domino> distribuer(int nbRois) {

		if (index + nbRois > listeDomino.size()) {
			return new ArrayList<Domino>();
		}
		List<Domino> ListDomino = listeDomino.subList(index, index + nbRois);
		index = index + nbRois;
		return ListDomino;
	}
	
	
	

}
