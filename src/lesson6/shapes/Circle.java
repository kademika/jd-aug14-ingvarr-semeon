package lesson6.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Shape {
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setStroke(new BasicStroke(7));
		
		g.setColor(new Color(255, 0, 0));
				
		g.drawOval(50, 100, 100, 100);
		
//		g.fillOval(100, 100, 100, 100);
	}
}
