package figures;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class Triangle extends Figure {
	private int xPoints[] = new int[3];
	private int yPoints[] = new int[3];
	private Modes mode;
	public enum Modes {
		RECT,
		ISOS
	}
	//private Orients orient;
	//public enum Orients {
	//	UP_RIGHT,
	//	DOWN_RIGHT,
	//	UP_LEFT,
	//	DOWN_LEFT
	//}

	public Triangle (int x, int y, int w, int h, Color line, Color bg, int depth, Modes mode /*, Orients orient*/) {
		super(x, y, w, h, line, bg, depth);
		this.mode = mode;
	
		//this.orient = orient;
		this.redefineForm();
	}

	public Triangle (int x, int y, int w, int h, Color line, Color bg, int depth) {
		this(x, y, w, h, line, bg, depth, Modes.RECT /*, Orients.UP_RIGHT*/);	
	}

	public Triangle (int x, int y, int w, int h, int depth) {
		this(x, y, w, h, Color.BLACK, Color.WHITE, depth);
	}
	
	public void redefineForm () {
		switch (this.mode) {
			case Modes.RECT: 
				//triângulo retângulo
				this.xPoints[0] = this.x;
				this.yPoints[0] = this.y + this.h;
				
				this.xPoints[1] = this.x + this.w;
				this.yPoints[1] = this.y + this.h;

				this.xPoints[2] = this.x;
				this.yPoints[2] = this.y;
				break;
			case Modes.ISOS:
				//triângulo isósceles
				this.xPoints[0] = this.x;
				this.yPoints[0] = this.y + this.h;
				
				this.xPoints[1] = this.x + this.w;
				this.yPoints[1] = this.y + this.h;

				this.xPoints[2] = this.x + this.w/2;
				this.yPoints[2] = this.y;
				break;
			default:
		}
		
		/*
		switch (this.orient) {
			//case Orient.UP_RIGHT:
			case Orients.DOWN_RIGHT:
			case Orients.DOWN_LEFT:
				for (int y : this.yPoints) {
					if (y == this.y) 
						y = this.y + this.h;
					else if (y == this.y + this.h)
						y = this.y;
				}

				if (this.orient == Orients.DOWN_RIGHT)
					break;
			case Orients.UP_LEFT:
				for (int x : this.xPoints) {
					if (x == this.x) 
						x = this.x + this.w;
					else if (x == this.x + this.w)
						x = this.x;
				}

				break;
			default:
		}
		*/
	}
	
	public void changeForm () {
		this.mode = (mode == Modes.RECT) ? Modes.ISOS : Modes.RECT;
		

		//this.orient = orient;
		this.redefineForm();
	}

	public void changeColor (JFrame frame) {
		// trocando contorno
		String s = JOptionPane.showInputDialog(frame,
				"Cor de contorno",
				"000000");
				//JOptionPane.QUESTION_MESSAGE);
		
		if (s == null) return;

		int hex = Integer.parseInt(s, 16);
		this.lineColor = new Color(hex);
		
		// trocando background
		s = JOptionPane.showInputDialog(frame,
				"Cor de fundo",
				"ffffff");
				//JOptionPane.QUESTION_MESSAGE);
		
		if (s == null) return;
		
		hex = Integer.parseInt(s, 16);	
		this.bgColor = new Color(hex);
	}

	public boolean pointInArea (int x, int y) {
		Polygon p = new Polygon(this.xPoints, this.yPoints, 3);
		return p.contains(x, y);
	}

	public void paint (Graphics2D g2d) {
		//background
		g2d.setPaint(this.bgColor);
		g2d.fillPolygon(this.xPoints, this.yPoints, 3);
		
		//outline
		g2d.setPaint(this.lineColor);
		g2d.drawPolygon(this.xPoints, this.yPoints, 3);
	}
	public void paintFocus (Graphics2D g2d) {
		//Foco
		g2d.setPaint(Color.RED);
		
		int xs[] = new int[3];
		int ys[] = new int[3];
	
		for (int i = 0; i < 3; i++) {
			xs[i] =	(int) Math.signum(this.xPoints[i] - this.x - this.w/2);
			ys[i] = (int) Math.signum(this.yPoints[i] - this.y - this.h/2);

			xs[i] = this.xPoints[i] + xs[i];
			ys[i] = this.yPoints[i] + ys[i];

			/*
			if (this.xPoints[i] == this.x)
				xs[i] = this.x - 1;
			else if (this.xPoints[i] == this.x + this.w) 
				xs[i] = this.x + this.w + 1;
			else xs[i] = this.xPoints[i];

			if (this.yPoints[i] == this.y)
				ys[i] = this.y - 1;
			else if (this.yPoints[i] == this.y + this.h) 
				ys[i] = this.y + this.h + 1;	
			else ys[i] = this.yPoints[i];
			*/
		}

		g2d.drawPolygon(xs, ys, 3);
		
		for (int i = 0; i < 3; i++) {
			xs[i] =	(int) Math.signum(this.xPoints[i] - this.x - this.w/2);
			ys[i] = (int) Math.signum(this.yPoints[i] - this.y - this.h/2);

			xs[i] = this.xPoints[i] - xs[i];
			ys[i] = this.yPoints[i] - ys[i];
			
			/*
			if (this.xPoints[i] == this.x)
				xs[i] = this.x - 1;
			else if (this.xPoints[i] == this.x + this.w) 
				xs[i] = this.x + this.w + 1;
			else xs[i] = this.xPoints[i];

			if (this.yPoints[i] == this.y)
				ys[i] = this.y - 1;
			else if (this.yPoints[i] == this.y + this.h) 
				ys[i] = this.y + this.h + 1;	
			else ys[i] = this.yPoints[i];
			*/
		}

		g2d.drawPolygon(xs, ys, 3);
	}
}

