package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.geom.Line2D;

public class Line extends Figure {
	public Line (int x, int y, int w, int h, Color line) {
		super(x, y, w, h, line, Color.BLACK);
	}
	public Line (int x, int y, int w, int h) {
		super(x, y, w, h, Color.BLACK, Color.BLACK);
	}

	//copiando a linha
	public Figure copy () {
		//copiando os escalares da linha
		Line l = new Line(this.x, this.y, this.w, this.h);
		//e copiando as cores da forma certa
		l.lineColor = new Color(this.lineColor.getRGB());
		/* a linha não utiliza a cor de fundo, então não tem necessidade de copiá-la */
		
		//movendo a figura 20 pixels para baixo e para direita
		l.drag(20, 20);

		//retornando a linha
		return l;
	}

	public boolean pointInArea (int x, int y) {
		int x2 = this.x + this.w; 
		int y2 = this.y + this.h;

		return (Line2D.ptSegDist(this.x, this.y, x2, y2, x, y) < 20);
	}

	public void print () {
		System.out.printf("Linha com inicio em (%d, %d) e fim em (%d, %d)\n", 
				this.x, this.y, this.w, this.h);
	}

	public void changeColor(JFrame frame) {
		// trocando contorno
		String s = JOptionPane.showInputDialog(
			frame,
			"Cor",
			"000000"
		);
		
		if (s == null) return;
		
		int hex = Integer.parseInt(s, 16);
		this.lineColor = new Color(hex);
	}
	
       	public void drag (int dx, int dy) {
		dragRect(dx, dy);
	}	
       	public void redim (int dw, int dh) {
		redimRect(dw, dh);
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

	public void rightClick() {};
}
