package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import Figure;

public class Rect extends Figure {
	//private int x, y; // pos
	//private int w, h; // dim
	
	//private Color lineColor; 	// cor de contorno
	private Color bgColor; 		// cor de fundo

	public Rect (int x, int y, int w, int h, Color line, Color bg) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.lineColor = line;
		this.bgColor = bg;
	}
	
	public Rect (int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.lineColor = new Color(0,0,0);
		this.bgColor   = new Color(255,255,255);
	}

	public int area () {
		return this.w * this.h;
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
		System.out.printf("Retangulo de dimensoes W = %d e H = %d com area %d na posiçao (%d, %d)\n", 
				this.w, this.h, this.area(), this.x, this.y);
	}

	public void paint (Graphics2D g2d) {
		//desenhando o fundo
		g2d.setPaint(this.bgColor);
		g2d.fillRect(this.x, this.y, this.w, this.h);

		//desenhando o contorno
		g2d.setPaint(this.lineColor);
		g2d.drawRect(this.x, this.y, this.w, this.h);
	}
}
