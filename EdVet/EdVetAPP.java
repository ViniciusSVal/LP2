import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import figures.*;
//import figures.*.*;

public class EdVetAPP {
	public static void main (String[] args) {
		// criando a tela
		Frame frame = new Frame();

		// RETANGULOS
		// adicionando o 1° retangulo na lista de retangulos
		Color outColor = new Color(128, 0, 64);
		Color bgColor = new Color(255, 0, 128);
		frame.rects[0] = new Rect(30, 30, 50, 100, outColor, bgColor);

		//adicionando o 2° retangulo na lista de retangulos
		outColor = new Color(0, 128, 64);
		bgColor = new Color(0, 255, 128);
		frame.rects[1] = new Rect(100, 50, 150, 75, outColor, bgColor);
		
		// ELIPSES
		//adicionando a 1° elipse na lista de retangulos
		outColor = new Color(64, 0, 128);
		bgColor = new Color(128, 0, 255);
		frame.ellips[0] = new Ellipse(75, 225, 300, 100, outColor, bgColor);

		//adicionando a 2° elipse na lista de retangulos
		outColor = new Color(0, 64, 128);
		bgColor = new Color(0, 128, 255);
		frame.ellips[1] = new Ellipse(275, 40, 310, 175, outColor, bgColor);

		//adicionando a 3° elipse na lista de retangulos
		outColor = new Color(128, 64, 0);
		bgColor = new Color(255, 128, 0);
		frame.ellips[2] = new Ellipse(400, 175, 175, 200, outColor, bgColor);
		
		// LINHAS
		// pegando dimensoes da tela
		int w = frame.getWidth();
		int h = frame.getHeight();

		// adicionando a 1° linha na lista de retangulos
		outColor = new Color(255, 0, 0);
		frame.lines[0] = new Line(0, 0, w, h, outColor);

		// adicionando a 2° linha na lista de retangulos
		outColor = new Color(0, 255, 0);
		frame.lines[1] = new Line(w/2, 0, w/2, h,outColor);

		// adicionando a 3° linha na lista de retangulos
		outColor = new Color(0, 0, 255);
		frame.lines[2] = new Line(0, h/2, w, h/2, outColor);
	}
}

class Frame extends JFrame {
	Rect[] rects = new Rect[10];
	Ellipse[] ellips = new Ellipse[3];
	Line[] lines = new Line[3];

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
				// DEBUG empurrando o quadrado sempre que eu aperto A
				if (e.getKeyChar() == 'a') {
					rects[0].drag(1, 1);
				}
				else if (e.getKeyChar() == 'r') {
					Random rand = new Random();
					rects.add(new Rect(
						rand.nextInt(600),
						rand.nextInt(400),
						rand.nextInt(100),
						rand.nextInt(100)
					));
				}

				repaint();
			}
		});
		this.addMouseListener ( new MouseAdapter() {
			public void mouseClicked (MouseEvent e) {
				Color col;
				switch (e.getButton()) {
					case 1:  col = new Color(255,0,0); break;
					case 2:  col = new Color(0,255,0); break;
					case 3:  col = new Color(0,0,255); break;
					default: col = new Color(0,0,0);
				}
				
				rects[0] = new Rect(e.getX(), e.getY(), 20, 20, new Color(0,0,0), col);
				
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

		for (Line fig : this.lines)
		{
			fig.paint(g);
		}
		for (Rect fig : this.rects)
		{
			fig.paint(g);
		}
		for (Ellipse fig : this.ellips)
		{
			fig.paint(g);
		}
	}
}
