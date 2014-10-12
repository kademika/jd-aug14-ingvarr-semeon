package lesson6.shapes.abstracts;

import java.awt.Color;

public class Launcher {

	public static void main(String[] args) {
		Circle circle = new Circle();
		circle.setColor(new Color(100, 100, 155));
		Rectangle rectangle = new Rectangle();
		rectangle.setColor(new Color(100, 100, 100));
		Triangle triangle = new Triangle();
		triangle.setColor(new Color(155, 100, 100));
		Square square = new Square();
		square.setColor(new Color(100, 155, 100));
		
		Drawable[] shapes = new Drawable[] {
			circle,
			rectangle,
			triangle,
			square
		};
		
		new ShapesTemplate(shapes);
	}

}
