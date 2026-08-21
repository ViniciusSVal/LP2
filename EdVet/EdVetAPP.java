import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

import figures.*;
//import figures.*.*;

public class EdVetAPP {
	public static void main (String[] args) {
		// criando a tela
		Frame frame = new Frame();
	}
}

class Frame extends JFrame {
	ArrayList<Figure> figs = new ArrayList<Figure>();

	int mouseX, mouseY;
	Figure figFocused;

	Frame() {
		this.addWindowListener (
			new WindowAdapter() {
				public void windowClosing (WindowEvent e) {
					System.exit(0);
					repaint();
				}
			}
		);
		this.addKeyListener ( new KeyAdapter() {
			public void keyTyped (KeyEvent e) {
				char key = e.getKeyChar();

				switch (key) {
					case 'a': // DEBUG: empurrando a ultima figura sempre que eu aperto A
						//rects[2].drag(1, 1);
						figs.get(figs.size()-1).drag(1, 1);
						break;
					case 'r':
						figs.add(new Rect(
							mouseX,
							mouseY,
							100,
							75
						));
						break;
					case 'e': 
						figs.add(new Ellipse(
							mouseX,
							mouseY,
							100,
							75
						));
						break;
					case 'l': 
						figs.add(new Line(
							mouseX,
							mouseY,
							mouseX + 100,
							mouseY + 75
						));		
				}

				repaint();
			}
		});
		this.addMouseListener ( new MouseAdapter() {
			public void mousePressed (MouseEvent e) {
				if (e.getButton() == 1) {
					figFocused = null;
					for (Figure fig : figs) {
						if (fig == null) return;
						if (fig.pointInArea(mouseX, mouseY)) 
							figFocused = fig;
					}
					/// projetando indicar quem é a figura focada
					//figFocused.setColor(new Color(255, 0, 0));
				}	
			}
		});
		this.addMouseMotionListener( new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				// Salvando posições do mouse
				mouseX = e.getX();
				mouseY = e.getY();
			}
			public void mouseDragged (MouseEvent e) {
				// Movendo uma figura ao arrastá-la

				if (figFocused == null) return;
				
				int dx, dy; 
			       	dx = e.getX() - mouseX;
				dy = e.getY() - mouseY;	

				figFocused.drag(dx, dy);

				//atualizando a posição salva do mouse
				mouseX = e.getX();
				mouseY = e.getY();

				repaint();
			}
		});

		this.setTitle("EdVet");
		this.setSize(600, 400);
		this.setVisible(true);
	}

	public void paint (Graphics g) {
		super.paint(g); //redesenhando a tela
		Graphics2D g2d = (Graphics2D) g;

		for (Figure fig : figs) fig.paint(g2d);
	}
}
