package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ellipse extends Figure {
	//private int x, y;
	//private int w, h;

	//procteced Color lineColor;
	//protected Color bgColor;

	public Ellipse (int x, int y, int w, int h, Color line, Color bg) {
		super(x, y, w, h, line, bg);

		//this.x = x;
		//this.y = y;
		//this.w = w;
		//this.h = h;
		//this.lineColor = line;
		//this.bgColor = bg;
	}
	public Ellipse (int x, int y, int w, int h) {
		super(x, y, w, h, Color.BLACK, Color.WHITE);
	}
	
	public boolean pointInArea (int x, int y) {
		return this.pointInRect(x, y);
	}

	public void drag (int dx, int dy) {
		this.x += dx;
		this.y += dy;
	} 

	public void paint (Graphics2D g2d) {
		//desenhando o fundo
		g2d.setPaint(this.bgColor);
		g2d.fillOval(this.x, this.y, this.w, this.h);

		//desenhando o conto'rno
		g2d.setPaint(this.lineColor);
		g2d.drawOval(this.x, this.y, this.w, this.h);
	}
}
