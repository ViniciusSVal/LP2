package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rect extends Figure {
	// herdadas da classe Figure:
	//private int x, y; // pos
	//private int w, h; // dim
	
	//private Color lineColor; 	// cor de contorno
	//private Color bgColor; 	// cor de fundo

	public Rect (int x, int y, int w, int h, Color line, Color bg) {
		super(x, y, w, h, line, bg);
	}
	
	public Rect (int x, int y, int w, int h) {
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
		g2d.fillRect(this.x, this.y, this.w, this.h);

		//desenhando o contorno
		g2d.setPaint(this.lineColor);
		g2d.drawRect(this.x, this.y, this.w, this.h);
	}
}
