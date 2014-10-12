package lesson6.shapes.abstracts;

import java.awt.Color;

public abstract class AbstractShape implements Drawable {
	
	protected Color color;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
