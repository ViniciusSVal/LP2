package figures;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Figure {
	protected int x,y, w,h;
	protected Color lineColor;
	
	public abstract void paint(Graphics2D g2d);
}
