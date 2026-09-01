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

	public boolean pointInArea (int x, int y) {
		return this.pointInRect(x, y);
	}

	public void changeColor (JFrame frame) {
		// trocando contorno
		String s = JOptionPane.showInputDialog(frame,
				"Cor de contorno",
				JOptionPane.QUESTION_MESSAGE);
		int hex = Integer.parseInt(s, 16);
		this.lineColor = new Color(hex);
		
		// trocando background
		s = JOptionPane.showInputDialog(frame,
				"Cor de fundo",
				JOptionPane.QUESTION_MESSAGE);
		hex = Integer.parseInt(s, 16);	
		this.bgColor = new Color(hex);
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
}
