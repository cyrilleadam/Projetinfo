import java.util.Comparator;

public class Domino {

	boolean roi;
	Terrain nord;
	Terrain sud;
	int couronneNord;
	int couronneSud;
	int numero;
	
	//Constructeur
	Domino(boolean roi, int numero, Terrain nord, int couronneNord, Terrain sud, int couronneSud){
		
		this.roi = roi;
		this.numero = numero;
		this.nord = nord;
		this.sud = sud;
		this.couronneNord = couronneNord;
		this.couronneSud = couronneSud;
		
	}
	
	public String toString() {
		
		return this.nord.toString() + " Couronne : " + this.couronneNord + " "
						 + this.sud.toString() + " Couronne : " + this.couronneSud + " numero : " + numero;
	}
	
	public static Comparator<Domino> ordreComparateur = new Comparator<Domino>() {
		public int compare(Domino d1, Domino d2) {
			return d1.numero - d2.numero;
			
		}
	};

}
