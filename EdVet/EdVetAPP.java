import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

import figures.*;

public class EdVetAPP {
	public static void main (String[] args) {
		// criando a tela
		Frame frame = new Frame();
	}
}

class Frame extends JFrame {
	ArrayList<Figure> figs = new ArrayList<Figure>();

	int mouseX, mouseY;
	int mouseButton;
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
			public void keyPressed (KeyEvent e) {
				int key = e.getKeyCode();

				switch (key) {
					case KeyEvent.VK_UP: 
						figs.get(figs.size()-1).drag(0, -5); break;
					case KeyEvent.VK_DOWN: 
						figs.get(figs.size()-1).drag(0, 5); break;
					case KeyEvent.VK_LEFT: 
						figs.get(figs.size()-1).drag(-5, 0); break;
					case KeyEvent.VK_RIGHT: 
						figs.get(figs.size()-1).drag(5, 0); break;
					case KeyEvent.VK_R:
						figs.add(new Rect(
							mouseX,
							mouseY,
							100,
							75
						));
						break;
					case KeyEvent.VK_E: 
						figs.add(new Ellipse(
							mouseX,
							mouseY,
							100,
							75
						));
						break;
					case KeyEvent.VK_L: 
						figs.add(new Line(
							mouseX,
							mouseY,
							100,
							75
						));
						break;
					case KeyEvent.VK_BACK_SPACE: //delete
						if (figFocused != null) {
							figs.remove(figFocused);
							figFocused = null;
						}
				}
				
				repaint();
			}
		});
		this.addMouseListener ( new MouseAdapter() {
			public void mousePressed (MouseEvent e) {
				mouseButton = e.getButton();
				
				if (mouseButton == MouseEvent.BUTTON2) return; 
				
				figFocused = null;
				for (Figure fig : figs) {
					if (fig == null) return;
					if (fig.pointInArea(mouseX, mouseY))
						figFocused = fig;
				}
				repaint();
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
				
				switch (mouseButton) {
					case MouseEvent.BUTTON1: // MOVER FIGURA
						figFocused.drag(dx, dy);
						break;
					case MouseEvent.BUTTON3: // REDIMENSIONAR FIGURA
						figFocused.redim(dx, dy); 
						break;
					case MouseEvent.BUTTON2:
						System.out.printf("oi?");
				}

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
		
		if (figFocused != null) figFocused.paintFocus(g2d);
	}
}
