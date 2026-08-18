package figures;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Figure {
	protected int x,y, w,h;
	protected Color lineColor;
	protected Color bgColor;
		
	protected boolean pointInRect(int x, int y) {
		if ((this.x < x) && (x < this.x + this.w) &&
		    (this.y < y) && (y < this.y + this.h)) {
			return true;
		}
		
		return false;
	}
	public abstract boolean pointInArea(int x, int y);	
	public abstract void drag(int dx, int dy);
	public abstract void paint(Graphics2D g2d);
}
