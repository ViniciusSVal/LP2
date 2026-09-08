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
					case KeyEvent.VK_UP: //mover com as setas 
						figs.get(0).drag(0, -5); break;
					case KeyEvent.VK_DOWN: 
						figs.get(0).drag(0, 5); break;
					case KeyEvent.VK_LEFT: 
						figs.get(0).drag(-5, 0); break;
					case KeyEvent.VK_RIGHT: 
						figs.get(0).drag(5, 0); break;
					case KeyEvent.VK_R:
						figs.add(new Rect(
							mouseX,
							mouseY,
							100,
							75,
							figs.size()
						));
						break;
					case KeyEvent.VK_E: 
						figs.add(new Ellipse(
							mouseX,
							mouseY,
							100,
							75,
							figs.size()
						));
						break;
					case KeyEvent.VK_L: 
						figs.add(new Line(
							mouseX,
							mouseY,
							100,
							75,
							figs.size()
						));
						break;
					case KeyEvent.VK_T:
						figs.add(new Triangle(
							mouseX,
							mouseY,
							100,
							75,
							figs.size()
						));
						break;
					case KeyEvent.VK_C:
						if (figFocused != null)
							figFocused.changeColor(Frame.this);
						break;
					case KeyEvent.VK_BACK_SPACE: //delete
						if (figFocused != null) {
							removeFig(figs.indexOf(figFocused));
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
				int indexFocused = 0;
				int n = figs.size();
				for (int i = 0; i < n; i++) {
					Figure fig = figs.get(i);
					//if (fig == null) return;
					if (fig.pointInArea(mouseX, mouseY)) {
						indexFocused = i;
						figFocused = fig;
						break;
					}
				}
					
				if (figFocused != null) {
					depthUp(indexFocused);
					//printList();
				}

				repaint();
			}

			public void mouseClicked (MouseEvent e) {
				if (mouseButton == MouseEvent.BUTTON3)
					if (figFocused instanceof Triangle) {
						((Triangle) figFocused).changeForm();
						repaint();
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
				
				switch (mouseButton) {
					case MouseEvent.BUTTON1: // MOVER FIGURA
						figFocused.drag(dx, dy);
						break;
					case MouseEvent.BUTTON3: // REDIMENSIONAR FIGURA
						figFocused.redim(dx, dy); 
						break;
				}
				
				if (figFocused instanceof Triangle) 
					((Triangle)figFocused).redefineForm();

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
	
	private void printList() {
		for (Figure fig : figs) {
			System.out.printf("%d ", fig.getDepth());
		}
		System.out.printf("\n");
	}

	private void depthUp(int index) {
		figs.add(0, figs.get(index));
		figs.get(0).setDepth(0);
		removeFig(index+1);
		
		int n = figs.size();
		for (int i = 1; i < n; i++) {
			Figure fig = figs.get(i);
			fig.setDepth(fig.getDepth()+1);
		}
	}

	private void removeFig(int index) {
		figs.remove(index); 	
		
		int n = figs.size();
		for (int i = index; i < n; i++) {
			Figure fig = figs.get(i);
			fig.setDepth(fig.getDepth()-1);
		}
	}

	/*
	private void sortDepth () { 
		int n = figs.size();
		
		for (int cellSize = 1; cellSize <= n-1; cellSize *= 2) {
			for (int i = 0; i < n-1; i += 2*cellSize) {
				int m = Math.min(i +   cellSize -1, n-1);
				int f = Math.min(i + 2*cellSize -1, n-1);
				
				mergeList(i, m, f);
			}
		}
		
		//int m = i/2 + f/2; //índice médio;
		//this.sortDepth(i, m);
		//this.sortDepth(m+1, f);
		//this.mergeList(i, m, f);
		
	}
	private void mergeList(int i, int m, int f) {
		int p1, p2;
		p1 = i; p2 = m+1;
		int t[] = new int[f-i+1];
		
		for (int k = 0; k < f-i+1; k++) {
			int v1, v2; 
			v1 = p1 <= m? figs.get(p1).getDepth() : 0; 
			v2 = p2 <= f? figs.get(p2).getDepth() : 0;
			
			if ((p2 > f) || ((p1 <= m) && (v1 < v2))) {
				t[k] = v1; p1++;
			}
			else {
				t[k] = v2; p2++;
			}
		}

		for (int k = 0; k < f-i+1; k++) {
				figs.get(k).setDepth( t[k] );
		}
	}
	*/

	public void paint (Graphics g) {
		super.paint(g); //redesenhando a tela
		Graphics2D g2d = (Graphics2D) g;

		int n = figs.size();
		for (int i = n-1; i >= 0; i--) {
			Figure fig = figs.get(i);
			fig.paint(g2d);
		}

		if (figFocused != null) figFocused.paintFocus(g2d);
	}

	

}
