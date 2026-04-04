package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ellipse {
	private int x, y;
	private int w, h;

	private Color lineColor;
	private Color bgColor;

	public Ellipse (int x, int y, int w, int h, Color line, Color bg) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.lineColor = line;
		this.bgColor = bg;
	}

	public void print () {
		System.out.printf("Elipse de dimensoes W = %d e H = %d na posiçao (%d, %d)\n", 
				this.w, this.h, this.x, this.y);
	}

	public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		//desenhando o fundo
		g2d.setPaint(this.bgColor);
		g2d.fillOval(this.x, this.y, this.w, this.h);

		//desenhando o contorno
		g2d.setPaint(this.lineColor);
		g2d.drawOval(this.x, this.y, this.w, this.h);
	}
}
