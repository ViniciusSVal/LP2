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
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g; 
	int w = getWidth();
        int h = getHeight();
 	
	Shape losango = Shape(0,0, w/2,h/2, 0,0);

       	//g2d.setPaint(Color.red);
	//g2d.fillRect(0,0, w,h);
	g2d.setBackground(Color.red);

	g2d.setPaint(Color.blue);
	
	g2d.drawOval(w/2,h/2, w,h);
        g2d.drawLine(0,h, w,0);
    	
	g2d.setPaint(Color.green);
	g2d.drawShape(losango);
    }
}























