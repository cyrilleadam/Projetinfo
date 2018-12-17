import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SourisPion implements MouseListener {
	private Plateaubis plateaubis;
	private Roi roi;
	


public SourisPion(Roi roi, Plateaubis plateaubis){
	this.plateaubis=plateaubis;
	this.roi=roi;
}

public void mouseClicked(MouseEvent arg0) {
	
}

public void mouseEntered(MouseEvent arg0) {

}

public void mouseExited(MouseEvent arg0) {
	
}


public void mouseReleased(MouseEvent arg0) {	
}

public void mousePressed(MouseEvent arg0) {
	plateaubis.afficherPossibilites(roi);
}

}