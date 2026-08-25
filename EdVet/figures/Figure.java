package figures;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Figure {
	protected int x,y, w,h;
	protected Color lineColor;
	protected Color bgColor;
	
	protected Figure (int x, int y, int w, int h, Color line, Color bg) {
		this.x = x; this.y = y;
		this.w = w; this.h = h;
		this.lineColor = line;
		this.bgColor = bg;
	}

	public void drag(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	public void redim (int dw, int dh) {
		this.w += dw;
		this.h += dh;
	}

	protected boolean pointInRect(int x, int y) {
		if ((this.x < x) && (x < this.x + this.w) &&
		    (this.y < y) && (y < this.y + this.h)) {
			return true;
		}
		
		return false;
	}
	public abstract boolean pointInArea(int x, int y);	
	public abstract void paint(Graphics2D g2d);
	public abstract void paintFocus(Graphics2D g2d);
}
