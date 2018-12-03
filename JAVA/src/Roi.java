import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JPanel;

import java.awt.Color;

public class Roi extends JPanel {
	private int nbJoueur;
	private Domino localisation;
	private Couleur couleur;


public Roi(Couleur couleur) {
	this.couleur=couleur;
	switch(couleur) {
	case ROUGE:
		setForeground(Color.RED);
	break;
	case VERT:
		setForeground(Color.GREEN);
	break;
	case JAUNE:
		setForeground(Color.YELLOW);
	break;
	case BLEU:
		setForeground(Color.BLUE);
	break;
	}
	
	
		
	}




public void paintComponent(Graphics g){
	Paint paint;
	Graphics2D g2d;
	if (g instanceof Graphics2D) {
		g2d = (Graphics2D) g;
	}
	else {
		System.out.println("Error");
		return;
	}
	paint = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
	g2d.setPaint(paint);
	g.fillOval(5, 5, getWidth()-10, getHeight()-10);
}

public Couleur getCouleur() {
	return couleur;
	}
}