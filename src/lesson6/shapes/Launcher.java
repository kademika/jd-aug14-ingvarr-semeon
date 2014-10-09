package lesson6.shapes;

public class Launcher {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[] {
			new Circle(),
			new Rectangle(),
			new Triangle(),
			new Square()
		};
		
		new ShapesTemplate(shapes);
	}

}
