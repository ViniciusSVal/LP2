package ivisible;

import java.awt.Graphics2D;

public interface IVisible {
	void paint (Graphics2D g2d, boolean focused);
	boolean pointInArea(int x, int y);
}
