package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ellipse extends Figure {
	//private int x, y;
	//private int w, h;

	//private Color lineColor;
	private Color bgColor;

	public Ellipse (int x, int y, int w, int h, Color line, Color bg) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.lineColor = line;
		this.bgColor = bg;
	}
	
	public boolean pointInArea (int x, int y) {
		if ((this.x < x) && (x < this.x + this.w) && 
		    (this.y < y) && (y < this.y + this.h)) {
			return true;
		}
		
		return false;
	}
	
	public void drag (int dx, int dy) {
		this.x += dx;
		this.y += dy;
	} 

	public void print () {
		System.out.printf("Elipse de dimensoes W = %d e H = %d na posiçao (%d, %d)\n", 
				this.w, this.h, this.x, this.y);
	}

	public void paint (Graphics2D g2d) {
		//desenhando o fundo
		g2d.setPaint(this.bgColor);
		g2d.fillOval(this.x, this.y, this.w, this.h);

		//desenhando o contorno
		g2d.setPaint(this.lineColor);
		g2d.drawOval(this.x, this.y, this.w, this.h);
	}
}
