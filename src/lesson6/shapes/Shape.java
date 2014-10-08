package lesson6.shapes;

import java.awt.Graphics;

public class Shape {
	
	public void draw(Graphics g) {
		throw new IllegalStateException("I don't know how to paint this shape. Please override me!");
	}
}
