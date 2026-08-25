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
		//placeholder
		if (!this.pointInRect(x, y)) return false;

		//ax+b = y +- border
		//(x, y) = (this.x, this.y) + t(w, h)
		// x = this.x + t*this.w

		int x2 = this.x + this.w; 
		int y2 = this.y + this.h;
		//System.out.printf("%d,%d %d,%d\n", this.x, this.y, x2, y2);
		//return false;	
		
		float a = (float) (-this.h)/(this.w);
		float b = -this.y % a;
		
		System.out.printf("%.2f, %d\n", a*x+b, -y);

		return (a*x + b < -y + 5) && (a*x + b > -y - 5); 
	}

	public void print () {
		System.out.printf("Linha com inicio em (%d, %d) e fim em (%d, %d)\n", 
				this.x, this.y, this.w, this.h);
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
