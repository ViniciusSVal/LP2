import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;
import java.io.*;


import figures.*;
import buttons.*;

public class EdVetAPP {
	public static void main (String[] args) {
		// criando a tela
		Frame frame = new Frame();
	}
}

@SuppressWarnings("serial")
class Frame extends JFrame {
	ArrayList<Figure> figs = new ArrayList<Figure>();
	ArrayList<Botao> buttons = new ArrayList<Botao>();

	int mouseX, mouseY;
	int mouseButton;
	Figure figFocused;
	Botao butActive;

	@SuppressWarnings("unchecked")
	Frame() {
		for (int i = 0; i <= 5; i++) {
			buttons.add(new Botao(20, 50 + 50 * i, 40, 40, i));
		}

		try {
			FileInputStream 	f = new FileInputStream("proj.bin");
			ObjectInputStream 	o = new ObjectInputStream(f);
			this.figs = (ArrayList<Figure>) o.readObject();
			o.close();

			System.out.printf("Arquivo carregado\n");
			this.repaint();
		}
		catch (Exception x) {
			System.out.printf("Nenhum arquivo para ler\n");
		}

		this.addWindowListener (
			new WindowAdapter() {
				public void windowClosing (WindowEvent e) {

					try {
						FileOutputStream  f = new FileOutputStream("proj.bin");
						ObjectOutputStream o = new ObjectOutputStream(f);
						o.writeObject(figs);
						o.flush();
						o.close();

						System.out.printf("Arquivo salvo\n");
					}
					catch (Exception x) {}
					

					System.exit(0);
				}
			}
		);
		this.addKeyListener ( new KeyAdapter() {
			public void keyPressed (KeyEvent e) {
				int key = e.getKeyCode();

				switch (key) {
					case KeyEvent.VK_UP: //mover com as setas 
						if (figFocused != null) figFocused.drag(0, -5); break;
					case KeyEvent.VK_DOWN: 
						if (figFocused != null) figFocused.drag(0, 5); break;
					case KeyEvent.VK_LEFT: 
						if (figFocused != null) figFocused.drag(-5, 0); break;
					case KeyEvent.VK_RIGHT: 
						if (figFocused != null) figFocused.drag(5, 0); break;
					case KeyEvent.VK_R:
						figs.add(new Rect(
							mouseX,
							mouseY,
							100,
							75
						));
						break;
					case KeyEvent.VK_E: 
						figs.add(new Ellipse(
							mouseX,
							mouseY,
							100,
							75
						));
						break;
					case KeyEvent.VK_L: 
						figs.add(new Line(
							mouseX,
							mouseY,
							100,
							75
						));
						break;
					case KeyEvent.VK_T:
						figs.add(new Triangle(
							mouseX,
							mouseY,
							100,
							75
						));
						break;

					//Prova Prática 1
					case KeyEvent.VK_1:
						figs.add(new Carro(
							mouseX,
							mouseY,
							100,
							75			
						));
						break;
					case KeyEvent.VK_3:
						if (figFocused != null) {
							Figure copy = figFocused.copy();
							figs.add(copy);
							figFocused = copy;
						}
						break;

					case KeyEvent.VK_I:
						if (figFocused != null) 
							figUp(figs.indexOf(figFocused));	
						break;
					
					case KeyEvent.VK_K:
						if (figFocused != null) 
							figDown(figs.indexOf(figFocused));	
						break;

					case KeyEvent.VK_C:
						if (figFocused != null)
							figFocused.changeColor(Frame.this);
						break;
					case KeyEvent.VK_BACK_SPACE: //delete
						if (figFocused != null) {
							figs.remove(figFocused);
							figFocused = null;
						}
				}
				
				repaint();	
			}
		});
		this.addMouseListener ( new MouseAdapter() {
			public void mousePressed (MouseEvent e) {
				mouseButton = e.getButton();
				
				if (mouseButton == MouseEvent.BUTTON2) return; 
				
				//selecionando figuras
				figFocused = null;
				for (Figure fig : figs) 
					if (fig.pointInArea(mouseX, mouseY))
						figFocused = fig;
				
				//pressionando botões
				for (Botao but : buttons) 
					if (but.pointInArea(mouseX, mouseY)) {
						butActive = (but != butActive) ? but : null; 
						
						repaint();
						return;
					}
				
				repaint();
			}

			public void mouseClicked (MouseEvent e) {
				if (mouseButton == MouseEvent.BUTTON3) {
					if (figFocused != null) {
						figFocused.rightClick();
						repaint();
					}
				}
				else if (mouseButton == MouseEvent.BUTTON1)
				{
					//se pressionei algum botão, retorno
					for (Botao but : buttons) 
						if (but.pointInArea(mouseX, mouseY)) return;

					if (butActive == null) return;
					
					//se eu não pressionei nenhum botão agora e mantenho um botão pressionado
					switch (buttons.indexOf(butActive)) {
						case 0:
							figs.add(new Rect(
								mouseX,
								mouseY,
								100,
								75
							));
							break;
						case 1: 
							figs.add(new Ellipse(
								mouseX,
								mouseY,
								100,
								75
							));
							break;
						case 2: 
							figs.add(new Line(
								mouseX,
								mouseY,
								100,
								75
							));
							break;
						case 3:
							figs.add(new Triangle(
								mouseX,
								mouseY,
								100,
								75
							));
							break;

						case 4:
							figs.add(new Carro(
								mouseX,
								mouseY,
								100,
								75			
							));
							break;

						case 5: //deletar
							if (figFocused != null) {
								figs.remove(figFocused);
								figFocused = null;
							}
					}

					repaint();

				}
			}
		});
		this.addMouseMotionListener( new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				// Salvando posições do mouse
				mouseX = e.getX();
				mouseY = e.getY();
			}
			public void mouseDragged (MouseEvent e) {
				// Movendo uma figura ao arrastá-la

				if (figFocused == null) return;
				
				int dx, dy;
				dx = e.getX() - mouseX;
				dy = e.getY() - mouseY;	
				
				switch (mouseButton) {
					case MouseEvent.BUTTON1: // MOVER FIGURA
						figFocused.drag(dx, dy);
						break;
					case MouseEvent.BUTTON3: // REDIMENSIONAR FIGURA
						figFocused.redim(dx, dy); 
						break;
				}
				
				if (figFocused instanceof Triangle) 
					((Triangle)figFocused).redefineForm();

				//atualizando a posição salva do mouse
				mouseX = e.getX();
				mouseY = e.getY();
				
				repaint();
			}
		});

		this.setTitle("EdVet");
		this.setSize(720, 480);
		this.setVisible(true);
	}
	
	private void figUp(int index) {
		if (index >= figs.size()-1) return;

		Figure fig2 = figs.set(index+1, figs.get(index));
		figs.set(index, fig2);
	}
	private void figDown(int index) {
		if (index <= 0) return;
		
		Figure fig2 = figs.set(index-1, figs.get(index));
		figs.set(index, fig2);
	}

	public void paint (Graphics g) {
		super.paint(g); //redesenhando a tela
		Graphics2D g2d = (Graphics2D) g;

		for (Figure fig : figs) 
			fig.paint(g2d, figFocused == fig);
		
		for (Botao but : buttons) 
			but.paint(g2d, but == butActive);
	}

	

}
