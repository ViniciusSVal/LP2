package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Line extends Figure {
	//private int x1, y1; // pos inicial
	//private int x2, y2; // pos final
	
	//private Color lineColor; 	// cor de "contorno"

	public Line (int x1, int y1, int x2, int y2, Color line) {
		this.x = x1;
		this.y = y1;
		this.w = x2;
		this.h = y2;
		this.lineColor = line;
	}

	public void drag (int dx1, int dy1, int dx2, int dy2) {
		this.x += dx1;
		this.y += dy1;
		this.w += dx2;
		this.h += dy2;
	}

	public void print () {
		System.out.printf("Linha com inicio em (%d, %d) e fim em (%d, %d)\n", 
				this.x, this.y, this.w, this.h);
	}

	public void paint (Graphics2D g2d) {
		//desenhando a linha
		g2d.setPaint(this.lineColor);
		g2d.drawLine(this.x, this.y, this.w, this.h);
	}
}
