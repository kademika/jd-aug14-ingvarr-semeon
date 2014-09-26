package lesson4.car;

public enum Colors {
	BLACK(0), DARK_GREY(1), GREY(2), DARK_BLUE(3), 
	BLUE(4), LIGHT_BLUE(5), VIOLET(6), DARK_GREEN(7), GREEN(8),
	LIGHT_GREEN(9), DARK_BROWN(10), BROWN(11), DARK_RED(12), 
	RED(13), YELLOW(14), ORANGE(15);
	
	private int id;
	
	private Colors(int id) {
		this.id = id;
	}
	
	Colors getDefaultColor() {
		return BLACK;
	}
}
