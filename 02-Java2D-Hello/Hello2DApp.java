/* 
    ok a. altere as cores de fundo e dos gráficos
    ok b. adicione alguma outra primitiva gráfica (retângulo, elipse, imagem, etc)
    ok c. alguma outra modificação usando a sua criativide
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 600);
        this.setVisible(true);
    	this.setBackground(Color.green);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g; 	
	g2d.setBackground(Color.green);
	super.paint(g);
	this.setBackground(Color.green);
	int w = getWidth();
        int h = getHeight();

	// setando background
       	g2d.setPaint(Color.green);
	g2d.fillRect(0,0, w,h);

	int pointxs[] = {w/2, w-20, w/2, 20};
	int pointys[] = {40, h/2, h - 10, h/2};
	
	// desenhando um polígono um pouco mais complexo
       	g2d.setPaint(Color.yellow);	
	g2d.fillPolygon(pointxs, pointys, pointxs.length);
	
	g2d.setPaint(Color.blue);
	//g2d.fillOval(w/2-175, h/2-120, 350, 240);
	g2d.fillOval(w/4, h/4, w/2, h/2);

	g2d.setPaint(Color.blue);
    	
	//g2d.setPaint(Color.green);
	//g2d.drawShape(losango);
    }
}






















