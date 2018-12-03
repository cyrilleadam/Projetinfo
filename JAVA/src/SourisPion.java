import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SourisPion implements MouseListener {
	private Plateau plateau;
	private Roi roi;
	


public SourisPion(Roi roi, Plateau plateau){
	this.plateau=plateau;
	this.roi=roi;
}

public void mouseClicked(MouseEvent arg0) {
	
}

public void mouseEntered(MouseEvent arg0) {

}

public void mouseExited(MouseEvent arg0) {
	
}

public void mousePressed(MouseEvent arg0) {
	plateau.PlacerRoi(roi);
}

public void mouseReleased(MouseEvent arg0) {	
}
}