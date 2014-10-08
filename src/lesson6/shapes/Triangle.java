package lesson6.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Triangle extends Shape {
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setStroke(new BasicStroke(7));
		
		g.setColor(new Color(255, 0, 0));
				
		g.drawPolygon(new int[]{50, 100, 0}, new int[]{0, 100, 100}, 3);
		
//		g.fillOval(100, 100, 100, 100);
	}
}
