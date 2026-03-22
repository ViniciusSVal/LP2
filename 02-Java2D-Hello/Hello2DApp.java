/* 
    ok a. altere as cores de fundo e dos graficos
    ok b. adicione alguma outra primitiva grafica (retangulo, elipse, imagem, etc)
    ok c. alguma outra modificaçao usando a sua criativide
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
	//limpando a tela
	super.paint(g);

	// iniciando o contexto grafico e variaveis auxiliares 
        Graphics2D g2d = (Graphics2D) g; 	
	int w = getWidth();
        int h = getHeight();
	int SPACE = 20; 	// espaço das bordas para o losango
	final int BAR = 25; 	// altura da barra superior do aplicativo (pelo menos na minha maquina)

	// a) setando o background
	g2d.setPaint(Color.green);
	g2d.fillRect(0,0, w,h); // aqui e necessario a barra estar contando na altura, pois se nao ele nao preenche a tela inteira

	// desconsiderando a barra 
	h -= BAR;
	
	// c) desenhando um poligono um pouco mais complexo
	int pointxs[] = {w/2, 		w -SPACE, 	w/2,		0 +SPACE};
	int pointys[] = {0 +BAR+SPACE,	h/2 +BAR, 	h +BAR-SPACE, 	h/2 +BAR};

       	g2d.setPaint(Color.yellow);	
	g2d.fillPolygon(pointxs, pointys, pointxs.length);

	// b) desenhando primitivas graficas
	SPACE /= 2;
	g2d.setPaint(Color.blue);
	g2d.fillOval(w/4 +SPACE, h/4 +BAR+SPACE,   (3*w)/4 -(w/4) -2*SPACE, 3*h/4 -(h/4) -2*SPACE);
    }
}






















