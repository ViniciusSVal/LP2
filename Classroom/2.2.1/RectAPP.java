import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.Rect;

public class RectAPP {
	public static void main (String[] args) {
		// criando a tela
		Frame frame = new Frame();
			
		// adicionando o 1° retangulo na lista de retangulos
		Color line = new Color(128, 0, 64);
		Color bg = new Color(255, 0, 128);
		frame.rects[0] = new Rect(30, 30, 50, 100, line, bg);
		
		//adicionando o 2° retangulo na lista de retangulos
		line = new Color(0, 128, 64);
		bg = new Color(0, 255, 128);
		frame.rects[1] = new Rect(100, 50, 150, 75, line, bg);
	
		//adicionando o 3° retangulo na lista de retangulos
		line = new Color(64, 0, 128);
		bg = new Color(128, 0, 255);
		frame.rects[2] = new Rect(75, 225, 300, 100, line, bg);

		//adicionando o 4° retangulo na lista de retangulos
		line = new Color(0, 64, 128);
		bg = new Color(0, 128, 255);
		frame.rects[3] = new Rect(275, 40, 310, 175, line, bg);

		//adicionando o 5° retangulo na lista de retangulos
		line = new Color(128, 64, 0);
		bg = new Color(255, 128, 0);
		frame.rects[4] = new Rect(400, 175, 175, 200, line, bg);
	}
}

class Frame extends JFrame {
	Rect[] rects = new Rect[5];

	Frame() {
		this.addWindowListener (
			new WindowAdapter() {
				public void windowClosing (WindowEvent e) {
					System.exit(0);
				}
			}
		);
		this.setTitle("Retangulos");
		this.setSize(600, 400);
		this.setVisible(true);
	}

	public void paint (Graphics g) {
		super.paint(g); //redesenhando a tela
		Graphics2D g2d = (Graphics2D) g;
		
		for (Rect fig : this.rects)
		{
			fig.paint(g);
		}
	}
}
