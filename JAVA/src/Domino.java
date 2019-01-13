import java.util.Comparator;

public class Domino {

	boolean roi;
	int numero;

	DemiDomino cote1;
	DemiDomino cote2;
	
	// Constructeur
	Domino(boolean roi, int numero, String nord, int couronneNord, String sud, int couronneSud) {

		this.roi = roi;
		this.numero = numero;
		this.cote1 = new DemiDomino(nord,couronneNord);
		this.cote2 = new DemiDomino(sud, couronneSud);		

	}

	public String toString() {

		return cote1.typeTerrain + " Couronne : " + cote1.nbrCouronne + " " + cote2.typeTerrain + " Couronne : "
				+ cote2.nbrCouronne + " numero : " + numero;
	}

	public static Comparator<Domino> ordreComparateur = new Comparator<Domino>() {
		public int compare(Domino d1, Domino d2) {
			return d1.numero - d2.numero;

		}
	};

}
