package lesson6.constructors;

public class Glyph {
	
	public Glyph() {
		System.out.println("Glyph#constructor");
		draw();
	}
	
	public void draw() {
		System.out.println("Glyph#draw()");
	}
}
