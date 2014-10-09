package lesson6.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle extends Shape {

	@Override
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setStroke(new BasicStroke(7));
		
		g.setColor(new Color(0, 0, 0));
		
		g.drawPolygon(new int[]{240, 360, 360, 240}, new int[]{100, 100, 200, 200}, 4);
		
//		g.drawRect(240, 220, 120, 100);
		
		g.fillRect(240, 220, 120, 100);
	}
}
