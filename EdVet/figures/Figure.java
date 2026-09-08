package figures;

import java.awt.*;
import javax.swing.JFrame;

public abstract class Figure {
	protected int x,y, w,h;
	protected int depth;
	protected Color lineColor;
	protected Color bgColor;

	protected Figure (int x, int y, int w, int h, Color line, Color bg, int depth) {
		this.x = x; this.y = y;
		this.w = w; this.h = h;
		this.lineColor = line;
		this.bgColor = bg;
		this.depth = depth;
	}

	public void drag(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	public void redim (int dw, int dh) {
		this.w += dw;
		this.h += dh;
	}
	
	public int getDepth () {
		return this.depth;
	}
	public void setDepth (int depth) {
		this.depth = depth;
	}

	protected boolean pointInRect (int x, int y) {
		if ((this.x < x) && (x < this.x + this.w) &&
		    (this.y < y) && (y < this.y + this.h)) {
			return true;
		}
		
		return false;
	}

	public abstract boolean pointInArea(int x, int y);	
	public abstract void changeColor(JFrame frame);
	public abstract void paint(Graphics2D g2d);
	public abstract void paintFocus(Graphics2D g2d);
}
