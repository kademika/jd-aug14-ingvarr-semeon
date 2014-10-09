package lesson6.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Square extends Rectangle {
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setStroke(new BasicStroke(7));
		
		g.setColor(new Color(0, 255, 0));
		
		g.drawPolygon(new int[]{240, 360, 360, 240}, new int[]{50, 50, 100, 100}, 4);
	}
}
