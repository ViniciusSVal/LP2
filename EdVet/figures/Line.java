package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Line extends Figure {
	//private int x1, y1; // pos inicial
	//private int x2, y2; // pos final
	
	//private Color lineColor; 	// cor de "contorno"

	public Line (int x1, int y1, int x2, int y2, Color line) {
		super(x1, y1, x2, y2, line, Color.BLACK);
		
		
		//this.x = x1;
		//this.y = y1;
		//this.w = x2;
		//this.h = y2;
		//this.lineColor = line;
	}
	public Line (int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2, Color.BLACK, Color.BLACK);
	}

	public boolean pointInArea (int x, int y) {
		//if (this.x > x || x > this.w)

		if ((this.x < x) && (x < this.x + this.w) &&
		    (this.y < y) && (y < this.y + this.h)) {
			return true;
		}
		
		return false;
	}
	
	public void drag (int dx, int dy) {
		this.x += dx;
		this.y += dy;
		this.w += dx;
		this.h += dy;
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
