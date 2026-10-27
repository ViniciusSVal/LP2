package buttons;

import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

import ivisible.*;
import figures.*;

public class Botao implements IVisible {
	private int x, y;
	private int w, h;
	private int type;
	private Figure image;

	static private Color normalCol = new Color (192, 192, 192);
	static private Color selectCol = new Color (128, 128, 128);

	public Botao(int x, int y, int w, int h, int type) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		this.type = type;
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
			case 5: //deletar
			case 6: //mudar cor
				this.image = null;
				break;
		}
	}

	public void action (int mouseX, int mouseY, ArrayList<Figure> figs, Figure figFocused, JFrame thisFrame) {
		switch (this.type) {
			case 0: // add Rect
				figs.add(new Rect(
					mouseX,
					mouseY,
					100,
					75
				));
				break;
			case 1: // add Ellipse
				figs.add(new Ellipse(
					mouseX,
					mouseY,
					100,
					75
				));
				break;
			case 2: // add Line
				figs.add(new Line(
					mouseX,
					mouseY,
					100,
					75
				));
				break;
			case 3: // add Triangle
				figs.add(new Triangle(
					mouseX,
					mouseY,
					100,
					75
				));
				break;
			case 4: // add Carro
				figs.add(new Carro(
					mouseX,
					mouseY,
					100,
					75			
				));
				break;
			case 5: // deletar
				if (figFocused != null) {
					figs.remove(figFocused);
					figFocused = null;
				}
				break;
			// Questão 1 PF
			case 6: // mudar cor
				if (figFocused != null) {
					figFocused.changeColor(thisFrame);
				}
				break;
		}
	}

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
			switch (this.type) {
				case 5:
					//botão de deletar
					g2d.setPaint(Color.RED);
					g2d.drawLine(x+5, y+5, x+w-5, y+h-5);
					g2d.drawLine(x+5, y+h-5, x+w-5, y+5);
					g2d.setPaint(Color.BLACK);
					break;	
				case 6:
					//botão de mudar de cor
					g2d.setPaint(Color.RED);
					g2d.fillOval(this.x, this.y, this.w/2, this.h/2);
					g2d.setPaint(Color.GREEN);
					g2d.fillOval(this.x+this.w/2, this.y, this.w/2, this.h/2);
					g2d.setPaint(Color.BLUE);
					g2d.fillOval(this.x, this.y+this.h/2, this.w/2, this.h/2);
					g2d.setPaint(Color.YELLOW);
					g2d.fillOval(this.x+this.w/2, this.y+this.h/2, this.w/2, this.h/2);
					
					break;
			}
		}
	}
	public boolean pointInArea (int x, int y) {
		return ((this.x < x && x < this.x + this.w) && 
			(this.y < y && y < this.y + this.h));
	}
}
