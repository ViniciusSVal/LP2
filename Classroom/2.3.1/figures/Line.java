package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Line {
	private int x1, y1; // pos inicial
	private int x2, y2; // pos final
	
	private Color lineColor; 	// cor de "contorno"

	public Line (int x1, int y1, int x2, int y2, Color line) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.lineColor = line;
	}

	public void drag (int dx1, int dy1, int dx2, int dy2) {
		this.x1 += dx1;
		this.y1 += dy1;
		this.x2 += dx2;
		this.y2 += dy2;
	}

	public void print () {
		System.out.printf("Linha com inicio em (%d, %d) e fim em (%d, %d)\n", 
				this.x1, this.y1, this.x2, this.y2);
	}

	public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		//desenhando a linha
		g2d.setPaint(this.lineColor);
		g2d.drawLine(this.x1, this.y1, this.x2, this.y2);
	}
}
