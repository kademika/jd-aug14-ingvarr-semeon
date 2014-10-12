package lesson6.shapes.abstracts;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends AbstractShape {
	
	public Circle() {
		color = new Color(0, 0, 255); //blue
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setStroke(new BasicStroke(7));
		
		g.setColor(color);
				
		g.drawOval(400, 100, 100, 100);
		
		g.fillOval(400, 220, 100, 100);
	}
}
