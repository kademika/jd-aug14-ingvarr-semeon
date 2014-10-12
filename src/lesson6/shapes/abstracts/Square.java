package lesson6.shapes.abstracts;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Square extends AbstractShape  {
	
	public Square() {
		color = new Color(0, 255, 0); //light green
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setStroke(new BasicStroke(7));
		
		g.setColor(color);
		
		g.drawPolygon(new int[]{270, 330, 330, 270}, new int[]{20, 20, 80, 80}, 4);
		
		g.fillPolygon(new int[]{270, 330, 330, 270}, new int[]{20, 20, 80, 80}, 4);
		
	}

}
