package lesson6.constructors;

public class Launcher {

	public static void main(String[] args) {
		Glyph glyph = new RoundGlyph(10);
		glyph.draw();
		
		new NPE();
	}

}
