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

		// RETANGULOS
		// adicionando o 1° retangulo na lista de retangulos
		Color outColor = new Color(128, 0, 64);
		Color bgColor = new Color(255, 0, 128);
		//frame.rects[0] = ...
		frame.figs.add( new Rect(30, 30, 50, 100, outColor, bgColor));

		//adicionando o 2° retangulo na lista de retangulos
		outColor = new Color(0, 128, 64);
		bgColor = new Color(0, 255, 128);
		//frame.rects[1] = ...
		frame.figs.add( new Rect(100, 50, 150, 75, outColor, bgColor));
		
		// ELIPSES
		//adicionando a 1° elipse na lista de retangulos
		outColor = new Color(64, 0, 128);
		bgColor = new Color(128, 0, 255);
		frame.figs.add( new Ellipse(75, 225, 300, 100, outColor, bgColor));

		//adicionando a 2° elipse na lista de retangulos
		outColor = new Color(0, 64, 128);
		bgColor = new Color(0, 128, 255);
		frame.figs.add( new Ellipse(275, 40, 310, 175, outColor, bgColor));

		//adicionando a 3° elipse na lista de retangulos
		outColor = new Color(128, 64, 0);
		bgColor = new Color(255, 128, 0);
		frame.figs.add( new Ellipse(400, 175, 175, 200, outColor, bgColor));
		
		// LINHAS
		// pegando dimensoes da tela
		int w = frame.getWidth();
		int h = frame.getHeight();

		// adicionando a 1° linha na lista de retangulos
		outColor = new Color(255, 0, 0);
		frame.figs.add( new Line(0, 0, w, h, outColor));

		// adicionando a 2° linha na lista de retangulos
		outColor = new Color(0, 255, 0);
		frame.figs.add( new Line(w/2, 0, w/2, h,outColor));

		// adicionando a 3° linha na lista de retangulos
		outColor = new Color(0, 0, 255);
		frame.figs.add( new Line(0, h/2, w, h/2, outColor));
	}
}

class Frame extends JFrame {
	//Rect[] rects = new Rect[10];
	ArrayList<Figure> figs = new ArrayList<Figure>();
	//Ellipse[] ellips = new Ellipse[3];
	//Line[] lines = new Line[3];

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

				// DEBUG: empurrando a ultima figura sempre que eu aperto A
				if (key == 'a') {
					//rects[2].drag(1, 1);
					figs.get(figs.size()-1).drag(1, 1);
				}
				else if (key == 'r') {
					Random rand = new Random();
					figs.add(new Rect(
						rand.nextInt(600),
						rand.nextInt(400),
						rand.nextInt(200),
						rand.nextInt(200),	
						new Color(0,0,0),
						new Color(0,0,0)	
					));
				}
				else if (key == 'e') {
					Random rand = new Random();
					figs.add(new Ellipse(
						rand.nextInt(600),
						rand.nextInt(400),
						rand.nextInt(200),
						rand.nextInt(200),	
						new Color(0,0,0),
						new Color(0,0,0)	
					));
				}
				else if (key == 'l') {
					Random rand = new Random();
					figs.add(new Line(
						rand.nextInt(600),
						rand.nextInt(400),
						rand.nextInt(200),
						rand.nextInt(200),	
						new Color(0,0,0)
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
				
				//rects[2] ...
				figs.add(new Rect(e.getX(), e.getY(), 20, 20, new Color(0,0,0), col));
				
				repaint();
			}
			public void mouseDragged (MouseEvent e) {
				//for (fig )
			}
		});

		this.setTitle("EdVet");
		this.setSize(600, 400);
		this.setVisible(true);
	}

	public void paint (Graphics g) {
		super.paint(g); //redesenhando a tela
		Graphics2D g2d = (Graphics2D) g;

		for (Figure fig : figs) {
			fig.paint(g2d);
		}

		/*
		for (Line fig : this.lines)
		{
			if (fig == null) break;
			fig.paint(g2d);
		}
		for (Rect fig : this.rects)
		{
			if (fig == null) break;
			fig.paint(g2d);
		}
		for (Ellipse fig : this.ellips)
		{
			if (fig == null) break;
			fig.paint(g2d);
		}*/
	}
}
