package buttons;

import java.awt.Graphics2D;
import java.awt.Color;

import ivisible.*;
import figures.*;

public class Botao implements IVisible {
	private int x, y;
	private int w, h;
	private Figure image;

	static private Color normalCol = new Color (192, 192, 192);
	static private Color selectCol = new Color (128, 128, 128);

	public Botao(int x, int y, int w, int h, int type) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		switch (type) {
			case 0: 
				this.image = new Rect(x+5, y+10, w-10, h-20);
				break;
			case 1:
				this.image = new Ellipse(x+5, y+5, w-10, h-10);
				break;
			case 2:
				this.image = new Line(x+5, y+5, w-10, h-10);
				break;
			case 3:
				this.image = new Triangle(x+5, y+5, w-10, h-10);
				break;
			case 4: 
				this.image = new Carro(x+5, y+5, w-10, h-10);
				break;
			default:
				this.image = null;
		}
	}

	//public void action (int x, int y) {

	//}

	public void paint (Graphics2D g2d, boolean focused) {
		//preenchendo o fundo
		if (focused)	g2d.setPaint(selectCol);
		else 		g2d.setPaint(normalCol);

		g2d.fillRect(this.x, this.y, this.w, this.h);
		g2d.setPaint(Color.BLACK);

		//contorno
		g2d.drawRect(this.x, this.y, this.w, this.h);
		
		//desenhando o ícone do botão
		if (this.image != null)
			image.paint(g2d, false);
		else { 
			//botão de deletar
			g2d.setPaint(Color.RED);
			g2d.drawLine(x+5, y+5, x+w-5, y+h-5);
			g2d.drawLine(x+5, y+h-5, x+w-5, y+5);
			g2d.setPaint(Color.BLACK);
		}
	}
	public boolean pointInArea (int x, int y) {
		return ((this.x < x && x < this.x + this.w) && 
			(this.y < y && y < this.y + this.h));
	}
}
