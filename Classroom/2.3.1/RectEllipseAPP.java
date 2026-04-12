import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.Rect;
import figures.Ellipse;
import figures.Line;

public class RectEllipseAPP {
	public static void main (String[] args) {
		// criando a tela
		Frame frame = new Frame();
		
		// RETANGULOS
		// adicionando o 1° retangulo na lista de retangulos
		Color outColor = new Color(128, 0, 64);
		Color bg = new Color(255, 0, 128);
		frame.rects[0] = new Rect(30, 30, 50, 100, outColor, bg);
		
		//adicionando o 2° retangulo na lista de retangulos
		outColor = new Color(0, 128, 64);
		bg = new Color(0, 255, 128);
		frame.rects[1] = new Rect(100, 50, 150, 75, outColor, bg);
	
		// ELIPSES
		//adicionando a 1° elipse na lista de retangulos
		outColor = new Color(64, 0, 128);
		bg = new Color(128, 0, 255);
		frame.ellips[0] = new Ellipse(75, 225, 300, 100, outColor, bg);

		//adicionando a 2° elipse na lista de retangulos
		outColor = new Color(0, 64, 128);
		bg = new Color(0, 128, 255);
		frame.ellips[1] = new Ellipse(275, 40, 310, 175, outColor, bg);

		//adicionando a 3° elipse na lista de retangulos
		outColor = new Color(128, 64, 0);
		bg = new Color(255, 128, 0);
		frame.ellips[2] = new Ellipse(400, 175, 175, 200, outColor, bg);
		
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
	Rect[] rects = new Rect[2];
	Ellipse[] ellips = new Ellipse[3];
	Line[] lines = new Line[3];

	Frame() {
		this.addWindowListener (
			new WindowAdapter() {
				public void windowClosing (WindowEvent e) {
					System.exit(0);
				}
			}
		);
		this.setTitle("Retangulos e Elipses");
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
