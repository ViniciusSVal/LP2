package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.geom.Line2D;

public class Line extends Figure {
	//private int x1, y1; // pos inicial
	//private int x2, y2; // pos final
	
	//private Color lineColor; 	// cor de "contorno"

	public Line (int x1, int y1, int x2, int y2, Color line) {
		super(x1, y1, x2, y2, line, Color.BLACK);
	}
	public Line (int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2, Color.BLACK, Color.BLACK);
	}

	public boolean pointInArea (int x, int y) {
		int x2 = this.x + this.w; 
		int y2 = this.y + this.h;

		return (Line2D.ptSegDist(this.x, this.y, x2, y2, x, y) < 20);
	}

	public void print () {
		System.out.printf("Linha com inicio em (%d, %d) e fim em (%d, %d)\n", 
				this.x, this.y, this.w, this.h);
	}

	public void changeColor(JFrame frame) {
		// trocando contorno
		String s = JOptionPane.showInputDialog(frame,
				"Cor de contorno",
				JOptionPane.QUESTION_MESSAGE);
		int hex = Integer.parseInt(s, 16);
		this.lineColor = new Color(hex);
	}
	public void paint (Graphics2D g2d) {
		//desenhando a linha
		g2d.setPaint(this.lineColor);
		
		int x2 = this.x + this.w;
		int y2 = this.y + this.h;
		g2d.drawLine(this.x, this.y, x2, y2);
	}
	public void paintFocus (Graphics2D g2d) {
		//desenhando a linha quando ela estiver em foco:
		g2d.setPaint(Color.RED);

		int x2 = this.x + this.w;
		int y2 = this.y + this.h;
		g2d.drawLine(this.x-1, this.y-1, x2-1, y2-1);
		g2d.drawLine(this.x+1, this.y+1, x2+1, y2+1);
	}
}
