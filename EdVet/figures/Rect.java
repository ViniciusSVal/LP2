package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rect extends Figure {
	public Rect (int x, int y, int w, int h, Color line, Color bg) {
		super(x, y, w, h, line, bg);
	}
	
	public Rect (int x, int y, int w, int h) {
		super(x, y, w, h, Color.BLACK, Color.WHITE);
	}
	
	//duplicando o retângulo
	public Figure copy () {
		//construindo a figura com os mesmos escalares
		Rect r = new Rect(this.x, this.y, this.w, this.h);
		//e copiando as cores da forma certa
		r.lineColor = new Color(this.lineColor.getRGB());
		r.bgColor = new Color(this.bgColor.getRGB());
		
		//movendo a figura 20 pixels para baixo e para direita
		r.drag(20, 20);

		//retornando a cópia
		return r;
	}

	public boolean pointInArea (int x, int y) {
		return this.pointInRect(x, y);
	}

	public void changeColor (JFrame frame) {
		// trocando contorno
		String s = JOptionPane.showInputDialog(
			frame,
			"Cor de contorno",
			"000000"
		);
		
		if (s == null) return;
		
		int hex = Integer.parseInt(s, 16);
		this.lineColor = new Color(hex);
		
		// trocando background
		s = JOptionPane.showInputDialog(
			frame,
			"Cor de fundo",
			"ffffff"
		);

		if (s == null) return;

		hex = Integer.parseInt(s, 16);	
		this.bgColor = new Color(hex);
	}
	
       	public void drag (int dx, int dy) {
		dragRect(dx, dy);
	}	
       	public void redim (int dw, int dh) {
		redimRect(dw, dh);
	}	

	public void paint (Graphics2D g2d) {
		//desenhando o fundo
		g2d.setPaint(this.bgColor);
		g2d.fillRect(this.x, this.y, this.w, this.h);

		//desenhando o contorno
		g2d.setPaint(this.lineColor);
		g2d.drawRect(this.x, this.y, this.w, this.h);
	}
	public void paintFocus (Graphics2D g2d) {
		g2d.setPaint(Color.RED);
		g2d.drawRect(this.x+1, this.y+1, this.w-2, this.h-2);
		g2d.drawRect(this.x-1, this.y-1, this.w+2, this.h+2);
	}

	public void rightClick() {};
}
