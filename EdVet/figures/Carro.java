package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Carro extends Figure {
	Rect chassi;
	Ellipse roda1, roda2;

	//construtores da classe Carro
	public Carro (int x, int y, int w, int h, Color line, Color bg) {
		super(x, y, w, h, line, bg);
		//posicionando o chassi e as rodas do carro
		//(me parece que desta maneira fica mais facil de entender o que está acontecendo nesses construtores)
		this.chassi = new Rect(
					x,
			       		y,
			       		w,
			       		2*h/3,
			       		line, bg
						);
		this.roda1 = new Ellipse(
					x,
					y+h/3,
					w/2,
					2*h/3,
					line, bg
						);
		this.roda2 = new Ellipse(
					x+w/2,
					y+h/3,
					w/2,
					2*h/3,
					line, bg
						);
	}
	public Carro (int x, int y, int w, int h) {
		super(x, y, w, h, Color.BLACK, Color.WHITE);
		//posicionando o chassi e as rodas do carro	
		//(identico ao construtor de cima, exceto pela remoção dos parametros de cor)
		this.chassi = new Rect(x, y, w, 2*h/3);
		this.roda1 = new Ellipse(x, y+h/3, w/2, 2*h/3);
		this.roda2 = new Ellipse(x+w/2, y+h/3, w/2, 2*h/3);
	}

	//duplicando o carro
	public Figure copy () {
		//construindo a figura com os mesmos escalares
		Carro c = new Carro(this.x, this.y, this.w, this.h);
		//e copiando as cores da forma certa
		c.chassi.lineColor = new Color(this.chassi.lineColor.getRGB());
		c.roda1.lineColor = new Color(this.roda1.lineColor.getRGB());
		c.roda2.lineColor = new Color(this.roda2.lineColor.getRGB());
		c.chassi.bgColor = new Color(this.chassi.bgColor.getRGB());
		c.roda1.bgColor = new Color(this.roda1.bgColor.getRGB());
		c.roda2.bgColor = new Color(this.roda2.bgColor.getRGB());

		//movendo a figura 20 pixels para baixo e para direita
		c.drag(20, 20);

		//retornando a cópia
		return c;
	}

	//função que usarei para checar se a figura foi clicada
	public boolean pointInArea (int x, int y) {
		//retornando se eu cliquei no chassi, na roda 1, ou na roda 2
		return this.chassi.pointInArea(x, y) ||
			this.roda1.pointInArea(x, y) ||
			this.roda2.pointInArea(x, y);
	}

       	public void drag (int dx, int dy) {
		//arrastar cada parte do carro não afetará o formato dele
		this.x += dx;
		this.y += dy;
		this.chassi.drag(dx, dy);
		this.roda1.drag(dx, dy);
		this.roda2.drag(dx, dy);
	}	
       	public void redim (int dw, int dh) {
		//preciso de que caso uma peça não mova, nenhuma outra peça se mova, para que elas não se desalinhem
		if ( (-2 < dw)&&(dw < 2) ) dw = 0;
		if ( (-3 < dh)&&(dh < 3) ) dh = 0;	
		//redimensiono o carro
		redimRect(dw, dh);

		//atualizo as posições das peças do carro para as novas dimensões atuais
		this.chassi.redim(dw, 2*dh/3);
		this.roda1.drag(0, dh/3);
		this.roda1.redim(dw/2, 2*dh/3);
		this.roda2.drag(dw/2, dh/3);
		this.roda2.redim(dw/2, 2*dh/3);
			
		/*
		this.chassi.w += dw      	//this.w;
		this.chassi.h += 2*dh/3 	//2*this.h/3;
		
		this.roda1.y += dh/3   		//this.y+this.h/3;
	       	this.roda1.w = 			//this.w/2;
	       	this.roda1.h = 			//2*this.h/3;
		
		this.roda2.x = 			//this.x+this.w/2;
		this.roda2.y = 			//this.y+this.h/3;
		this.roda2.w = 			//this.w/2;
		this.roda2.h = 			//2*this.h/3;
		*/
	}	

	//funções de paint
	public void paint (Graphics2D g2d) {
		//simplesmente pedindo para as subfiguras se desenharem
		this.chassi.paint(g2d);
		this.roda1.paint(g2d);
		this.roda2.paint(g2d);
	}
	public void paintFocus (Graphics2D g2d) {
		//simplesmente pedindo para as subfiguras se desenharem
		this.chassi.paintFocus(g2d);
		
		//redesenhando as rodas para o chassi não se sobrepor sobre elas  
		this.roda1.paint(g2d);
		this.roda2.paint(g2d);

		this.roda1.paintFocus(g2d);
		this.roda2.paintFocus(g2d);
	}


	//função que muda a cor do carro
	public void changeColor (JFrame frame) {
		// trocando contorno do carro
		String s = JOptionPane.showInputDialog(
			frame,
			"Cor de contorno",
			"000000"
		);
		
		if (s == null) return;
		
		int hex = Integer.parseInt(s, 16);
		this.chassi.lineColor = new Color(hex);
		this.roda1.lineColor  = new Color(hex);
		this.roda2.lineColor  = new Color(hex);
		
		// trocando o fundo de cada peça
		s = JOptionPane.showInputDialog(
			frame,
			"Cor do chassi",
			"ffffff"
		);

		if (s == null) return;

		hex = Integer.parseInt(s, 16);	
		this.chassi.bgColor = new Color(hex);
		
		s = JOptionPane.showInputDialog(
			frame,
			"Cor das rodas",
			"ffffff"
		);

		if (s == null) return;

		hex = Integer.parseInt(s, 16);	
		this.roda1.bgColor = new Color(hex);
		this.roda2.bgColor = new Color(hex);
	}
	
	public void rightClick() {};
}
