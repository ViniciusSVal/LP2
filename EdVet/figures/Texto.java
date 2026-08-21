package figures

import java.awt.Graphics2D

public class Text extends Figure {
	String string = "";
	int size = 12;

	public void paint (Graphics2D g2d) {
		g2d.setPaint(this.lineColor)
		g2d.drawString(this.string, this.x, this.y);
	}

}

