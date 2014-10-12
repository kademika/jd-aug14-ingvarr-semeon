package lesson6.constructors;

public class NPE extends Glyph {
	
	private String name = "NPE";
	
	@Override
	public void draw() {
		name.length();
	}
}
